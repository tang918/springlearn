package springTest.edu.uestc.spring.jdbcTemplate.dao;

import edu.uestc.spring.jdbctemplate.entity.Book;
import edu.uestc.spring.jdbctemplate.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class JdbcTemplateTest {

    @Test
    public void testAdd(){
       ApplicationContext context = new ClassPathXmlApplicationContext("xml\\property.xml") ;
        BookService bookService = context.getBean(BookService.class);

        Book book = new Book();
        book.setUserId("1");
        book.setUsername("java");
        book.setUstatus("a");
        bookService.addBook(book);


        for(int i = 2;i<100;i++){

            Book book1 = new Book(String.valueOf(i),String.valueOf(i)+":book",String.valueOf(i)+": status");
            bookService.addBook(book1);
        }

    }

    @Test
    public void updateTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("xml\\property.xml") ;
        BookService bookService = context.getBean(BookService.class);
        Book book = new Book("1","呐喊","b");
        bookService.updateBook(book);

    }

    @Test
    public void deleteTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("xml\\property.xml") ;
        BookService bookService = context.getBean(BookService.class);
        bookService.deleteBook("1");
    }

    @Test
    public void testCount(){
        ApplicationContext context = new ClassPathXmlApplicationContext("xml\\property.xml") ;
        BookService bookService = context.getBean(BookService.class);
        int result = bookService.findCount();
        System.out.println(result);
    }

    @Test
    public void testOneObject(){
        ApplicationContext context = new ClassPathXmlApplicationContext("xml\\property.xml") ;
        BookService bookService = context.getBean(BookService.class);
        Book book = bookService.findOne("2");
        System.out.println(book);
    }

    @Test
    public void testAll(){
        ApplicationContext context = new ClassPathXmlApplicationContext("xml\\property.xml") ;
        BookService bookService = context.getBean(BookService.class);
        List<Book> list = bookService.findAll();
        for(Book book:list){
            System.out.println(book);
        }

    }

    @Test
    public void testBatchAdd(){
        ApplicationContext context = new ClassPathXmlApplicationContext("xml\\property.xml") ;
        BookService bookService = context.getBean(BookService.class);
        List<Object[]> batchArgs=new ArrayList<>();
        for(int i = 200;i<300;i++){
            Object[] o={String.valueOf(i),String.valueOf(i)+":book",String.valueOf(i)+": status"};
            batchArgs.add(o);
        }
        bookService.batchAdd(batchArgs);
    }

    @Test
    public void testBatchUpdate(){
        ApplicationContext context = new ClassPathXmlApplicationContext("xml\\property.xml") ;
        BookService bookService = context.getBean(BookService.class);
        List<Object[]> batchArgs=new ArrayList<>();
        for(int i = 10;i<20;i++){
            Object[] o={String.valueOf(i+1)+":books",String.valueOf(i+1)+": status",String.valueOf(i)};
            batchArgs.add(o);
        }
        bookService.batchUpdate(batchArgs);
    }

    @Test
    public void testBatchDelete(){
        ApplicationContext context = new ClassPathXmlApplicationContext("xml\\property.xml") ;
        BookService bookService = context.getBean(BookService.class);
        List<Object[]> batchArgs=new ArrayList<>();
        for(int i = 2;i<10;i++){
            Object[] o={String.valueOf(i)};
            batchArgs.add(o);
        }
        bookService.batchDelete(batchArgs);
    }
}
