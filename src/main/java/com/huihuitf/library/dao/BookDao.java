package com.huihuitf.library.dao;

import com.huihuitf.library.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookDao extends JpaRepository<Book,String> {
    List<Book> queryBookByBookNameLikeOrAuthorLike(String bookName, String author);

    @Query("SELECT count(bookId) from Book ")
    int queryTotal();

    List<Book> queryBooksBySupplier_SupplierId(Integer supplier_supplierId);

    Page<Book> queryBooksByBookIdLikeAndBookNameLikeAndBookCategory_CategoryIdAndSupplier_SupplierId(String bookId, String bookName, Integer bookCategory_categoryId, Integer supplier_supplierId, Pageable pageable);

    void deleteBooksByBookIdLike(String id);

    List<Book> queryBooksByBookCategory_CategoryId(Integer bookCategory_categoryId);
}
