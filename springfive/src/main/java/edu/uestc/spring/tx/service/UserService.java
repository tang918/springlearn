package edu.uestc.spring.tx.service;

import edu.uestc.spring.tx.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
public class UserService {

    @Autowired
    private UserDao userDao;


    public void accountMoney(){

            userDao.reduceMoney();
            userDao.addMoney();
    }
}
