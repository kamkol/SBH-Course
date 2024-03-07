package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.sbh_course.springcoredemo.common.Coach;
import com.sbh_course.springcoredemo.common.SwimCoach;

@Configuration
public class SportConfig {
	
	@Bean
	public Coach swimCoach() {
		return new SwimCoach();
	}
	
}
