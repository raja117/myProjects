package com.spring.practise;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

	public static void main(String args[])
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("persoanlinfo.xml");
//		PersonalInfo pi = (PersonalInfo) context.getBean("personaldetails");
//		pi.setFirstName("Raja");
//		pi.setLastName("gogula");
//		pi.setMiddleName("Naga");
//		pi.setGender("male");
//		//PersonalInfo pi2 = (PersonalInfo) context.getBean("personaldetails");
//		System.out.println(pi2.getFirstName());
//		System.out.println(pi2.getLastName());
//		System.out.println(pi2.getMiddleName());
//		System.out.println(pi2.getGender());
		context.close();
	}
}
