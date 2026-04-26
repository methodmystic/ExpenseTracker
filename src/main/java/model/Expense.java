package model;

import java.util.Date;

public class Expense {
    private int id;
    private String title;
    private Double Amount;
    private String Category;
    private Date date;

    public Expense(int id, String title, Double amount, String category, Date date) {
        this.id = id;
        this.title = title ;
        this.Amount = amount;
        this.Category = category;
        this.date = date;

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String name) {
        this.title = title;
    }
    public Double getAmount() {
        return Amount;
    }
    public void setAmount(Double amount) {
        this.Amount = amount;
    }
    public String getCategory() {
        return Category;
    }
    public void setCategory(String category) {
        this.Category = category;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

}
