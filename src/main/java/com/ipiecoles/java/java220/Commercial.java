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

    @Override
    public Double getPrimeAnnuelle() {
        if (this.caAnnuel != null){
            return Math.max(Math.ceil(this.caAnnuel * 0.05), 500d);
        }
        return 500d;
    }

    public Commercial() {
        // on peut aussi ajouter le super() au besoin
    }

    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Double caAnnuel) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.caAnnuel = caAnnuel;
    }


}
