package org.example.DemoException;

import org.example.DemoException.exception.InsufisantBalanceException;
import org.example.DemoException.exception.MontantNegatifException;

public class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void verser(double montant) {
        if (montant <= 0) throw new MontantNegatifException("montant nul ou negatif");
        balance += montant;
    }

    public void retirer(double mt) throws InsufisantBalanceException {
        if (mt <= 0) throw new MontantNegatifException("montant nul ou negatif");
        if (mt > balance) throw new InsufisantBalanceException("Solde insufisant");
        balance -= mt;
    }

}
