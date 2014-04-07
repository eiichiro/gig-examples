/*
 * Copyright (C) 2011-2014 Eiichiro Uchiumi. All Rights Reserved.
 */
package gig.examples.guestbook;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.eiichiro.gig.Configuration;
import org.eiichiro.gig.Transactional;
import org.eiichiro.jaguar.inject.Inject;
import org.eiichiro.jaguar.inject.Name;

@Name("gig.examples.guestbook.GuestbookService")
public class GuestbookService {

	@Inject GuestbookRepository repository;
	
	@Inject Configuration configuration;
	
	@Transactional
	public void post(Comment comment) {
		if (comment.text == null || comment.text.isEmpty()) {
			throw new IllegalArgumentException("Comment message must not be empty");
		}
		
		if (comment.text.length() > 200) {
			throw new IllegalArgumentException("Comment message must be within 200 characters");
		}
		
		comment.id = UUID.randomUUID().toString();
		comment.date = new Date();
		repository.post(comment);
	}

	public List<Comment> list() {
//		int limit = 20;
		int limit = configuration.get("limit");
		return repository.list(limit);
	}
	
}
