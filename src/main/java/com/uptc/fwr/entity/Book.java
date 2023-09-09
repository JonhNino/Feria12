package com.uptc.fwr.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="LIBROS")
public class Book {
    @Id
    @Column(name="ID_LIBRO")
    private Long id;
    @Column(name="TITULO")
    private String title;
    @Column(name="PRECIO")
    private Double price;
    @OneToOne(mappedBy = "book")
    private Edition edition;

    @ManyToMany
    @JoinTable(name="AUTOR_LIBRO",
            joinColumns = @JoinColumn(name = "ID_LIBRO"),
            inverseJoinColumns = @JoinColumn(name="ID_AUTOR"))
    private List<Person> autors;


    public Book() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Edition getEdition() {
        return edition;
    }

    public void setEdition(Edition edition) {
        this.edition = edition;
    }

    public List<Person> getAutors() {
        return autors;
    }

    public void setAutors(List<Person> autors) {
        this.autors = autors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
