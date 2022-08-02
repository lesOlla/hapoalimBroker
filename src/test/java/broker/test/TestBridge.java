/*
 * package broker.test;
 * 
 * import static org.assertj.core.api.Assertions.assertThat; import static
 * org.junit.jupiter.api.Assertions.*;
 * 
 * import java.nio.charset.StandardCharsets; import java.sql.Timestamp; import
 * java.util.LinkedHashMap; import java.util.function.Function;
 * 
 * import org.junit.jupiter.api.BeforeAll; import org.junit.jupiter.api.Test;
 * import org.springframework.beans.factory.NoSuchBeanDefinitionException;
 * import org.springframework.boot.WebApplicationType;a import
 * org.springframework.boot.builder.SpringApplicationBuilder; import
 * org.springframework.cloud.stream.binder.test.InputDestination; import
 * org.springframework.cloud.stream.binder.test.OutputDestination; import
 * org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
 * import org.springframework.context.ConfigurableApplicationContext; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.integration.support.MessageBuilder; import
 * org.springframework.messaging.Message; import
 * org.springframework.messaging.support.GenericMessage;
 * 
 * import broker.dto.HeaderDto; import broker.dto.RequestDto;
 * 
 * class TestBridge {
 * 
 * @BeforeAll static void setUpBeforeClass() throws Exception {
 * 
 * LinkedHashMap <String, String>temp=new LinkedHashMap<>(); temp.put("a",
 * "foo"); temp.put("b", "bar"); temp.put("c", "123"); temp.put("a", "foof");
 * RequestDto sample1 = new RequestDto("123456", temp, null, new
 * HeaderDto("Insert", Timestamp.valueOf("2021-01-27 13:42:13.383"),
 * "123154689132138433181312132194984313218")); RequestDto sample2 = new
 * RequestDto("123457", temp, "2020-01-27 13:42:13.383", new HeaderDto("update",
 * Timestamp.valueOf("2021-01-27 13:42:13.383"),
 * "123154689132138433181312132194984313218")); RequestDto sample3 = new
 * RequestDto("123458", temp, null, new HeaderDto("Delete",
 * Timestamp.valueOf("2021-01-27 13:42:13.383"),
 * "123154689132138433181312132194984313218")); }
 * 
 * 
 * 
 * 
 * 
 * @Test void testHandleRequestDto() { String jsonPayload = "{\r\n" +
 * "  \"pk\": \"123456\",\r\n" +
 * "  \"data\": {\"a\":  \"foo\", \"b\":  \"bar\", \"c\": 123},\r\n" +
 * "  \"beforeData\": null,\r\n" + "  \"headers\": {\r\n" +
 * "    \"operation\": \"INSERT\",\r\n" +
 * "    \"timestamp\": \"2021-01-27T13:42:13.383\",\r\n" +
 * "    \"streamPosition\": \"123154689132138433181312132194984313218\"\r\n" +
 * "  }}"; ConfigurableApplicationContext context = new
 * SpringApplicationBuilder(TestChannelBinderConfiguration
 * .getCompleteConfiguration()) .web(WebApplicationType.NONE)
 * .run("--spring.cloud.stream.function.definition=handleRequestDto",
 * "--spring.jmx.enabled=false");
 * 
 * InputDestination source = context.getBean(InputDestination.class);
 * //System.out.println(jsonPayload.getBytes().length);
 * //System.out.println(jsonPayload); Message<byte[]> inputMessage =
 * MessageBuilder.withPayload(jsonPayload.getBytes()).build();
 * 
 * source.send(inputMessage);
 * 
 * OutputDestination target = context.getBean(OutputDestination.class);
 * assertThat(target.receive().getPayload())
 * .isEqualTo(jsonPayload.getBytes(StandardCharsets.UTF_8));
 * 
 * 
 * }
 * 
 * }
 */