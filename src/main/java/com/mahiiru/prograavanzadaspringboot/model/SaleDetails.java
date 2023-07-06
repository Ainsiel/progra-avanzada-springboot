package com.mahiiru.prograavanzadaspringboot.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "sale_details")
public class SaleDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "quantity",nullable = false)
    private int quantity;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "date_time",nullable = false)
    private LocalDateTime dateTime;

    public SaleDetails(Book book, int quantity, Client client) {
        this.book = book;
        this.quantity = quantity;
        this.client = client;
        this.dateTime = LocalDateTime.now();
    }
}
