package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

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

    @Override
    public Double getPrimeAnnuelle() {
//        return super.getPrimeAnnuelle() * (1 + (grade / 10d)) + Entreprise.PRIME_ANCIENNETE * this.getNombreAnneeAnciennete();

        return getPrimeAnnuelle() * (1 + (grade / 10d)) + Entreprise.PRIME_ANCIENNETE * this.getNombreAnneeAnciennete();

    /* //Autre écriture
    Double primeAnnuelleBase = Entreprise.primeAnnuelleBase();
    primeAnnuelleBase = primeAnnuelleBase + primeAnnuelleBase * (grade / 10d);
    return primeAnnuelleBase + Entreprise.PRIME_ANCIENNETE * this.getNombreAnneeAnciennete();
    */

    }


    //pour réussir le 505 de manager
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Technicien that = (Technicien) o;
        return Objects.equals(grade, that.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), grade);
    }

    @Override
    public String toString() {
        return "Technicien{" +
                "grade=" + grade +
                '}';
    }
}
