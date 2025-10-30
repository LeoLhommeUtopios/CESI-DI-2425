package org.example.repository;

import org.example.entity.Sell;
import org.example.entity.SellProduct;
import org.example.entity.product.Product;
import org.hibernate.query.Query;

import javax.lang.model.element.ModuleElement;
import java.util.List;

public class SellProductRepository extends BaseRepository<SellProduct> {
    @Override
    public SellProduct findById(int id) {
        session = sessionFactory.openSession();
        SellProduct sellProduct = session.find(SellProduct.class,id);
        session.close();
        return sellProduct;
    }

    @Override
    public List<SellProduct> findAll() {
        List<SellProduct> sellProducts = null;
        session = sessionFactory.openSession();
        Query<SellProduct> sellProductQuery = session.createQuery("from SellProduct ",SellProduct.class);
        sellProducts = sellProductQuery.list();
        session.close();
        return sellProducts;
    }

}
