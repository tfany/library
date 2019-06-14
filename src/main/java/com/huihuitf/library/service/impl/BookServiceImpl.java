package com.huihuitf.library.service.impl;

import com.huihuitf.library.dao.BookDao;
import com.huihuitf.library.entity.Book;
import com.huihuitf.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

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
