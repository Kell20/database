package com.dataex.database.dbservices;

import com.dataex.database.dbaccesslayer.DbAccess;
import com.dataex.database.dbmodel.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbServices {
    private final DbAccess accessLayer;

    public DbServices(DbAccess accessLayer) {
        this.accessLayer = accessLayer;
    }

    //get all the book contained in database
    public List<Book> getAllBook(){
        return accessLayer.findAll();
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
}
