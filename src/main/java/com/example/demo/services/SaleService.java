package com.example.demo.services;
import com.example.demo.SingletonCategories;
import com.example.demo.models.Client;
import com.example.demo.models.Sale;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class SaleService {


    public static ResponseEntity<ArrayList<Sale>> getAllSales() {
        SingletonCategories sc = SingletonCategories.getInstance();
        ArrayList<Sale> sales = sc.getSales();
        return new ResponseEntity<>(sales, HttpStatus.OK);
    }

    public ResponseEntity<Sale> createSale(String password, String email) {
        Client client = Client.CheckClient(password, email);
        if(client !=null){
            SingletonCategories sc = SingletonCategories.getInstance();
            ArrayList<Sale> sales = sc.getSales();
            Sale sale = new Sale(client);
            sale.makeSale();
            sales.add(sale);
            sc.setSales(sales);
            return new ResponseEntity<>(sale, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
