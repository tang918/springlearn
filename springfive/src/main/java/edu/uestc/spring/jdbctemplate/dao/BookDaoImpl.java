package edu.uestc.spring.jdbctemplate.dao;

import edu.uestc.spring.jdbctemplate.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao{
    //注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 添加的方法
    @Override
    public void add(Book book) {
        String sql = "insert into book values(?,?,?)";
        Object[] args={book.getUserId(),book.getUsername(),book.getUstatus()};
        // 返回值表示添加成功后的影响行数
        int update=jdbcTemplate.update(sql,args);
        System.out.println(update);
    }

    @Override
    public void update(Book book) {
        String sql = "update book set username=?,ustatus=? where userId=?";
        Object[] args={book.getUsername(),book.getUstatus(),book.getUserId()};
        int update=jdbcTemplate.update(sql, args);
    }

    @Override
    public void delete(String id) {
        String sql = "delete from book  where userId=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public int selectCount() {
        String sql="select count(*) from book";
        // 第一个参数为sql语句，第二个参数为需要返回的类型
        int result= jdbcTemplate.queryForObject(sql,Integer.class);
        return result;
    }

    @Override
    public Book findOne(String id) {
        String sql = "select * from book where userId=?";
       Book book= jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class),id);
        return book;
    }

    @Override
    public List<Book> findAll() {
        String sql = "select * from book";
        List<Book> books= jdbcTemplate.query(sql,new BeanPropertyRowMapper<Book>(Book.class));
        return books;
    }

    @Override
    public int batchAdd(List<Object[]> batchArgs) {
        String sql="insert into book values(?,?,?)";
        int[] result = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(result));
        return 0;
    }

    @Override
    public void batchUpdate(List<Object[]> batchArgs) {
        String sql="update book set username=?,ustatus=? where userId=?";
        int[] res=jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(Arrays.toString(res));
    }

    @Override
    public void batchDelete(List<Object[]> batchArgs) {
        String sql = "delete from book  where userId=?";
        jdbcTemplate.batchUpdate(sql,batchArgs);
    }
}
