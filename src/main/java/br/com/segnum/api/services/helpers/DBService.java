package br.com.segnum.api.services.helpers;

import br.com.segnum.api.domain.Event;
import br.com.segnum.api.domain.EventType;
import br.com.segnum.api.domain.User;
import br.com.segnum.api.domain.Location;
import br.com.segnum.api.domain.enums.Profile;
import br.com.segnum.api.repositories.EventRepository;
import br.com.segnum.api.repositories.EventTypeRepository;
import br.com.segnum.api.repositories.LocationRepository;
import br.com.segnum.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@Service
public class DBService {
	
	@Autowired
	private BCryptPasswordEncoder pe;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LocationRepository locationRepository;

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private EventTypeRepository eventTypeRepository;

	public void instantiateTestDatabase() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		User master = new User(0, "Master", "master@segnum.com.br", "41999999999", sdf.parse("30/09/2017 10:32"), pe.encode("123"));
		master.addPerfil(Profile.MASTER);

		Location location = new Location(0, "Casa da Mãe Joana", "-25.4568614", "-49.2505684", 2, master);
		master.getMyLocations().add(location);

		EventType et1 = new EventType(0, "Roubo ", "Roubo");
		EventType et2 = new EventType(0, "Furto ", "Furto");
		EventType et3 = new EventType(0, "Assassinato ", "Assassinato");

		Event event = new Event(0, "Evento Exemplo", "Descrição com descrição", null, master);
		Location eventLocation = new Location(0, "Casa de Eventos", "-24.4568614", "-48.2505684", event);
		event.setLocation(eventLocation);
//		et1.getEvents().add(event);
		master.getMyEvents().add(event);

		userRepository.saveAll(Arrays.asList(master));
		eventRepository.saveAll(Arrays.asList(event));
		locationRepository.saveAll(Arrays.asList(location));
//		eventTypeRepository.saveAll(Arrays.asList(et1, et2, et3));

	}

}
