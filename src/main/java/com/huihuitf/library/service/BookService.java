package com.huihuitf.library.service;

import com.huihuitf.library.entity.Book;

import java.util.List;

public interface BookService {
    Book saveBook(Book book);
    List<Book> saveBooks(List<Book> bookList);
    void deleteBook(Book book);
    void deleteBooks(List<Book> bookList);
    int updateBook(Book book);
    List<Book> queryBookByName(String name);
    List<Book> findAllBook(int pageNum,int pageSize);
}
