package org.example.entity.DemoHeritage;

import org.example.entity.DemoHeritage.entity.Personne;
import org.example.entity.DemoHeritage.entity.Professeur;
import org.example.entity.DemoHeritage.entity.Eleve;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Personne.class);
        configuration.addAnnotatedClass(Professeur.class);
        configuration.addAnnotatedClass(Eleve.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Professeur professeur = Professeur.builder().name("prof").age(35).matiere("Maths").build();
        Eleve eleve = Eleve.builder().name("eleve").age(12).classe("b").build();

        session.beginTransaction();
        session.persist(eleve);
        session.persist(professeur);
        session.getTransaction().commit();
    }
}
