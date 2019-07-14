package com.huihuitf.library.service.impl;

import com.huihuitf.library.dao.BookDao;
import com.huihuitf.library.dao.HistoryDao;
import com.huihuitf.library.dto.HistoryDto;
import com.huihuitf.library.entity.Book;
import com.huihuitf.library.entity.History;
import com.huihuitf.library.entity.User;
import com.huihuitf.library.service.HistoryService;
import com.huihuitf.library.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    private HistoryDao historyDao;
    @Autowired
    private BookDao bookDao;

    @Override
    public History add(HistoryDto historyDto) {
        if(historyDto.getRentCount()==0){
            return null;
        }
        String id = ImageUtil.getRandomFileName() + historyDto.getRentDay() + historyDto.getRentCount();
        History history = new History();
        history.setHistoryId(id);
        history.setBook(new Book(historyDto.getBookId()));
        history.setUser(new User(historyDto.getUserId()));
        history.setMoney(historyDto.getMoney());
        history.setNum(historyDto.getRentCount());
        history.setRentTime(new Date());
        history.setTime(historyDto.getRentDay());
        history.setStatus(0);
        Book book = bookDao.findById(history.getBook().getBookId()).orElse(new Book());
        book.setStock(book.getStock()-history.getNum());
        return historyDao.save(history);
    }

    @Override
    public List<History> findAllBook(int pageNum, int pageSize) {
        Sort sort = new Sort(Sort.Direction.ASC, "historyId");
        Pageable pageable = PageRequest.of(pageNum, pageSize, sort);
        Page<History> bookPage = historyDao.findAll(pageable);
        return bookPage.getContent();
    }

    @Override
    public int queryTotal() {
        return historyDao.findAll().size();
    }

    @Override
    public List<History> findBookByUserId(Long id) {
        return historyDao.findHistoriesByUser_UserId(id);
    }

    @Override
    public boolean huan(String id) {
        try {
            History history = historyDao.findById(id).orElse(new History());
            if (history.getHistoryId() == null)
                return false;
            Book book = bookDao.findById(history.getBook().getBookId()).orElse(new Book());
            book.setStock(book.getStock() + history.getNum());
            history.setStatus(1);
            history.setRemandTime(new Date());
            bookDao.save(book);
            historyDao.save(history);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
