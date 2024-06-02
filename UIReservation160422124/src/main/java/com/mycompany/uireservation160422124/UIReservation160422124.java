///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// */
//
//package com.mycompany.uireservation160422124;
//
//import serverreservation.Ticket;
//import serverreservation.Reservation;
//import serverreservation.User;
//import java.time.LocalDate;
//import java.util.Scanner;
//
///**
// *
// * @author natha
// */
//public class UIReservation160422124 {
//
//    public static void main(String[] args) {
//        try {
//            Scanner input = new Scanner(System.in);
//            User user = new User();
//            System.out.print("ID           : ");
//            user.setId(input.nextInt());
//            
//            System.out.print("Full name    : ");
//            user.setFullName(input.next());
//            
//            System.out.print("Username     : ");
//            user.setUsername(input.next());
//            
//            System.out.print("Password     : ");
//            user.setPassword(input.next());
//            
//            System.out.print("Email        : ");
//            user.setEmail(input.next());
//            
//            System.out.print("DOB          : ");
//            String tanggalInputDOB = input.next();
//            LocalDate dob = LocalDate.parse(tanggalInputDOB);
//            user.setDob(dob);
//            
//            user.setMemberSince(LocalDate.now());
//            
//            System.out.println("---------------- USER DETAILS ----------------");
//            System.out.println("ID User      : " + user.getId());
//            System.out.println("Full name    : " + user.getFullName());
//            System.out.println("Username     : " + user.getUsername());
//            System.out.println("Password     : " + user.getPassword());
//            System.out.println("Email        : " + user.getEmail());
//            System.out.println("Job          : " + user.getDob());
//            System.out.println("Member since : " + user.getMemberSince());
//            System.out.println("----------------------------------------------");
//            
//            Ticket ticket = new Ticket();
//            System.out.print("ID Ticket    : ");
//            ticket.setId(input.nextInt());
//            System.out.print("Ticket name  : ");
//            ticket.setTicket_name(input.next());
//            System.out.print("Ticket desc  : ");
//            ticket.setTicket_desc(input.next());
//            System.out.print("Ticket date    : ");
//            String ticketd = input.next();
//            LocalDate td = LocalDate.parse(ticketd);
//            ticket.setTicket_date(td);
//            System.out.print("Ticket price   : ");
//            ticket.setTicket_price(input.nextFloat());
//            System.out.print("Created date   : ");
//            ticket.setCreated_date(LocalDate.now());
//            System.out.print("Updated date   : ");
//            ticket.setUpdated_date(LocalDate.now());
//            
//            System.out.println("--------------- TICKET DETAILS ---------------");
//            System.out.println("ID Ticket    : " + ticket.getId());
//            System.out.println("Ticket name  : " + ticket.getTicket_name());
//            System.out.println("Ticket desc  : " + ticket.getTicket_desc());
//            System.out.println("Ticket date  : " + ticket.getTicket_date());
//            System.out.println("Ticket price : " + ticket.getTicket_price());
//            System.out.println("Created date : " + ticket.getCreated_date());
//            System.out.println("Updated date : " + ticket.getUpdated_date());
//            System.out.println("----------------------------------------------");
//            
//            Reservation reservation = new Reservation();
//            System.out.print("Qty          : ");
//            reservation.setQty(input.nextInt());
//            
//            System.out.println("------------ RESERVATION DETAILS ------------");
//            System.out.println("ID User      : " + reservation.getUser_id().getUsername());
//            System.out.println("ID Ticket    : " + reservation.getTicket_id().getId());
//            System.out.println("Qty          : " + reservation.getQty());
//            System.out.println("Created date : " + reservation.getCreated_at());
//            System.out.println("Updated date : " + reservation.getUpdated_at());
//            System.out.println("---------------------------------------------");
//        }
//        catch(Exception ex) {
//            System.out.println(ex);
//        }
//    }
//}
