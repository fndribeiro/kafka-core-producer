package br.com.ribeiro.fernando.kafkacoreproducer.ports.kafka.topics;

public class KafkaTopics {

	private final static String TOPIC_PREFIX = "nemhdkh3-";
	private final static String HELLO = "hello";
	
	public static String hello() {
		return TOPIC_PREFIX + HELLO;
	}
	
}
