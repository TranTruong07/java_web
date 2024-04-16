/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Admin
 */
public class OrderDetails {
    private int oid;
    private Book b;
    private int quantity;
    private double totalPrice;

    public OrderDetails(int oid, Book b, int quantity, double totalPrice) {
        this.oid = oid;
        this.b = b;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public Book getB() {
        return b;
    }

    public void setB(Book b) {
        this.b = b;
    }

    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    
}
