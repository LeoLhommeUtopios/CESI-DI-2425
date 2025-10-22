package org.example.DemoException;

import org.example.DemoException.exception.InsufisantBalanceException;
import org.example.DemoException.exception.MontantNegatifException;

public class Main {

    public static void main(String[] args) {

        Account account = new Account(500);
        try {
            account.retirer(600);
        } catch (InsufisantBalanceException | MontantNegatifException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Exception catch");
        }

        System.out.println(account.getBalance());

    }
}
