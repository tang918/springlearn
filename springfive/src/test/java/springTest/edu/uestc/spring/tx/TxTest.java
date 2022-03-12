package springTest.edu.uestc.spring.tx;

import edu.uestc.spring.entity.User;
import edu.uestc.spring.jdbctemplate.service.BookService;
import edu.uestc.spring.tx.config.TxConfig;
import edu.uestc.spring.tx.service.UserService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class TxTest {

    @Test
    public void testDemo(){
        ApplicationContext context = new ClassPathXmlApplicationContext("xml\\property.xml") ;
        UserService userService = context.getBean("userService",UserService.class);
        userService.accountMoney();
    }
    @Test
    public void testConfig(){
        ApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = context.getBean("userService",UserService.class);
        userService.accountMoney();
    }
    @Test
    public void test1(){
        System.out.println("dwe");
        Logger log= LoggerFactory.getLogger(TxTest.class);
        log.info("0000000");
    }

    // 函数式风格创建对象，交给spring管理
    @Test
    public void testGenericApplicationContext(){

        // 1. 创建GenericApplicationContext对象
        GenericApplicationContext context = new GenericApplicationContext();
        //2. 调用context的方法注册对象
        context.refresh();
        context.registerBean("user1",User.class,()->new User());
        // 3. 获取在spring中注册的对象
        User user = (User)context.getBean("user1");
    }



}
