/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Order {
    private int oid;
    private Date date;
    private User customer;
    private double totalCart;

    public Order(int oid, Date date, User customer, double totalCart) {
        this.oid = oid;
        this.date = date;
        this.customer = customer;
        this.totalCart = totalCart;
    }

    

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    

    public double getTotalCart() {
        return totalCart;
    }

    public void setTotalCart(double totalCart) {
        this.totalCart = totalCart;
    }
    
    
}
