package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.HashSet;
import java.util.Objects;

public class Manager extends Employe {
    private HashSet<Technicien> equipe = new HashSet<>();//un hashset ne peut contenir que des éléments uniques

    /*//pour être sure de passer le 503 il faut les constructeurs
    public Manager(HashSet<Technicien> equipe) {
        this.equipe = equipe;
    }

    public Manager(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, HashSet<Technicien> equipe) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.equipe = equipe;
    }*/


    public HashSet<Technicien> getEquipe() {
        return equipe;
    }

    public void setEquipe(HashSet<Technicien> equipe) {
        this.equipe = equipe;
    }

    //503
    public void ajoutTechnicienEquipe(Technicien technicien){
        this.equipe.add(technicien);
    }


    @Override//504
    public void setSalaire(Double salaire) {
        Double salaireCalcule = salaire * Entreprise.INDICE_MANAGER;
        salaireCalcule = salaireCalcule + this.equipe.size() * salaire * 0.1;
        super.setSalaire(salaireCalcule);
    }

    //505
    @Override
    public Double getPrimeAnnuelle() {
        return Entreprise.primeAnnuelleBase() + this.equipe.size() * Entreprise.PRIME_MANAGER_PAR_TECHNICIEN;
        // remarque les hashSet et hashMap doivent être redéfinis car ce sont eux qui vérifie l'unicité
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manager)) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return Objects.equals(equipe, manager.equipe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), equipe);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "equipe=" + equipe +
                '}';
    }

    //506 on fait un override de augmenterSalaire et on redéfinit
    private void augmenterSalaireEquipe(Double pourcentage) {
        for (Technicien technicien : this.equipe){
            technicien.augmenterSalaire(pourcentage);
        }
    }

    //507
    @Override
    public void augmenterSalaire(Double pourcentage) {
        for (Technicien technicien : equipe){
            technicien.augmenterSalaire(pourcentage);
        }
        super.augmenterSalaire(pourcentage);
    }

    //508 surcharge
    public void ajoutTechnicienEquipe(String nom, String prenom, String matricule,
        LocalDate dateEmbauche, Double salaire, Integer grade){
        Technicien technicien = new Technicien(nom,prenom,matricule,dateEmbauche,salaire,grade);
        this.ajoutTechnicienEquipe(technicien);
    }

}
