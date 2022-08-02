package broker.service;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import broker.dto.RequestDto;
import broker.dto.ReturnDto;

@Service
public class HapoalimBrokerService {
ObjectMapper mapper = new ObjectMapper(); 
	@Autowired
	StreamBridge streamBridge;

	@Bean
	public Consumer<RequestDto> handleRequestDto() {
		//TODO separate ENUM list for sep operations, map - keyword, value - special ReturnDto constructor
		//TODO Exception handlers
		return message -> {
			ReturnDto temp = new ReturnDto(null);
			 if (message.getHeaders().getOperation().equalsIgnoreCase("Delete")) { 
				 temp = new ReturnDto(message.getPk()); } 
			 if
			  (message.getHeaders().getOperation().equalsIgnoreCase("Insert") ||
					  message.getHeaders().getOperation().equalsIgnoreCase("Update")) {
				 temp = new ReturnDto(message.getPk(), message.getData()); }
			  
			try { 
				String mess= mapper.writeValueAsString(temp);
			 streamBridge.send("sendSensorData-out-0", mess); }
			 catch (JsonProcessingException e) { 
			 e.printStackTrace(); }
			 
		 return;
		};
	}
}
