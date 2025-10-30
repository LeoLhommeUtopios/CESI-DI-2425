package org.example.repository;

import org.example.entity.Product;
import org.example.entity.ProductElectronic;
import org.example.entity.ProductFood;
import org.example.entity.ProductHousing;
import org.example.util.ProductClass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ProductRepository {

    private SessionFactory sessionFactory;
    private Session session;

    public ProductRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Product saveOrUpdate (Product product){
        try{
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.persist(product);
            session.getTransaction().commit();
            return product;
        }catch (Exception e){
            if(session.isOpen()){
                session.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
            return null;
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
    }

    public Product get (long id){
        try{
            session = sessionFactory.openSession();
            return session.find(Product.class,id);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
    }

    public List<Product> get(){
        try{
            session = sessionFactory.openSession();
            return session.createQuery("Select p from Product p", Product.class).getResultList();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
    }

    public boolean remove (long id){
        Product product = get(id);
        try{
            if(product != null){
                session = sessionFactory.openSession();
                session.beginTransaction();
                session.remove(product);
                session.getTransaction().commit();
                return true;
            }
           return false;
        }catch (Exception e){
            if(session.isOpen()){
                session.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
            return false;
        }finally {
            if(session.isOpen()){
                session.close();
            }
        }
    }

    public <T extends Product> List<T> getProductByType (ProductClass productClass,Class<T> tClass){
        try{
            session = sessionFactory.openSession();
            Query<T> query ;
            switch (productClass){
                case FOOD -> query = session.createQuery("Select p from ProductFood p",tClass);
                case HOUSING -> query = session.createQuery("Select p from ProductHousing p",tClass);
                case ELECTRONIC -> query = session.createQuery("Select p from ProductElectronic p",tClass);
                default -> query = session.createQuery("Select p from Product p");
            }
            return query.getResultList();
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
