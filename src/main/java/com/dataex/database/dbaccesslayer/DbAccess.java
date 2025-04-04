package com.dataex.database.dbaccesslayer;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dataex.database.dbmodel.Book;

public interface DbAccess extends JpaRepository<Book,Long> {
    //Spring automatic implements all the methods at runtime
}
