package org.example.repository;

import org.example.entity.Peripherique;
import org.example.entity.SystemeExploitation;
import org.hibernate.SessionFactory;

import java.util.List;

public class PeripheriqueRepository extends BaseRepository<Peripherique> {

    public PeripheriqueRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<Peripherique> get() {
        try{
            session = sessionFactory.openSession();
            return session.createQuery("Select p from Peripherique p", Peripherique.class).getResultList();
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
