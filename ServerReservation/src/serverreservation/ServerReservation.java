/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package serverreservation;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import static serverreservation.User.checkLogin;
import static serverreservation.User.checkRegister;

/**
 *
 * @author natha
 */
public class ServerReservation extends javax.swing.JFrame implements Runnable {

    static ArrayList<User> daftarPengguna = new ArrayList<User>();
    static ArrayList<Ticket> daftarTiket = new ArrayList<Ticket>();
    static ArrayList<Reservation> daftarReservasi = new ArrayList<Reservation>();
    ArrayList<HandleSocket> clients = new ArrayList<HandleSocket>();

    static boolean login = false;
    Thread t;
    Socket incoming;
    ServerSocket s = new ServerSocket(6000);

    /**
     * @param args the command line arguments
     */
    public ServerReservation() throws IOException, Exception {
        if (t == null) {
            t = new Thread(this, "Server");
            t.start();
        }
    }

    public void broadCast(String tmp) {
        for (HandleSocket client : clients) {
            client.sendChat(tmp);
        }
    }

    public void showChat(String tmp) {
        broadCast(tmp);
    }

    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        daftarPengguna.add(new User(1, "Nathanael Steven", "nathsteve13", "nathanael@gmail.com", "123123", LocalDate.now(), LocalDate.now()));
        daftarTiket.add(new Ticket(1, "Plane", "tiket pesawat", "Surabaya", "Bali", 100,
                LocalDate.now(), 500000, LocalDate.now(), LocalDate.now()));
        try {
            Socket incoming;
            String message;
            ServerSocket s = new ServerSocket(6000);
            while (true) {
                incoming = s.accept();

                BufferedReader msgFClient = new BufferedReader(
                        new InputStreamReader(incoming.getInputStream()));
                message = msgFClient.readLine();
                String command = message;
                String[] commands = command.split("~");
                System.out.println(command);

                DataOutputStream msgToClient = new DataOutputStream(incoming.getOutputStream());
                int idPengguna = 0;
                if (commands[0].equals("LOGIN")) {
                    boolean tmp;
                    tmp = checkLogin(commands[1], commands[2]);
                    if (tmp) {
                        for (User user : daftarPengguna) {
                            if (commands[1].equals(user.getUsername())) {
                                idPengguna = user.getId();
                            }
                        }
                        msgToClient.writeBytes("TRUE~" + idPengguna + "\n");
                        login = true;
                    } else {
                        msgToClient.writeBytes("FALSE\n");
                    }
                } else if (commands[0].equals("REGISTER")) {
                    boolean check;
                    check = checkRegister(commands[3], commands[4]);
                    int id = 0;

                    DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                    if (check) {
                        if (!daftarPengguna.isEmpty()) {
                            User userTerakhir = daftarPengguna.get(daftarPengguna.size() - 1);
                            id = userTerakhir.getId() + 1;
                            daftarPengguna.add(new User(id, commands[2], commands[3],
                                    commands[4], commands[5], LocalDate.parse(commands[6], inputFormatter), LocalDate.parse(commands[7])));
                            msgToClient.writeBytes("TRUE\n");
                        } else if (daftarPengguna.isEmpty()) {
                            daftarPengguna.add(new User(1, commands[2], commands[3],
                                    commands[4], commands[5], LocalDate.parse(commands[6], inputFormatter), LocalDate.parse(commands[7])));
                            msgToClient.writeBytes("TRUE\n");
                        } else {
                            msgToClient.writeBytes("FALSE\n");
                        }
                    } else {
                        msgToClient.writeBytes("FALSE\n");
                    }
                } else if (commands[0].equals("ADD")) {
                    int id = 0;
                    DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    if (!daftarTiket.isEmpty()) {
                        Ticket tiketTerakhir = daftarTiket.get(daftarTiket.size() - 1);
                        id = tiketTerakhir.getId() + 1;
                        daftarTiket.add(new Ticket(id, commands[2], commands[3], commands[4], commands[5], Integer.parseInt(commands[6]), LocalDate.parse(commands[7], inputFormatter), Float.parseFloat(commands[8]),
                                LocalDate.parse(commands[9]), LocalDate.parse(commands[10])));
                        msgToClient.writeBytes("TRUE\n");
                    } else {
                        daftarTiket.add(new Ticket(Integer.parseInt(commands[1]), commands[2], commands[3], commands[4], commands[5], Integer.parseInt(commands[6]), LocalDate.parse(commands[7], inputFormatter), Float.parseFloat(commands[8]),
                                LocalDate.parse(commands[9]), LocalDate.parse(commands[10])));
                        msgToClient.writeBytes("TRUE\n");
                    }
                } else if (commands[0].equals("SEARCH")) {
                    ArrayList<Ticket> listTiket = new ArrayList<Ticket>();
                    for (Ticket ticket : daftarTiket) {
                        if (commands[1].equals(ticket.getTicket_name()) && commands[2].equals(ticket.getAsal())
                                && commands[3].equals(ticket.getTujuan()) && commands[4].equals(ticket.getTicket_date().toString()) ) {
                            listTiket.add(ticket);
                        }
                    }

                    msgToClient.writeInt(listTiket.size());

                    for (Ticket ticket : listTiket) {
                        msgToClient.writeUTF(Integer.toString(ticket.id));
                        msgToClient.writeUTF(ticket.ticket_name);
                        msgToClient.writeUTF(ticket.asal);
                        msgToClient.writeUTF(ticket.tujuan);
                        msgToClient.writeUTF(Integer.toString(ticket.jumlah_ticket));
                        msgToClient.writeUTF(ticket.ticket_desc);
                        msgToClient.writeUTF(ticket.ticket_date.toString());
                        msgToClient.writeUTF(Double.toString(ticket.ticket_price));
                        msgToClient.writeUTF(ticket.created_date.toString());
                        msgToClient.writeUTF(ticket.updated_date.toString());
                    }

                } else if (commands[0].equals("SHOW")) {
                    msgToClient.writeInt(daftarTiket.size());

                    for (Ticket ticket : daftarTiket) {
                        msgToClient.writeUTF(Integer.toString(ticket.id));
                        msgToClient.writeUTF(ticket.ticket_name);
                        msgToClient.writeUTF(ticket.asal);
                        msgToClient.writeUTF(ticket.tujuan);
                        msgToClient.writeUTF(Integer.toString(ticket.jumlah_ticket));
                        msgToClient.writeUTF(ticket.ticket_desc);
                        msgToClient.writeUTF(ticket.ticket_date.toString());
                        msgToClient.writeUTF(Double.toString(ticket.ticket_price));
                        msgToClient.writeUTF(ticket.created_date.toString());
                        msgToClient.writeUTF(ticket.updated_date.toString());
                    }
                } else if (commands[0].equals("BOOK")) {
                    User user = new User();
                    user.setId(Integer.parseInt(commands[3]));
                    Ticket ticket = new Ticket();
                    ticket.setId(Integer.parseInt(commands[1]));
                    for (Ticket tickets : daftarTiket) {
                        if (Integer.parseInt(commands[1]) == tickets.getId()) {
                            daftarReservasi.add(new Reservation(user, ticket, Integer.parseInt(commands[2]),
                                    LocalDate.now(), LocalDate.now()));
                            int jumlah = tickets.getJumlah_ticket();
                            if (jumlah >= Integer.parseInt(commands[2])) {
                                jumlah -= Integer.parseInt(commands[2]);
                                tickets.setJumlah_ticket(jumlah);
                                msgToClient.writeBytes("TRUE\n");
                            } else {
                                msgToClient.writeBytes("FALSE\n");
                            }
                        } else {
                            msgToClient.writeBytes("FALSE\n");
                        }
                    }
                }

            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                incoming = s.accept();
                HandleSocket hs = new HandleSocket(this, incoming);
                hs.start();
                clients.add(hs);
            } catch (IOException ex) {
                Logger.getLogger(ServerReservation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
