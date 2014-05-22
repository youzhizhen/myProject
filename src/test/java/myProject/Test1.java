package myProject;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liying.service.UserService;
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class Test1 {

        private static final Logger logger = Logger.getLogger(UserviceTest.class);

        private UserService userService;

        @Test
        public void testGetUsername() {
            logger.info(userService.ToString());

        }
}
