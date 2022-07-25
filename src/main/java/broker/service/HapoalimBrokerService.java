package broker.service;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import broker.dto.RequestDto;
import broker.dto.ReturnDto;

@Service
public class HapoalimBrokerService {

	@Autowired
	StreamBridge streamBridge;

	@Bean
	public Consumer<RequestDto> handleRequestDto() {
		return requestDto -> {
			System.out.println("got: " + requestDto.getPk() + ", operation: " + requestDto.getHeaders().getOperation());
			ReturnDto temp = null;
			if (requestDto.getHeaders().getOperation().equalsIgnoreCase("Delete")) {
				temp = new ReturnDto(requestDto.getPk(), null);
			}
			if (requestDto.getHeaders().getOperation().equalsIgnoreCase("Insert")
					|| requestDto.getHeaders().getOperation().equalsIgnoreCase("Update")) {
				temp = new ReturnDto(requestDto.getPk(), requestDto.getData());
			}
			streamBridge.send("sendSensorData-out-0", temp);
			return;
		};
	}
}
