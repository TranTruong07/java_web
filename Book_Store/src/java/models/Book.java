/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Admin
 */
public class Book {
    private int id;
    private String name;
    private double price;
    private String author;
    private User u;
    private int quantity;
    private String imgname;
    private Category c;

    public Book() {
    }

    public Book(int id, String name, double price, String author, User u, int quantity, String imgname, Category c) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.author = author;
        this.u = u;
        this.quantity = quantity;
        this.imgname = imgname;
        this.c = c;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImgname() {
        return imgname;
    }

    public void setImgname(String imgname) {
        this.imgname = imgname;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

    public Category getC() {
        return c;
    }

    public void setC(Category c) {
        this.c = c;
    }
    
    
}
