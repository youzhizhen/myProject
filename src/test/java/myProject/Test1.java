package myProject;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liying.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class Test1 implements ApplicationContextAware{

    private ApplicationContext applicationContext;
    

    @Test
    public void test1() {
         
        UserService u1 = this.createUserService();
        u1.setName("liying");
        UserService u2 = this.createUserService();
        u2.setName("nihao");
        System.out.println(u1.toString());
        System.out.println(u2.toString());

    }
    

    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        this.applicationContext = applicationContext;
        
    }
    
    public UserService createUserService(){
        return applicationContext.getBean("userService", UserService.class);
    }
}
