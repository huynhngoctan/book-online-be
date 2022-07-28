package com.nlu.bookonlinebe.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nlu.bookonlinebe.utils.VNCharaterUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String author;
    private String publisher;
    private int publishingYear;
    private String genre;
    private double weight;
    private int numberOfPages;
    private String status;
    private String description;
    private int stock;
    private double price;
    private String linkImage;
    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<OrderDetail> orderDetailList;
    private String keywords;

    public Product(String name, String author, String publisher, int publishingYear, String genre, double weight, int numberOfPages, String status, String description, int stock, double price, String linkImage) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.publishingYear = publishingYear;
        this.genre = genre;
        this.weight = weight;
        this.numberOfPages = numberOfPages;
        this.status = status;
        this.description = description;
        this.stock = stock;
        this.price = price;
        this.linkImage = linkImage;
        generateKeyword();
    }

    private void generateKeyword() {
        String result = "";
        result += this.name;
        result += " " + this.author;
        result += " " + VNCharaterUtils.removeAccent(this.name);
        result += " " + VNCharaterUtils.removeAccent(this.author);
        this.setKeywords(result);
    }
}


