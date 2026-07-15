package fr.diginamic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnexionJpa {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("pu_essai");

        EntityManager em = emf.createEntityManager();

        System.out.println("Connexion à la base de données réussie !");

        em.close();
        emf.close();
    }
}