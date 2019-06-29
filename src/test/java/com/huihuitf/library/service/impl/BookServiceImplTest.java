package com.huihuitf.library.service.impl;

import com.huihuitf.library.entity.Book;
import com.huihuitf.library.entity.Category;
import com.huihuitf.library.service.BookService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BookServiceImplTest {

    @Autowired
    private BookService bookService;

    @Test
    public void saveBook() {
        Book book=new Book();
        book.setBookId("ISBN 977-8969-332");
        book.setAuthor("江泽晖");
        Category category=new Category();
        category.setCategoryId(8);
        book.setBookCategory(category);
        book.setBookName("西游记");
        book.setPrice(108.4);
        book.setStock(100);
        Book book1=bookService.saveBook(book);
        Assert.assertEquals(book.getBookId(),book1.getBookId());

    }

    @Test
    public void saveBooks() {

        Book book=new Book();
        book.setBookId("ISBN 977-8969-333");
        book.setAuthor("江泽晖");
        Category category=new Category();
        category.setCategoryId(8);
        book.setBookCategory(category);
        book.setBookName("东游记");
        book.setPrice(108.4);
        book.setStock(100);
        List<Book> bookList=new ArrayList<>();
        bookList.add(book);
        List<Book> book1=bookService.saveBooks(bookList);
        System.out.println(book1.size());
        Assert.assertEquals(1,book1.size());
    }

    @Test
    public void deleteBook() {

    }

    @Test
    public void deleteBooks() {
    }

    @Test
    public void updateBook() {
    }

    @Test
    public void queryBookByName() {
    }

    @Test
    public void findAllBook() {
        List<Book> bookList = bookService.findAllBook(0,2);
        Assert.assertEquals(bookList.size(),2);
    }
}