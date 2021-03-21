package database;

import com.sgw.common.domain.Project;
import com.sgw.common.domain.Role;
import com.sgw.common.domain.Task;
import com.sgw.common.domain.TaskState;
import com.sgw.common.domain.User;
import com.sgw.common.service.ProjectService;
import com.sgw.common.service.TaskService;
import com.sgw.common.service.UserService;
import com.sgw.web.WebApplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class)
public class SgwDatabaseTest {

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

    @Autowired
    private ProjectService projectService;
    @Autowired
    private TaskService taskService;

    @Test
    public void ProjectAndTaskInsertTest() {
        Long userNo = 1L;
        User findUser = userService.findByUserNo(userNo).get();

        String projectTitle = "프로젝트 제목";
        String projectDesc = "프로젝트 설명";
        Short openYn = 1;
        Project project = new Project(projectTitle, projectDesc, findUser, openYn);

        projectService.save(project);

        String taskTitle = "일감 제목";
        String taskDesc = "일감 내용";
        LocalDateTime startDt = LocalDateTime.now();
        LocalDateTime endDt = LocalDateTime.now();
        TaskState taskState = TaskState.NEW;

        Task task = new Task(taskTitle, taskDesc, startDt, endDt, taskState, project, findUser);
        taskService.save(task);

        Task findTask = taskService.findByTaskNo(task.getTaskNo()).get();
        assertThat(findTask).isNotNull();
        assertThat(findTask.getTaskTitle()).isEqualTo(taskTitle);
    }

    @Test
    public void encoding_test() {
        System.out.println("한글이 잘 나오나..;;;");
    }
}