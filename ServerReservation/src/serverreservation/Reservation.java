package serverreservation;

import java.time.LocalDate;

public class Reservation {

    public User user_id;
    public Ticket ticket_id;
    public int qty;
    public LocalDate created_at;
    public LocalDate updated_at;
    
    public Reservation() throws Exception{
        setUser_id(new User());
        setTicket_id(new Ticket());
        setQty(0);
        setCreated_at(LocalDate.now());
        setUpdated_at(LocalDate.now());
    }
    
    public Reservation(User user_id, Ticket ticket_id, int qty, LocalDate created_at, LocalDate updated_at) {
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

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public LocalDate getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDate updated_at) {
        this.updated_at = updated_at;
    }
    
}
