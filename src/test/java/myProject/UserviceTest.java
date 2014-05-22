package myProject;

import javax.annotation.Resource;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liying.service.ClientService;
import com.liying.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class UserviceTest extends TestCase {
    
    private static final Logger logger = Logger.getLogger(UserviceTest.class);
    
    @Resource(name = "test")
    private UserService teszt;
    
    @Resource
    private ClientService clientService;
    @Test
    public void testGetUsername(){
        logger.info(teszt.ToString());
        
    }
    @Test
    public void testFactoryMethod(){
        logger.info(clientService.createInstance().getName());
        
    }

}
