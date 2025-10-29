package org.example.repository;

import org.example.entity.Ordinateur;
import org.hibernate.SessionFactory;

import java.util.List;

public class OrdinateurRepository extends BaseRepository<Ordinateur> {

    public OrdinateurRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<Ordinateur> get() {
        try{
            session = sessionFactory.openSession();
            return session.createQuery("Select o from Ordinateur o", Ordinateur.class).getResultList();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }

    }
}
