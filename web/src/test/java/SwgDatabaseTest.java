import com.swg.WebApplication;
import com.swg.domain.User;
import com.swg.service.UserService;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class)
public class SwgDatabaseTest {

    @Autowired
    private UserService userService;

    @Test
    public void test(){
        System.out.println("1234");
    }

    @Test
    public void databaseConnectTest() {
        User user = new User();
        user.setNickNm("testUser001");
        user.setPwd("123456");
        user.setEmail("test@gmail.com");
        user.setLoginDt(new Date());
        user.setRegDt(new Date());

        userService.save(user);
        Assert.notNull(userService.findByUserNo(user.getUserNo()), "User info not null. userNo : " + user.getUserNo());
    }
}