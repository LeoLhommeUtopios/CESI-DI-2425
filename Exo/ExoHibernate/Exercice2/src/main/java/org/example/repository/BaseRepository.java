package org.example.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public abstract class BaseRepository<T> {

    protected SessionFactory sessionFactory;
    protected Session session;

    public BaseRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public T save (T element){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.persist(element);
            session.getTransaction().commit();
            return element;
        }catch (Exception e){
            System.out.println(e.getMessage());
            if(session.isOpen()){
                session.getTransaction().rollback();
            }
            return null;
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
    }

    public  boolean delete (T element){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.remove(element);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            if(session.isOpen()){
                session.getTransaction().rollback();
            }
            return false;
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
    }

    public T get(long id,Class<T> elementClass){
        try{
            session = sessionFactory.openSession();
            return session.find(elementClass,id);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
    }

    public abstract List<T> get();
}
