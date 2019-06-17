package com.huihuitf.library.service.impl;

import com.huihuitf.library.dao.BookDao;
import com.huihuitf.library.entity.Book;
import com.huihuitf.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    /**
     * 批量增加书籍
     * @param bookList
     * @return
     */
    @Override
    public List<Book> saveBooks(List<Book> bookList) {
        List<Book> books=new ArrayList<>();
        for (Book book : bookList) {
            if(!bookDao.existsById(book.getBookId()))
                books.add(book);
        }
        return books;
    }

    /**
     * 增加书籍
     * @param book
     * @return
     */
    @Override
    public Book saveBook(Book book) {
        if(!bookDao.existsById(book.getBookId()))
            return bookDao.save(book);
        else return null;
    }

    /**
     * 删除书籍
     * @param book
     */
    @Override
    public void deleteBook(Book book) {
        bookDao.deleteById(book.getBookId());
    }

    /**
     * 批量删除书籍
     * @param bookList
     */
    @Override
    public void deleteBooks(List<Book> bookList) {
        for (Book book : bookList) {
            bookDao.deleteById(book.getBookId());
        }
    }

    @Override
    public int updateBook(Book book) {
        if(bookDao.existsById(book.getBookId())){
            return 0;
        }else {
            bookDao.save(book);
            return 1;
        }
    }

    /**
     * 通过名字模糊查询
     * @param name
     * @return
     */
    @Override
    public List<Book> queryBookByName(String name) {
        return bookDao.queryBookByBookNameLike(name);
    }

    @Override
    public List<Book> findAllBook(int pageNum, int pageSize) {

        Pageable pageable= PageRequest.of(pageNum,pageSize, Sort.by("DESC"));
        Page<Book> bookPage = bookDao.findAll(pageable);
        return bookPage.getContent();
    }
}
