package edu.uestc.spring.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addMoney() {
        String sql ="update t_count set money=money+? where username=?";
        jdbcTemplate.update(sql,100,"mary");
    }

    @Override
    public void reduceMoney() {
        String sql ="update t_count set money=money-? where username=?";
        jdbcTemplate.update(sql,100,"lucy");
    }
}
