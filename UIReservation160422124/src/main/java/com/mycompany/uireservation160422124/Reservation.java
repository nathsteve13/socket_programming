package com.mycompany.uireservation160422124;

import java.time.LocalDate;

public class Reservation {

    public User user_id;
    public Ticket ticket_id;
    public int qty;
    public Ticket created_at;
    public Ticket updated_at;
    
    public Reservation() throws Exception{
        setUser_id(new User());
        setTicket_id(new Ticket());
        setQty(0);
        setCreated_at(new Ticket());
        setUpdated_at(new Ticket());
    }
    
    public Reservation(User user_id, Ticket ticket_id, int qty, Ticket created_at, Ticket updated_at) {
        setUser_id(user_id);
        setTicket_id(ticket_id);
        setQty(qty);
        setCreated_at(created_at);
        setUpdated_at(updated_at);
    }
    
    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Ticket getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(Ticket ticket_id) {
        this.ticket_id = ticket_id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Ticket getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Ticket created_at) {
        this.created_at = created_at;
    }

    public Ticket getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Ticket updated_at) {
        this.updated_at = updated_at;
    }
    
}
