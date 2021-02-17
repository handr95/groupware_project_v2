package database;

import com.swg.common.domain.Role;
import com.swg.common.domain.User;
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
        String nickNm = "testUser001";
        String pwd = "123456";
        String email = "test@gmail.com";
        User user = new User(nickNm, pwd, email, Role.GUEST);

        userService.save(user);

        User findUser = userService.findByUserNo(user.getUserNo()).get();

        assertThat(findUser).isNotNull();
        assertThat(findUser.getNickNm()).isEqualTo(nickNm);
    }

    @Test
    public void ProjectAndTaskInsertTest() {
        String nickNm = "testUser001";
        String pwd = "123456";
        String email = "test@gmail.com";
        User user = new User(nickNm, pwd, email, Role.GUEST);

        userService.save(user);

        User findUser = userService.findByUserNo(user.getUserNo()).get();

        assertThat(findUser).isNotNull();
        assertThat(findUser.getNickNm()).isEqualTo(nickNm);
    }
}