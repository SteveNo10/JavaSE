package com.spring.task;

import java.util.Calendar;

import org.springframework.stereotype.Service;  
@Service  
public class TaskJob {  
      
    public void job1() {  
    	Calendar calendar = Calendar.getInstance();
        System.out.println("任务进行中。。。" + calendar.getTime().toString());  
    }  
} 