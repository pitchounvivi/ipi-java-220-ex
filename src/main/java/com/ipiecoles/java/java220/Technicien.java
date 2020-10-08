package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

public class Technicien extends Employe{

    private Integer grade;

    public Technicien() {
        super();
    }

    public Technicien(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Technicien(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.grade = grade;
    }

    @Override
    public void setSalaire(Double salaire) {
        //gestion d'un grade à 0
        if (grade == null){
            super.setSalaire(salaire);
        }

        //super.setSalaire(salaire * (1 + (double) grade / 10));
        super.setSalaire(salaire * (1 + grade / 10d));
    }

    @Override
    public Integer getNbConges() {
        return super.getNbConges() + this.getNombreAnneeAnciennete();
    }
}
