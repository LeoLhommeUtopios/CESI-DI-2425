package org.example.DAO;

import org.example.entity.Product;
import org.hibernate.Session;

import java.util.List;

public class ProductDAO {
    private final Session session;
    private String request;

    public ProductDAO(Session session) {
        this.session = session;
    }

    public Product save (Product product){
        try{
            session.beginTransaction();
            session.persist(product);
            session.getTransaction().commit();
            return product;
        }catch (Exception e){
            session.getTransaction().rollback();
            return null;
        }
    }


    public Product getById (int id){
        return session.find(Product.class,id);
    }

    public List<Product> getAll (){
        return session.createQuery("Select p from Product p",Product.class).getResultList();
    }

    public Product update (int id,Product productUpdate){
      try{
          session.beginTransaction();
          Product product = getById(id);
          if(product != null){
              product.setRef(productUpdate.getRef());
              product.setStock(productUpdate.getStock());
              product.setPrice(productUpdate.getPrice());
              product.setBuyingDate(productUpdate.getBuyingDate());
              product.setBrand(productUpdate.getBrand());

              session.getTransaction().commit();
              return product;
          }
          session.getTransaction().rollback();
          return null;
      }catch (Exception ex){
          session.getTransaction().rollback();
          return null;
      }
    }


    public boolean delete (int id){
        try{
            session.beginTransaction();
            Product product = getById(id);
            if(product != null){
                session.remove(product);
                session.getTransaction().commit();
                return true;
            }
            session.getTransaction().rollback();
            return false;
        }catch (Exception ex){
            session.getTransaction().rollback();
            return false;
        }
    }
}
