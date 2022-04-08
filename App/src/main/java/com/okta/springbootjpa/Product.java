package com.okta.springbootjpa;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
@Data // Lombok: adds getters and setters
public class Product {


    public Product(String product_nr, String name, String name_manufacturer, String ean, String inhalt, String mhd) {
        this.product_nr = product_nr;
        this.name = name;
        this.name_manufacturer = name_manufacturer;
        this.ean = ean;
        this.inhalt = inhalt;
        this.mhd = mhd;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;


    @Column(name = "product_nr")
    private String product_nr;

    @Column(name = "name")
    private String name;

    @Column(name = "name_manufacturer")
    private String name_manufacturer;

    @Column(name = "ean")
    private String ean;


    @Column(name = "inhalt")
    private String inhalt;

    @Column(name = "mhd")
    private String mhd;




    public Product(String productNummer, String produktName, String herstellerName, String ean, String inhalt) {
        this.product_nr = productNummer;
        this.name = produktName;
        this.name_manufacturer= herstellerName;
        this.ean = ean;
        this.inhalt = inhalt;
        this.mhd = mhd;
    }
}
