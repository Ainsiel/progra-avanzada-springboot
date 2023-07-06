package com.mahiiru.prograavanzadaspringboot.model;

import java.util.List;

public class Sale {


    private Long id;
    private Client client;
    private List<SaleDetails> details;
    private int total;
}
