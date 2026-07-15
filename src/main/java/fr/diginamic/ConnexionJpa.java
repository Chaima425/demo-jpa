package fr.diginamic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnexionJpa {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("pu_essai");

        EntityManager em = emf.createEntityManager();


        Region region = em.find(Region.class, 1);

        System.out.println("Nom de la région : " + region.getNom());


        em.close();
        emf.close();
    }
}

// package fr.diginamic;

// import javax.persistence.EntityManager;
// import javax.persistence.EntityManagerFactory;
// import javax.persistence.Persistence;

// public class ConnexionJpa {

//     public static void main(String[] args) {

//         EntityManagerFactory emf =
//                 Persistence.createEntityManagerFactory("pu_essai");

//         EntityManager em = emf.createEntityManager();

//         System.out.println("Connexion à la base de données réussie !");

//         em.close();
//         emf.close();
//     }
// }

// package fr.diginamic;

// import java.util.List;

// import javax.persistence.EntityManager;
// import javax.persistence.EntityManagerFactory;
// import javax.persistence.Persistence;
// import javax.persistence.TypedQuery;


// public class ConnexionJpa {

//     public static void main(String[] args) {

//         EntityManagerFactory entityManagerFactory =
//                 Persistence.createEntityManagerFactory("pu_essai");

//         EntityManager em =
//                 entityManagerFactory.createEntityManager();


//         // INSERT
//         em.getTransaction().begin();

//         Region france = new Region("France");
//         Region italie = new Region("Italie");

//         em.persist(france);
//         em.persist(italie);

//         em.getTransaction().commit();


//         // FIND id = 1
//         Region region = em.find(Region.class, 1);

//         System.out.println("Region trouvée : " + region);


//         // SELECT liste des régions
//         TypedQuery<Region> query =
//                 em.createQuery("SELECT r FROM Region r", Region.class);

//         List<Region> regions = query.getResultList();


//         System.out.println("Liste des régions :");

//         for (Region r : regions) {
//             System.out.println(r);
//         }


//         em.close();
//         entityManagerFactory.close();
//     }
// }