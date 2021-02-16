package database;

import com.swg.common.domain.Book;
import com.swg.common.domain.BookStore;
import com.swg.common.domain.Role;
import com.swg.common.domain.User;
import com.swg.common.service.BookService;
import com.swg.common.service.BookStoreService;
import com.swg.common.service.UserService;
import com.swg.web.WebApplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class)
public class SwgDatabaseTest {

    @Autowired
    private UserService userService;

    @Test
    public void databaseConnectTest() {
        String nickNm = "testUser004";
        String pwd = "123456";
        String email = "test@gmail.com";
        User user = new User(nickNm, pwd, email, Role.GUEST);

        System.out.println("save");
        userService.save(user);

        System.out.println("get");
        User findUser = userService.findByUserNo(user.getUserNo()).get();

        assertThat(findUser).isNotNull();
        assertThat(findUser.getNickNm()).isEqualTo(nickNm);
    }

    @Autowired
    private BookStoreService bookStoreRepository;
    @Autowired
    private BookService bookRepository;

    @Test
    public void contextloads() {
        BookStore bookStore = new BookStore();
        bookStore.setNm("bookstore2");
        bookStoreRepository.save(bookStore);

        Book book = new Book();
        book.setTitle("book2");
        book.setIsbn("isbn2");
        book.setBookStore(bookStore);

        Book book2 = new Book();
        book2.setTitle("book3");
        book2.setIsbn("isbn3");
        book2.setBookStore(bookStore);

        bookRepository.save(book);
        bookRepository.save(book2);
    }
}