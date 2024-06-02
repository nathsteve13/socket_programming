
package com.mycompany.uireservation160422124;

import java.time.LocalDate;

public class Ticket {

    public int id;
    public String ticket_name;
    public String ticket_desc;
    public String asal;
    public String tujuan;
    public int jumlah_ticket;
    public LocalDate ticket_date;
    public float ticket_price;
    public LocalDate created_date;
    public LocalDate updated_date;   
    
    public Ticket() throws Exception{
        setId(0);
        setTicket_name("ticket_name");
        setTicket_desc("ticket_desc");
        setAsal("");
        setTujuan("");
        setJumlah_ticket(0);
        setTicket_date(LocalDate.now());
        setTicket_price(0);
        setCreated_date(LocalDate.now());
        setUpdated_date(LocalDate.now());
    }
    public Ticket(int id, String ticket_name, String ticket_desc, String asal, String tujuan ,int jumlah_ticket, LocalDate ticket_date, float ticket_price, LocalDate created_date, LocalDate updated_date) throws Exception{
        setId(id);
        setTicket_name(ticket_name);
        setTicket_desc(ticket_desc);
        setAsal(asal);
        setTujuan(tujuan);
        setJumlah_ticket(jumlah_ticket);
        setTicket_date(ticket_date);
        setTicket_price(ticket_price);
        setCreated_date(created_date);
        setUpdated_date(updated_date);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTicket_name() {
        return ticket_name;
    }

    public void setTicket_name(String ticket_name) throws Exception{
        if (ticket_name == "") {
            throw(new Exception("Ticket name can not be empty!"));
        }
        else {
            this.ticket_name = ticket_name;
        }
    }

    public String getTicket_desc() {
        return ticket_desc;
    }

    public void setTicket_desc(String ticket_desc) throws Exception{
        if (ticket_desc == "") {
            throw(new Exception("Ticket description can not be empty!"));
        }
        else {
            this.ticket_desc = ticket_desc;
        }
    }

    public LocalDate getTicket_date() {
        return ticket_date;
    }

    public void setTicket_date(LocalDate ticket_date) {
        this.ticket_date = ticket_date;
    }

    public float getTicket_price() {
        return ticket_price;
    }

    public void setTicket_price(float ticket_price) {
        this.ticket_price = ticket_price;
    }

    public LocalDate getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDate created_date) {
        this.created_date = created_date;
    }

    public LocalDate getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(LocalDate updated_date) {
        this.updated_date = updated_date;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public int getJumlah_ticket() {
        return jumlah_ticket;
    }

    public void setJumlah_ticket(int jumlah_ticket) {
        this.jumlah_ticket = jumlah_ticket;
    }
    
}
