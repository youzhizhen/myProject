package myProject;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;

public class TestSpringIOC {
    @Test  
    public void testByteArrayResource() {  
    Resource resource = new ByteArrayResource("Hello World!".getBytes());  
            if(resource.exists()) {  
                dumpStream(resource);  
            }
            Assert.assertEquals(false, resource.isOpen());  
    }
    
    private void dumpStream(Resource resource) {  
        InputStream is = null;  
        try {  
            //1.获取文件资源  
            is = resource.getInputStream();  
            //2.读取资源  
            byte[] descBytes = new byte[is.available()];  
            is.read(descBytes);  
            System.out.println(new String(descBytes));  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        finally {  
            try {  
                //3.关闭资源  
                is.close();  
            } catch (IOException e) {  
            }  
        }  
    }  

}
