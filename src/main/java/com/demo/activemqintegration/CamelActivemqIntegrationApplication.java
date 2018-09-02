package com.demo.activemqintegration;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.activemqintegration.router.MyRouterForActiveMQ;

@SpringBootApplication
public class CamelActivemqIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CamelActivemqIntegrationApplication.class, args);
		
		
		/*
		CamelContext camelContext = new DefaultCamelContext();
		
		//Configure JMS Component
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");
		camelContext.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
		
		
		try {
			camelContext.addRoutes(new MyRouterForActiveMQ());
			
			camelContext.start();
			
			Thread.sleep(5 * 60 * 1000);
			
			camelContext.stop();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
	}
}
