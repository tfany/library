package com.huihuitf.library.service;

import com.huihuitf.library.dto.BookDto;
import com.huihuitf.library.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BookService {
    int saveBook(BookDto book);
    List<Book> saveBooks(List<Book> bookList);
    int deleteBook(String book);
    void deleteBooks(List<Book> bookList);
    int updateBook(BookDto book);
    List<Book> queryBookByNameOrAuthor(String name);
    BookDto queryBookById(String bookId);
    Page<Book> findAllBook(int pageNum, int pageSize, String bookId, String bookName, Integer categoryId, Integer supplierId);
    int queryTotal(String bookId,String bookName,Integer categoryId,Integer supplierId);
    String addFace(String bookId, MultipartFile faceBook);
    void deleteBooks(String bookId);
    int queryCountBySupplier(Integer id);



    List<Book> queryBookByCategory(int id);


}
