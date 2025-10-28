package org.example.Exo3;

import java.time.LocalDate;
import java.util.Objects;

public class CreditCard implements Paiement{

    private String cardNumnber;
    private String titulaire;
    private LocalDate expiryDate;
    private String cvv;
    private Account account;


    public CreditCard(String cardNumnber, String titulaire, LocalDate expiryDate, String cvv,Account account) {
        this.cardNumnber = cardNumnber;
        this.titulaire = titulaire;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.account = account;
    }



    public String getCardNumnber() {
        return cardNumnber;
    }

    public void setCardNumnber(String cardNumnber) {
        this.cardNumnber = cardNumnber;
    }

    public String getTitulaire() {
        return titulaire;
    }

    public void setTitulaire(String titulaire) {
        this.titulaire = titulaire;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }


    @Override
    public boolean effectuerPaiement(double montant) {
        if(montant > 0){
            if(account.checkBalance(montant)){
                account.setBalance(account.getBalance() - montant);
                return true;
            }
        }
        return  false;
    }
}
