package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

public class Commercial extends Employe{
    private Double caAnnuel;

    public Double getCaAnnuel() {
        return caAnnuel;
    }

    public void setCaAnnuel(Double caAnnuel) {
        this.caAnnuel = caAnnuel;
    }

    /*//@Override
    public Double getPrimeAnnuelle(Double caAnnuel) {

        Double prime = (caAnnuel*5/100);

        if (prime < 500){
            return prime = 500d;
        }
        else{
            return prime;
        }
    }*/

    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Double caAnnuel) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.caAnnuel = caAnnuel;
    }
}
