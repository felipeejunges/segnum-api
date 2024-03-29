package br.com.segnum.api.config;

import br.com.segnum.api.domain.Event;
import br.com.segnum.api.domain.Location;
import br.com.segnum.api.repositories.EventRepository;
import br.com.segnum.api.repositories.LocationRepository;
import br.com.segnum.api.services.helpers.DBService;
import br.com.segnum.api.services.helpers.email.EmailService;
import br.com.segnum.api.services.helpers.email.SMTPEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;
import java.util.List;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired
	private DBService dbService;

	@Autowired
	private EventRepository eRepo;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {

//		List<Event> near = eRepo.findNear("-24.4568614", "-48.2505684", 10);

		if(! "create".equals(strategy) && ! "create-drop".equals(strategy)) {
			return false;
		}
		
		dbService.instantiateTestDatabase();
		
		return true;
	}
	
	@Bean
	public EmailService emailService() {
		return new SMTPEmailService();
	}
	
}
