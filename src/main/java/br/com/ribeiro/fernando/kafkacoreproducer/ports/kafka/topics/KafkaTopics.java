package br.com.ribeiro.fernando.kafkacoreproducer.ports.kafka.topics;

public class KafkaTopics {

	private final static String TOPIC_PREFIX = "nemhdkh3-";
	private final static String HELLO = "hello";
	private final static String EMPLOYEE = "employee";
	
	public static String hello() {
		return TOPIC_PREFIX + HELLO;
	}
	
	public static String employee() {
		return TOPIC_PREFIX + EMPLOYEE;
	}
	
}
