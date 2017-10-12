package com.lzx.ssm.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 获取spring的上下文
 * @author lzx
 */
@Component("springContextUtil")  
public class SpringContextUtil implements ApplicationContextAware {  
    @Autowired  
    private ApplicationContext ac;  
  
    public void setApplicationContext(ApplicationContext ctx) {  
        this.ac = ctx;  
    }  
  
    public ApplicationContext getApplicationContext() {  
        return this.ac;  
    }  
  
    /** 
     * @param name 
     * @return bean
     */  
    public Object getBean(String name){  
        return ac.getBean(name);  
    }  
  
}  
