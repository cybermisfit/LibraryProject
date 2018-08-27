package com.example.springbootsecurity;

import javax.persistence.*;


@Entity
@Table(name="PRODUCT_DATA")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "category")
    private String category;

    @Column(name="title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name="authorartist")
    private String author_artist;

    @Column(name="yearreleased")
    private String yearreleased;

    @Column(name="genre")
    private String genre;

    @Column(name="callnumber")
    private String callnumber;

//    @Column(name="cost")
//    private double cost;

//    @Column(name="available")
//    private boolean available;
//
//    @Column(name = "datecheckout")
//    private String datecheckout;
//
//    @Column(name = "duedate")
//    private String duedate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor_artist() {
        return author_artist;
    }

    public void setAuthor_artist(String author_artist) {
        this.author_artist = author_artist;
    }

    public String getYearreleased() {
        return yearreleased;
    }

    public void setYearreleased(String yearreleased) {
        this.yearreleased = yearreleased;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCallnumber() {
        return callnumber;
    }

    public void setCallnumber(String callnumber) {
        this.callnumber = callnumber;
    }

//    public double getCost() {
//        return cost;
//    }
//
//    public void setCost(double cost) {
//        this.cost = cost;
//    }

//    public boolean isAvailable() {
//        return available;
//    }
//
//    public void setAvailable(boolean available) {
//        this.available = available;
//    }
//
//    public String getDatecheckout() {
//        return datecheckout;
//    }
//
//    public void setDatecheckout(String datecheckout) {
//        this.datecheckout = datecheckout;
//    }
//
//    public String getDuedate() {
//        return duedate;
//    }
//
//    public void setDuedate(String duedate) {
//        this.duedate = duedate;
//    }

}

