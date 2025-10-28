package org.example.Exo3;

import java.time.LocalDate;

public class GestionPaiement {
    public static void main(String[] args) {

        Account account = new Account(100);
        Paypal paypal = new Paypal("Password","email@email.com",account);
        CreditCard creditCard = new CreditCard("21312080978","toto", LocalDate.of(2026,12,12),"544",account);

        System.out.println(paypal.effectuerPaiement(35));;
        System.out.println(creditCard.effectuerPaiement(75));;
    }
}
