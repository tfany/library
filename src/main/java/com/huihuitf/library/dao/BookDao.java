package com.huihuitf.library.dao;

import com.huihuitf.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookDao extends JpaRepository<Book,String> {
    List<Book> queryBookByBookNameLike(String name);

}
