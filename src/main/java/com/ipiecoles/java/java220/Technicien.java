package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

public class Technicien extends Employe{

    public Technicien() {
    }

    public Technicien(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
    }
}
