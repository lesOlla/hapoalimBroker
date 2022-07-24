package broker.producer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import broker.dto.ReturnDto;
import broker.listener.Consumer;


@Component
@Service
public class EventSender {
	Random random= new Random();
	private int maxId = 10;
	private int maxData = 200;
	private int minData = 1;
	private int minId = 1;
	
	@Bean
	public Supplier<ReturnDto> sendSensorData(){
		return ()->{
			String id = ""+(minId+random.nextInt(maxId-minId+1));
			LinkedHashMap<String, String> data = new LinkedHashMap<>();
			data.put((""+minData), (""+maxData));
			return new ReturnDto(id, data);
		};
	}
	/*
	 * @Autowired Consumer consumer;
	 * 
	 * public EventSender(Consumer consumer) { this.consumer = consumer;
	 * System.out.println("Sent sample message [" + consumer.getMes() + "]"); }
	 */
	
	/*
	 * private final KafkaTemplate<String, ReturnDto> kafkaTemplate; private String
	 * topic="${cloudkarafka.outtopic}";
	
	
	/*
	 * EventSender(KafkaTemplate<String, ReturnDto> kafkaTemplate) {
	 * this.kafkaTemplate = kafkaTemplate; }
	 

    public void send(Consumer consumer) {
        this.kafkaTemplate.send(topic, consumer.getMes());
        System.out.println("Sent sample message [" + consumer.getMes() + "] to " + topic);
    }
	*/
	
	/*@Bean
	public Supplier<ReturnDto> sendSensorData(Consumer consumer){
		return ()->{
			System.out.println("Sent sample message [" + consumer.getMes() + "]");
			return consumer.getMes();
		};}
*/	
}
