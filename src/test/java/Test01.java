import com.liangyu.controller.UserController;
import com.liangyu.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
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

    @Test
    public void test05(){
        List<User> userList=new ArrayList<>();
        User user1 = new User("lala","123");
        User user2 = new User("wawa","123");
        userList.add(user1);
        userList.add(user2);
        System.out.println(userController.updateUserByNames(userList));

    }

    @Test
    public void test06(){
        List<String> list = new ArrayList<>();
        list.add("wawa");
        list.add("gaga");
        System.out.println(userController.selectUserByNames(list));
    }
}
