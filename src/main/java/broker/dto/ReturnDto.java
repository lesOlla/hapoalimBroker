package broker.dto;

import java.io.Serializable;
import java.util.LinkedHashMap;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode()
@ToString
public class ReturnDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String pk;
	LinkedHashMap <String, String> data;

}
