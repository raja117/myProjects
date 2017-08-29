package com.spring.practise;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

	public static void main(String args[])
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
		//PersonalInfo pi = (PersonalInfo) context.getBean("personalinfo");
//		pi.setFirstName("Raja");
//		pi.setLastName("gogula");
//		pi.setMiddleName("Naga");
//		pi.setGender("male");
		ContactInfo ci = (ContactInfo) context.getBean("contactinfo");
		System.out.println(ci.getFirstName()+" "+ci.getLastName());
		System.out.println(ci.getCity());
		System.out.println(ci.getState());
		System.out.println(ci.getCountry());
		context.close();
	}
}