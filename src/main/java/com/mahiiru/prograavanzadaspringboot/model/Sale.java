package com.mahiiru.prograavanzadaspringboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sale {

    private Client client;
    private List<SaleDetails> details;
    private int total;
    private LocalDateTime dateTime;
}
