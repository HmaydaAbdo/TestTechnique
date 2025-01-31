package org.example;

import org.example.entities.Account;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws ParseException {
        Account account=new Account();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        // Deposit some money
        account.deposit(1000,dateFormat.parse("10/01/2012")); // 10/01/2012
        account.deposit(2000,dateFormat.parse("13/01/2012")); //13/01/2012
        // Withdraw some money
        account.withdraw(500,dateFormat.parse("14/01/2012")); // 14/01/2012
        // Print the statement
        account.printStatement();

    }
}

