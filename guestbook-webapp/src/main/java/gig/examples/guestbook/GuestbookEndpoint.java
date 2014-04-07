/*
 * Copyright (C) 2011-2014 Eiichiro Uchiumi. All Rights Reserved.
 */
package gig.examples.guestbook;

import java.util.List;

import org.eiichiro.bootleg.MediaType;
import org.eiichiro.bootleg.Verb;
import org.eiichiro.bootleg.annotation.Allows;
import org.eiichiro.bootleg.annotation.Body;
import org.eiichiro.bootleg.annotation.Endpoint;
import org.eiichiro.bootleg.annotation.Generates;
import org.eiichiro.jaguar.inject.Inject;
import org.eiichiro.jaguar.inject.Name;

@Endpoint
@Name("gig.examples.guestbook.GuestbookEndpoint")
public class GuestbookEndpoint {

	@Inject GuestbookService service;
	
	@Allows(Verb.POST)
	public void post(@Body Comment comment) {
		service.post(comment);
	}
	
	@Allows(Verb.GET)
	@Generates(MediaType.APPLICATION_JSON)
	public List<Comment> list() {
		return service.list();
	}
	
}
