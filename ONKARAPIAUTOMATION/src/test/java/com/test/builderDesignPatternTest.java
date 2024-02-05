package com.test;
import org.testng.annotations.Test;

import com.pojo.StudentsInfo;

public class builderDesignPatternTest {
	
	@Test
    public void buildTest(){

        StudentsInfo studentInfo=new StudentBuilder()
                .setId(18)
                .setFirstname("Onkar")
                .setLastname("Bhole")
                .setEmail("Ob@gmail.com").build();

        System.out.println(studentInfo);
    }

}
