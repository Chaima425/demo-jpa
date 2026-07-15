package fr.diginamic.entites;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "EMPRUNT")
public class Emprunt {

    @Id
    @Column(name = "ID")
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_DEBUT")
    private Date dateDebut;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_FIN")
    private Date dateFin;

    @Column(name = "DELAI")
    private int delai;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENT")
    private Client client;

    @ManyToMany(mappedBy = "emprunts")
    private List<Livre> livres;

    public Emprunt() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getDelai() {
        return delai;
    }

    public void setDelai(int delai) {
        this.delai = delai;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Livre> getLivres() {
        return livres;
    }

    public void setLivres(List<Livre> livres) {
        this.livres = livres;
    }

    @Override
    public String toString() {
        return "Emprunt [id=" + id + "]";
    }
}