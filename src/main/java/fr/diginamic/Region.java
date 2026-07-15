package fr.diginamic;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "REGIONS")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;


    public Region() {
    }


    public Region(String nom) {
        this.nom = nom;
    }


    public Integer getId() {
        return id;
    }


    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }


    @Override
    public String toString() {
        return "Region{id=" + id + ", nom='" + nom + "'}";
    }
}