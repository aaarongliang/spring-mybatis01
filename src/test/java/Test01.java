import com.liangyu.controller.UserController;
import com.liangyu.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test01 {
    ApplicationContext applicationContext;
    UserController userController;
    @Before
    public void before(){
        applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        userController = applicationContext.getBean("userController",UserController.class);
    }


    @Test
    public void test01(){
        List<User> userList = userController.queryUserList();
        System.out.println(userList);
    }

    @Test
    public void test02(){
        User user = userController.getUserByName("lala");
        System.out.println(user);
    }

    @Test
    public void test03(){
        List<User> userLists = userController.queryUserList();
        System.out.println(userLists);
        User user = new User("zaza","123456");
        System.out.println(userController.insertUser(user));
        List<User> userList = userController.queryUserList();
        System.out.println(userList);
    }

    @Test
    public void test04(){
        User user =new User("lala","111111");
        System.out.println(userController.updateUser(user));
    }
}
