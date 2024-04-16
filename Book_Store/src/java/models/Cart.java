/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Cart {

    private List<Item> listItem;
    private int num;
    private double total;

    public Cart() {
        this.listItem = new ArrayList<>();
    }

    public Cart(String txt, List<Book> listb) {
        listItem = new ArrayList<>();
        if (txt != null && txt.length() != 0) {
            String[] arrBook = txt.split("/");
            for (String book : arrBook) {
                String[] arrProperties = book.split(":");
                try {
                    int bid = Integer.parseInt(arrProperties[0]);
                    int quantity = Integer.parseInt(arrProperties[1]);
                    Book b = getBookById(bid, listb);
                    Item item = new Item(b, quantity, b.getPrice()*quantity);
                    addItem(item);
                } catch (NumberFormatException e) {
                }
            }
        }
    }

    public List<Item> getListItem() {
        return listItem;
    }

    
    public void addItem(Item i) {
        boolean isDuplicate = listItem.stream()
                .anyMatch(item -> item.getB().getId() == i.getB().getId());

        if (isDuplicate) {
            listItem.forEach(item -> {
                if (item.getB().getId() == i.getB().getId()) {
                    item.setQuantity(item.getQuantity() + i.getQuantity());
                    item.setTotalPrice(item.getQuantity() * item.getB().getPrice());
                }
            });
        } else {
            listItem.add(i);
        }
    }

    public void deleteItem(int id) {
        listItem.removeIf(item -> item.getB().getId() == id);
    }

    public int getNumberItem() {
        num = 0;
        listItem.forEach(item -> {
            num += item.getQuantity();
        });
        return num;
    }

    public double getTotalMoney() {
        total = 0;
        listItem.forEach(item -> {
            total += item.getTotalPrice();
        });
        return total;
    }

    public Item getItemById(int bid) {
        return listItem.stream().filter(item -> item.getB().getId()==bid).findFirst().orElse(null);
    }
    
    private Book getBookById(int bid, List<Book> listb) {
        return listb.stream().filter(book -> book.getId()==bid).findFirst().orElse(null);
    }

}
