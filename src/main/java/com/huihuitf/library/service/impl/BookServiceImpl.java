package com.huihuitf.library.service.impl;

import com.huihuitf.library.dao.BookDao;
import com.huihuitf.library.dao.CategoryDao;
import com.huihuitf.library.dto.BookDto;
import com.huihuitf.library.entity.Book;
import com.huihuitf.library.entity.Category;
import com.huihuitf.library.entity.Supplier;
import com.huihuitf.library.service.BookService;
import com.huihuitf.library.util.ImageUtil;
import com.huihuitf.library.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Autowired
    private CategoryDao categoryDao;

    /**
     * 批量增加书籍
     *
     * @param bookList
     * @return
     */
    @Override
    public List<Book> saveBooks(List<Book> bookList) {
        List<Book> books = new ArrayList<>();
        for (Book book : bookList) {
            if (!bookDao.existsById(book.getBookId())) {
                bookDao.save(book);
                books.add(book);
            }
        }
        return books;
    }

    /**
     * 增加书籍
     *
     * @param book
     * @return
     */
    @Override
    public int saveBook(BookDto book) {
        if (!bookDao.existsById(book.getBookId())) {
            book.setOldId(book.getBookId());
            return updateBook(book);
        }
        else return 0;
    }

    /**
     * 删除书籍
     *
     * @param bookId
     */
    @Override
    public int deleteBook(String bookId) {

        if (bookDao.existsById(bookId)) {
            try {
                //删除图片
                PathUtil.deleteDir(bookDao.findById(bookId).get().getImg());
                bookDao.deleteById(bookId);
                return 1;
            } catch (Exception e) {
                return 0;
            }
        }

        return 0;

    }

    /**
     * 批量删除书籍
     *
     * @param bookList
     */
    @Override
    public void deleteBooks(List<Book> bookList) {
        for (Book book : bookList) {
            bookDao.deleteById(book.getBookId());
        }
    }

    @Override
    public int updateBook(BookDto bookParam) {
        try {
            Book book =new Book();
            if(!bookParam.getOldId().equals(bookParam.getBookId())) {
                bookDao.deleteById(bookParam.getOldId());
            }
            book.setBookId(bookParam.getBookId());
            book.setBookName(bookParam.getBookName());
            book.setImg(bookParam.getImg());
            book.setAuthor(bookParam.getAuthor());
            book.setStock(bookParam.getStock());
            book.setPrice(bookParam.getPrice());
            book.setPublicTime(bookParam.getPublicTime());
            book.setRent(bookParam.getRent());
            Category category = new Category();
            Supplier supplier = new Supplier();
            supplier.setSupplierId(bookParam.getSupplierId());
            category.setCategoryId(bookParam.getCategoryId());
            book.setBookCategory(category);
            book.setSupplier(supplier);
            book.setImg(bookParam.getImg());
            //删除原来图片
            PathUtil.deleteFiles(book.getImg());

            bookDao.save(book);

            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 通过名字模糊查询
     *
     * @param name
     * @return
     */
    @Override
    public List<Book> queryBookByNameOrAuthor(String name) {
        return bookDao.queryBookByBookNameLikeOrAuthorLike("%" + name + "%","%" + name + "%");
    }

    @Override
    public BookDto queryBookById(String bookId) {
        Book book = bookDao.findById(bookId).orElse(new Book());
        BookDto bookDto = new BookDto();
        bookDto.setBookId(book.getBookId());
        bookDto.setOldId(book.getBookId());
        bookDto.setBookName(book.getBookName());
        bookDto.setAuthor(book.getAuthor());
        bookDto.setImg(book.getImg());
        bookDto.setPrice(book.getPrice());
        bookDto.setStock(book.getStock());
        bookDto.setPublicTime(book.getPublicTime());

        bookDto.setCategoryId(book.getBookCategory().getCategoryId());
        bookDto.setCategoryName(book.getBookCategory().getCategoryName());
        bookDto.setSupplierId(book.getSupplier().getSupplierId());
        bookDto.setSupplierName(book.getSupplier().getSupplierName());

        return bookDto;
    }

    @Override
    public Page<Book> findAllBook(int pageNum, int pageSize, String bookId, String bookName, Integer categoryId, Integer supplierId) {
        Book book=new Book();
        Category category=new Category();
        Supplier supplier=new Supplier();
        if(bookId!=null&& !bookId.equals("")){
            book.setBookId(bookId);
        }
        if(bookName!=null&&!bookName.equals("")){
            book.setBookName(bookName);
        }
        if(categoryId!=null){
            category.setCategoryId(categoryId);
        }
        if(supplierId!=null){
            supplier.setSupplierId(supplierId);
        }
        book.setBookCategory(category);
        book.setSupplier(supplier);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("bookId", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("bookName" ,ExampleMatcher.GenericPropertyMatchers.contains());
        Example<Book> example=Example.of(book,matcher);
        Sort sort = new Sort(Sort.Direction.ASC, "bookId");
        Pageable pageable = PageRequest.of(pageNum, pageSize, sort);
        Page<Book> page=bookDao.findAll(example,pageable);
        return page;
    }

    @Override
    public int queryTotal(String bookId,String bookName,Integer categoryId,Integer supplierId) {
        return bookDao.queryTotal();
    }

    @Override
    public String addFace(String bookId, MultipartFile faceBook) {


        if (faceBook != null) {
            //先把图片存起来
            String dest = PathUtil.getBookFaceImagePath(bookId);
            //返回存放路径
            return ImageUtil.generateThumbnail(faceBook, dest);
        }
        return null;
    }

    @Override
    public void deleteBooks(String bookId) {
        bookDao.deleteBooksByBookIdLike("%" + bookId + "%");
    }

    @Override
    public int queryCountBySupplier(Integer id) {
        List<Book> list = bookDao.queryBooksBySupplier_SupplierId(id);
        return list.size();
    }

    @Override
    public List<Book> queryBookByCategory(int id) {

        return bookDao.queryBooksByBookCategory_CategoryId(id);
    }
}
