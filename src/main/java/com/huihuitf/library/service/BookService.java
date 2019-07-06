package com.huihuitf.library.service;

import com.huihuitf.library.dto.BookDto;
import com.huihuitf.library.entity.Book;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BookService {
    int saveBook(BookDto book);
    List<Book> saveBooks(List<Book> bookList);
    int deleteBook(String book);
    void deleteBooks(List<Book> bookList);
    int updateBook(BookDto book);
    List<Book> queryBookByName(String name);
    BookDto queryBookById(String bookId);
    List<Book> findAllBook(int pageNum,int pageSize);
    int queryTotal();
    String addFace(String bookId, MultipartFile faceBook);
    void deleteBooks(String bookId);
    int queryCountBySupplier(Integer id);

}
