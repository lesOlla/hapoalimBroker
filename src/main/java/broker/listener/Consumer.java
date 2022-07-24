package broker.listener;
  
import org.springframework.kafka.annotation.KafkaListener; 
import org.springframework.stereotype.Component; 

import broker.dto.RequestDto;
import broker.dto.ReturnDto;

@Component
public class Consumer {
	private ReturnDto mes;
		
	public ReturnDto getMes() {
		return mes;
	}

	public void setMes(ReturnDto mes) {
		this.mes = mes;
	}


	@KafkaListener(topics = "${cloudkarafka.intopic}", containerFactory =
	 "kafkaListenerContainerFactory") 
	public void processMessage(RequestDto message) {
		if(message.getHeaders().getOperation().equalsIgnoreCase("Delete")) {
			this.mes = new ReturnDto(message.getPk(), null);
		}
		if(message.getHeaders().getOperation().equalsIgnoreCase("Insert")||message.getHeaders().getOperation().equalsIgnoreCase("Update"))
		this.mes = new ReturnDto(message.getPk(), message.getData());
		System.out.println(message.getHeaders().getOperation());		
	}
}
	
