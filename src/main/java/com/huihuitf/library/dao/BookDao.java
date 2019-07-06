package com.huihuitf.library.dao;

import com.huihuitf.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookDao extends JpaRepository<Book,String> {
    List<Book> queryBookByBookNameLike(String name);

    @Query("SELECT count(bookId) from Book ")
    int queryTotal();

    List<Book> queryBooksBySupplier_SupplierId(Integer supplier_supplierId);

    void deleteBooksByBookIdLike(String id);

    List<Book> queryBooksByBookCategory_CategoryId(Integer bookCategory_categoryId);
}
