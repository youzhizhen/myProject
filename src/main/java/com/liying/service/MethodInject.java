package com.liying.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class MethodInject implements ApplicationContextAware{
    
    private ApplicationContext applicationContext;
    
    
    
    public Object process(int i) {
        CommandService command = createCommand();
        command.setStatust(i);
        return command.execute();
     }

     protected CommandService createCommand() {
        return this.applicationContext.getBean("commandService", CommandService.class);
     }

    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        this.applicationContext = applicationContext;
    }
}
