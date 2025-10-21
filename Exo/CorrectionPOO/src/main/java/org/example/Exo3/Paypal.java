package org.example.Exo3;

public class Paypal implements Paiement{

    private String email;
    private String password;
    private  Account account;

    public Paypal(String password, String email,Account account) {
        this.password = password;
        this.email = email;
        this.account= account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
