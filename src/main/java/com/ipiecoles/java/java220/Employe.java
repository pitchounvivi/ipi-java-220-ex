package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

/**
 * Created by pjvilloud on 21/09/17.
 */
public abstract class Employe {
    private String nom;
    private String prenom;
    private String matricule;
    private LocalDate dateEmbauche;
    private Double salaire;

    public Employe() {
    }

    public Employe(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.dateEmbauche = dateEmbauche;
        this.salaire = salaire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(LocalDate dateEmbauche) throws Exception {
        if (dateEmbauche != null && dateEmbauche.isAfter(LocalDate.now())){
            throw new Exception("La date d'embauche ne peut être postérieure à la date courante");
        }
        this.dateEmbauche = dateEmbauche;
    }

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }

    public final Integer getNombreAnneeAnciennete(){
        if (dateEmbauche == null){
            return -1;
        }
        else{
            return LocalDate.now().getYear() - dateEmbauche.getYear();
        }
    }

    public Integer getNbConges(){
        return Entreprise.NB_CONGES_BASE;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", matricule='" + matricule + '\'' +
                ", dateEmbauche=" + dateEmbauche +
                ", salaire=" + salaire +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employe)) return false;
        //if (o == null || getClass() != o.getClass()) return false; //est équivalent à la ligne du dessus

        Employe employe = (Employe) o;
        return Objects.equals(nom, employe.nom) &&
                Objects.equals(prenom, employe.prenom) &&
                Objects.equals(matricule, employe.matricule) &&
                Objects.equals(dateEmbauche, employe.dateEmbauche) &&
                Objects.equals(salaire, employe.salaire);
//        return hashCode() == o.hashCode(); // Cette ligne est équivalente au bloc entier du dessus
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, matricule, dateEmbauche, salaire);
    }

//    public Double augmenterSalaire(Double augmentation){
//        return salaire += salaire * augmentation;
//    } // serait valable mais on ne veut pas renvoyer le salaire, on veut le salaire augmenté
    //C'est la méthode d'après la bonne

    /**
     * Augmente le salaire du pourcentage renseigné
     * ex : Salaire à 1000, pourcentage = 0.05 => salaire à 1050
     *
     * @param pourcentage pourcentage est non null et strictement positif
     */
    public void augmenterSalaire(Double pourcentage){
        this.salaire = this.salaire * (1+pourcentage);
        //this.setSalaire((this.getSalaire() * (1+ pourcentage))); autre écriture possible mais pas valable pour test506 à cause de la redéfinition dans le Technicien
    }

    // mise en commentaire suite exo 402
/*    public Double getPrimeAnnuelle(){
        return Entreprise.primeAnnuelleBase();
    }*/

    public abstract Double getPrimeAnnuelle();

}


