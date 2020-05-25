import com.liangyu.controller.UserController;
import com.liangyu.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Test
    public void test07(){
        Map<String,String> map=new HashMap<>();
        map.put("username","wawa");
        map.put("password","123456");
        System.out.println(userController.selectUserByMap(map));
    }

    @Test
    public void test08(){
        System.out.println(userController.queryCount());
    }

    @Test
    public void test09(){
        int count = userController.queryCount();
        int pageSize = 4;
        int size = count/pageSize;
        int value = count%pageSize;
        if(value>0){
            size = size+1;
        }
        Map<String,Object> map = new HashMap<>();
        for (int i = 1; i <= size; i++) {
            int page=i;
            int curPage=(page-1)*pageSize;
            map.put("curPage",curPage);
            map.put("pageSize",pageSize);
            List<User> userList = userController.selectUserByPage(map);
            System.out.println(userList);
            userController.insertList(userList);
        }
    }

    @Test
    public void insertList(){
        List<User> userList = new ArrayList<>();
        User user = new User(19,"iaia","12343");
        User user2 = new User(20,"iaia","12343");
        userList.add(user);
        userList.add(user2);
        userController.insertList(userList);
    }
}
