package com.spring.practise;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class FirstPostProcessor implements BeanPostProcessor, Ordered {

	private int order;
	
	public void setOrder(int order)
	{
		this.order = order;
	}
	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return order;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("in first post processor, before intialization");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("in first post processor, after intialization");
		return bean;
	}
	
}
