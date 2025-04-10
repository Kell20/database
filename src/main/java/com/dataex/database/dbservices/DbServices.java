package com.dataex.database.dbservices;

import com.dataex.database.dbaccesslayer.DbAccess;
import com.dataex.database.dbmodel.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class DbServices {
    private final DbAccess accessLayer;

    public DbServices(DbAccess accessLayer) {
        this.accessLayer = accessLayer;
    }

    //get all the book contained in database
    public List<Book> getAllBook(){
        List<Book> required= accessLayer.findAll();
        Stream<Book> streamBk= required.stream();
        return streamBk.filter((n)->n.getTitle().startsWith("A"))
                .toList();
    }

    //get book by id
    public String getByID(Long id){
        return accessLayer.findById(id)
                .orElseThrow(()->new RuntimeException("book not found"))
                .getTitle();
    }

    //delete existing book in database
    public void deleteBook(Long id){
        accessLayer.deleteById(id);
    }

    public ResponseEntity<Book> createBook(Book book){
        Book bk=accessLayer.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(bk);
    }

    /*to update a database already existing data two parameter are require
     * those are id number for book to be updated and the new book info
     * */
    public String updateBook(Long id,Book newUpdate){
        Book bk=accessLayer.findById(id)
                .orElseThrow(()->new RuntimeException("book not found"));

        bk.setTitle(newUpdate.getTitle());
        bk.setAuthor(newUpdate.getAuthor());

        return bk.getTitle()+" successfully updated";
    }
}
