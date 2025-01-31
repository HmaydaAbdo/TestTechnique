package org.example.entities;


import org.example.interfaces.AccountService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Account implements AccountService {

    public long getSolde() {
        return solde;
    }

    public void setSolde(long solde) {
        this.solde = solde;
    }

    public Account() {
    }

    private long solde=0;

    private List<Transaction> transactions=new ArrayList<>();


    @Override
    public void deposit(int amount) {

        Transaction transaction=new Transaction(new Date(),+amount,solde+amount);
        transactions.add(transaction);
        solde=solde+amount;
    }

    @Override
    public void withdraw(int amount) {
        if(amount>this.solde){
            throw new  RuntimeException("you don't  have  enough  balance ");
        }else{
            Transaction transaction=new Transaction(new Date(),-amount,solde-amount);
            transactions.add(transaction);
            solde=solde-amount;
        }

    }

    @Override
    public void printStatement() {
        StringBuilder statement= new StringBuilder("""
                Date || Amount || Balance
                """);
        // Sort transactions by date
        transactions.sort(Comparator.comparing(Transaction::getDate).reversed());

        for(Transaction transaction:transactions){
            statement.append(System.lineSeparator());
            statement.append(transaction.getFormattedDate()).append(" || ")
                    .append(transaction.getAmount()).append(" || ")
                    .append(transaction.getBalance());
        }

        System.out.println(statement);
    }

    public void deposit(int amount,Date date) {

        Transaction transaction=new Transaction(date,+amount,solde+amount);
        transactions.add(transaction);
        solde=solde+amount;
    }
    public void withdraw(int amount,Date date) {

        if(amount>this.solde){
            throw new  RuntimeException("you don't  have  enough  balance ");
        }else{
            Transaction transaction=new Transaction(date,-amount,solde-amount);
            transactions.add(transaction);
            solde=solde-amount;
        }
   ;
    }


}

