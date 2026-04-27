package model;

import java.util.Date;

public class Expense {
    private int id;
    private String title;
    private double amount;
    private String category;
    private Date date;
    private int userId;

    public Expense(int id, int userId , String title, Double amount, String category, Date date) {
        this.id = id;
        this.userId = userId;
        this.title = title ;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String name) {
        this.title = title;
    }
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

}
