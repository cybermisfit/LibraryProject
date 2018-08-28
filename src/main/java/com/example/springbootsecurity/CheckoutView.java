//package com.example.springbootsecurity;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name="CHECKOUT_VIEW")
//public class CheckoutView {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//
//    @Column(name = "ID")
//    private long id;
//
//    private String title;
//    private String firstname;
//    private String lastname;
//    private String dateborrowed;
//    private String datereturned;
//    private String username;
//
//    @OneToOne()
//    @JoinColumn(name="product_id")
//    private Product product;
//
//    @ManyToOne()
//    @JoinColumn(name="student_id")
//    private Student student;
//
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getFirstname() {
//        return firstname;
//    }
//
//    public void setFirstname(String firstname) {
//        this.firstname = firstname;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }
//
//    public String getDateborrowed() {
//        return dateborrowed;
//    }
//
//    public void setDateborrowed(String dateborrowed) {
//        this.dateborrowed = dateborrowed;
//    }
//
//    public String getDatereturned() {
//        return datereturned;
//    }
//
//    public void setDatereturned(String datereturned) {
//        this.datereturned = datereturned;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
//
//    public Student getStudent() {
//        return student;
//    }
//
//    public void setStudent(Student student) {
//        this.student = student;
//    }
//}
//
