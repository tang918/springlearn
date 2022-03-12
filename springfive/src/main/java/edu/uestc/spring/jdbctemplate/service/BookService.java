package edu.uestc.spring.jdbctemplate.service;

import edu.uestc.spring.jdbctemplate.dao.BookDao;
import edu.uestc.spring.jdbctemplate.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookDao bookDao;

    // 添加方法
    public void addBook(Book book){
        bookDao.add(book);
    }

    //修改的方法
    public void updateBook(Book book) {
        bookDao.update(book);
    }

    // 删除的方法
    public void deleteBook(String id){
        bookDao.delete(id);
    }

    // 查询表记录数
    public int findCount(){
        return bookDao.selectCount();
    }

    // 查询返回对象
    public Book findOne(String id){
        return bookDao.findOne(id);
    }

    // 查询返回集合
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    // 批量添加
    public int  batchAdd(List<Object[]> batchArgs){
        return bookDao.batchAdd(batchArgs);
    }

    // 批量修改
    public void batchUpdate(List<Object[]> batchArgs){
        bookDao.batchUpdate(batchArgs);
    }

    // 批量删除
    public void batchDelete(List<Object[]> batchArgs){
        bookDao.batchDelete(batchArgs);

    }

}
