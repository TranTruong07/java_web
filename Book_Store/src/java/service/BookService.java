/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dal.BookDao;
import dal.OrderDao;
import dal.UserDao;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import models.Book;
import models.Category;
import models.OrderDetails;

/**
 *
 * @author Admin
 */
public class BookService {

    private static BookService bookservice = new BookService();
    private BookDao bookd;
    private UserDao userd;
    private OrderDao orderd;
    private List<Category> listc;
    private List<Book> listb;

    public static BookService getInstance() {
        return bookservice;
    }

    private BookService() {
        bookd = new BookDao();
        userd = new UserDao();
        orderd = new OrderDao();
    }

    public List<Category> getAllCategory() {
        if (listc == null) {
            listc = bookd.getAllCategory();
        }
        return listc;
    }

    public List<Book> getAllBook() {
        if (listb == null) {
            listb = bookd.getAllBook();
        }
        return listb;
    }

    public int getQuantityCategory() {
        return getAllCategory().size();
    }

    public int getQuantityBook() {
        return getAllBook().size();
    }

    public List<Book> getBooksByUserId(int userid) {
        return bookd.getBooksByUserId(userid);
    }

    public boolean updateBook(int bookid, Book b) {
        boolean check = bookd.updateBook(bookid, b);
        if (check) {
            listb = bookd.getAllBook();
        }
        return check;
    }

    public boolean deleteBook(int id) {
        OrderService orderService = OrderService.getInstance();
        List<OrderDetails> list = orderService.getAllOrderDetails().stream().filter(od -> od.getB().getId() == id).collect(Collectors.toList());
        if (list.isEmpty()) {
            boolean check = bookd.deleteBookById(id);
            if (check) {
                if (listb == null) {
                    listb = bookd.getAllBook();
                } else {
                    Book b = getBookById(id, listb);
                    listb.remove(b);
                }
            }
            return check;
        }else{
            for(OrderDetails od: list){
                orderService.deleteOrderDetails(od.getOid(), od.getB().getId());
            }
            boolean check = bookd.deleteBookById(id);
            if (check) {
                if (listb == null) {
                    listb = bookd.getAllBook();
                } else {
                    Book b = getBookById(id, listb);
                    listb.remove(b);
                }
            }
            return check;
        }
    }

    public boolean addBook(int userid, int categoryid, Book b) {
        boolean check = bookd.addBook(userid, categoryid, b);
        if (check) {
            listb = bookd.getAllBook();
        }
        return check;
    }

    public Book getBookById(int id, List<Book> listb) {
        for (Book b : listb) {
            if (id == b.getId()) {
                return b;
            }
        }
        return null;
    }

    public Category getCategoryById(int id) {
        return bookd.getCategoryById(id);
    }

    public List<Book> getBooksByCategoryId(int id) {
        return bookd.getBookByCategoryId(id);
    }

    public List<Book> searchBooksByInfor(String nameOrAuthor) {
        if (listb == null) {
            listb = bookd.getAllBook();
        }
        List<Book> list = new ArrayList<>();
        for (Book b : listb) {
            if (b.getName().toLowerCase().contains(nameOrAuthor.toLowerCase()) || b.getAuthor().toLowerCase().contains(nameOrAuthor.toLowerCase())) {
                list.add(b);
            }
        }
        return list;
    }

    public List<Book> getBooksByPrice(int price) {
        if (listb == null) {
            listb = bookd.getAllBook();
        }
        List<Book> list = new ArrayList<>();
        for (Book b : listb) {
            switch (price) {
                case 100 -> {
                    if (b.getPrice() >= 100000) {
                        list.add(b);
                    }
                }
                case 50 -> {
                    if (b.getPrice() < 100000 && b.getPrice() >= 50000) {
                        list.add(b);
                    }
                }
                case 0 -> {
                    if (b.getPrice() < 50000 && b.getPrice() >= 0) {
                        list.add(b);
                    }
                }
                default -> {
                }
            }
        }
        return list;
    }

    public boolean addCategory(String categoryname) {
        if (bookd.addCategory(categoryname)) {
            listc = bookd.getAllCategory();
            return true;
        }
        return false;
    }

    public boolean deleteCategory(int id) {
        if (listb == null) {
            listb = bookd.getAllBook();
        }
        List<Book> list = listb.stream().filter((book) -> {
            if (book.getC() != null) {
                return book.getC().getId() == id;
            }
            return false;
        }
        ).collect(Collectors.toList());
        Category c = new Category();
        if (!list.isEmpty()) {
            list.forEach((book) -> {
                c.setId(0);
                book.setC(c);
                bookd.updateBook(book.getId(), book);
            });
            listb = bookd.getAllBook();
            if (bookd.deleteCategoryById(id)) {
                listc.removeIf(category -> category.getId() == id);
                return true;
            }
            return false;
        } else {
            if (bookd.deleteCategoryById(id)) {
                listc.removeIf(category -> category.getId() == id);
                return true;
            }
            return false;
        }
    }

    boolean deleteBooksByUserId(int id) {
        if (listb == null) {
            listb = bookd.getAllBook();
        }
        boolean check = true;
        List<Book> list = listb.stream().filter((book) -> book.getU().getId() == id
        ).collect(Collectors.toList());
        if (!list.isEmpty()) {
            for (Book b : list) {
                check = bookd.deleteBookById(b.getId());
                if (check == false) {
                    return false;
                }
            }
            listb = bookd.getAllBook();
            return check;
        } else {
            return check;
        }
    }

}
