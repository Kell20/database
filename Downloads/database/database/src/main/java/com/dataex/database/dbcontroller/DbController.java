package com.dataex.database.dbcontroller;

import com.dataex.database.dbmodel.Book;
import com.dataex.database.dbservices.DbServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class DbController {

    private final DbServices dbServices;

    public DbController(DbServices dbServices) {
        this.dbServices = dbServices;
    }

    //get all book in database
    @GetMapping
    public List<Book> getAllBook(){
        return dbServices.getAllBook();
    }

    // get book depends on ID
    @GetMapping("get")
    public String getById(@RequestParam Long id){
        return dbServices.getByID(id);
    }

    //delete an existing book in database
    @DeleteMapping("delete/{id}")
    public void deleteBook(@PathVariable Long id){
        dbServices.deleteBook(id);
    }

    // create a book
    @PostMapping("post")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        return dbServices.createBook(book);
    }

    @PutMapping("update")
    public String updateBook(@RequestParam Long id,@RequestBody Book book){
        return dbServices.updateBook(id,book);
    }
}
