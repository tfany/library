package com.huihuitf.library.service;

import com.huihuitf.library.entity.Book;

import java.util.List;

public interface BookService {
    Book saveBook(Book book);
    List<Book> queryBookByName(String name);
    List<Book> findAllBook(int startPage,int endPage);
}
