package org.example.entities;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction  {


    private Date date;
    private long amount;
    private long balance;

    public Transaction( Date date, long amount, long balance) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }



    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getFormattedDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }

}
