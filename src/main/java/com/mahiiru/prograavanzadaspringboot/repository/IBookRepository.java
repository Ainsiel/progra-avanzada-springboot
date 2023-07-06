package com.mahiiru.prograavanzadaspringboot.repository;

import com.mahiiru.prograavanzadaspringboot.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Long> {
}
