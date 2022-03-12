package edu.uestc.spring.jdbctemplate.dao;

import edu.uestc.spring.jdbctemplate.entity.Book;

import java.util.List;

public interface BookDao {

    // 添加的方法
    void add(Book book);

    void update(Book book);

    void delete(String id);

    int selectCount();

    Book findOne(String id);

    List<Book> findAll();

    int batchAdd(List<Object[]> batchArgs);

    void batchUpdate(List<Object[]> batchArgs);

    void batchDelete(List<Object[]> batchArgs);
}
