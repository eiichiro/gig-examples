/*
 * Copyright (C) 2011-2014 Eiichiro Uchiumi. All Rights Reserved.
 */
package gig.examples.guestbook;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.eiichiro.gig.Repository;
import org.eiichiro.jaguar.inject.Inject;
import org.eiichiro.jaguar.inject.Name;

@Repository
@Name("gig.examples.guestbook.GuestbookRepository")
public class GuestbookRepository {

	@Inject EntityManager manager;
	
	public void post(Comment comment) {
		manager.persist(comment);
	}
	
	public List<Comment> list(int limit) {
		TypedQuery<Comment> query = manager.createQuery(
				"SELECT c FROM Comment c ORDER BY c.date DESC", 
				Comment.class);
		return query.setMaxResults(limit).getResultList();
	}
	
}
