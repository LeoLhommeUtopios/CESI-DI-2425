package org.example.correctionexo3.service;

import org.example.correctionexo3.entity.Books;
import org.example.correctionexo3.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class BooksService {

    private final BookRepository repository;

    public BooksService(BookRepository repository) {
        this.repository = repository;
    }

    public void create (Books book){
        book.setAvailable(true);
        book.setDateAdd(LocalDate.now());
        repository.save(book);
    }

    public Books get(UUID id){
        return repository.findById(id).orElse(null);
    }

    public List<Books> get(){
        return repository.findAll();
    }

    public void edit (Books books){
        if(get(books.getId()) != null){
            repository.save(books);
        }
    }

    public void delete (UUID id){
        repository.deleteById(id);
    }
}
