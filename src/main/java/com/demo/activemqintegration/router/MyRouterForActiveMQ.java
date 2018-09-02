package com.demo.activemqintegration.router;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyRouterForActiveMQ extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		/** EIP Splitter **/
		// For sending the splitted contents as message to JMS queue directly
		/*
		from("file:C:/camel/InputFolder")
		.split()
		.tokenize("\n")
		.to("jms:queue:amit.inbound.queue");
		
		*/
		
		
		
		
		from("file:C:/camel/InputFolder")
		.split()
		.tokenize("\n")
		.to("direct:test");
		
		
		/** EIP Content Based Router **/
		
		/*
		from("direct:test")
		.choice()
		.when(body().contains("EnqBal"))
		.to("jms:queue:Balance Enquire Queue")
		.when(body().contains("InPay"))
		.to("jms:queue:Inward Payment Queue")
		.otherwise()
		.to("jms:queue:Otherwise Queue");
		*/
		
		/** EIP Message Filter **/
		
		/*
		from("direct:test")
		.filter(body().contains("Amit"))
		.to("jms:queue:Otherwise Queue");
		
		*/
		/** EIP Recipient List **/
		
		
		from("direct:test")
		.process(new Processor() {
			@Override
			public void process(Exchange exchange) throws Exception {
				String recipient = exchange.getIn().getBody().toString();
				String recipientQueue = "jms:queue:"+recipient;	
				exchange.getIn().setHeader("queue", recipientQueue);
			}
		}).recipientList(header("queue"));
		
		
	}

}
