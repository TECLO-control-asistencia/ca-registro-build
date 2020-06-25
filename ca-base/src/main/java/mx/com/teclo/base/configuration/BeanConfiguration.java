package mx.com.teclo.base.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = { "mx.com.teclo" })
public class BeanConfiguration {

//	@Bean("restTemplate")
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}

}
