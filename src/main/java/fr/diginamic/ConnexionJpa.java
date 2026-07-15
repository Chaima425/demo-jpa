package fr.diginamic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.diginamic.entites.Client;
import fr.diginamic.entites.Emprunt;
import fr.diginamic.entites.Livre;

public class ConnexionJpa {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("pu_essai");

        EntityManager em = emf.createEntityManager();

        // ============================
        // TEST 1 : Client
        // ============================

        System.out.println("===== TEST CLIENT =====");

        Client client = em.find(Client.class, 1);

        System.out.println("Client : "
                + client.getNom() + " "
                + client.getPrenom());

        System.out.println("\nEmprunts :");

        for (Emprunt emprunt : client.getEmprunts()) {

            System.out.println("Emprunt n°" + emprunt.getId());

            for (Livre livre : emprunt.getLivres()) {
                System.out.println("   - " + livre.getTitre());
            }
        }

        // ============================
        // TEST 2 : Livre
        // ============================

        System.out.println("\n===== TEST LIVRE =====");

        Livre livre = em.find(Livre.class, 1);

        System.out.println("Livre : " + livre.getTitre());
        System.out.println("Auteur : " + livre.getAuteur());

        System.out.println("Emprunt(s) associé(s) :");

        for (Emprunt emprunt : livre.getEmprunts()) {
            System.out.println("   Emprunt n°" + emprunt.getId());
        }

        // ============================
        // TEST 3 : Emprunt
        // ============================

        System.out.println("\n===== TEST EMPRUNT =====");

        Emprunt emprunt = em.find(Emprunt.class, 2);

        System.out.println("Emprunt n°" + emprunt.getId());

        System.out.println("Client : "
                + emprunt.getClient().getNom()
                + " "
                + emprunt.getClient().getPrenom());

        System.out.println("Livres :");

        for (Livre l : emprunt.getLivres()) {
            System.out.println("   - " + l.getTitre());
        }

        em.close();
        emf.close();
    }
}