package io.cloudtype.springrabbit;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class SpringRabbitConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRabbitConsumerApplication.class, args);
	}

	@RabbitListener(queues = "chat_notification")
	public void receiveMessage(String message) {
		try {
			System.out.println("Received message: " + message);
		} catch (Exception e) {
			System.err.println("Error processing message: " + e.getMessage());
		}
	}
}
