package gig.examples.guestbook;

import static org.eiichiro.bootleg.MediaType.*;
import static org.eiichiro.bootleg.Verb.*;

import org.eiichiro.jaguar.inject.Inject;
import org.eiichiro.jaguar.inject.Name;
import org.eiichiro.bootleg.annotation.Allows;
import org.eiichiro.bootleg.annotation.Endpoint;
import org.eiichiro.bootleg.annotation.Generates;

@Name("gig.examples.guestbook.WelcomeEndpoint")
@Endpoint
public class WelcomeEndpoint {

	@Inject private WelcomeService service;
	
	@Allows(GET)
	@Generates(APPLICATION_JSON)
	public Welcome get() {
		return service.get();
	}
	
}
