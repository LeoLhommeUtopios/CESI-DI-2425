package org.example;

import com.mysql.cj.x.protobuf.MysqlxPrepare;
import org.example.controller.IHM;
import org.example.entity.product.Product;
import org.example.entity.product.ProductFood;
import org.example.utils.SessionfactorySingleton;


public class Main {
    public static void main(String[] args) {
        new IHM().start();
    }
}