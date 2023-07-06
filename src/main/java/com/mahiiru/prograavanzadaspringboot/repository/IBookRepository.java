package com.mahiiru.prograavanzadaspringboot.repository;

import com.mahiiru.prograavanzadaspringboot.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book, Long> {

    Book findByIsbn(String isbn);
}
