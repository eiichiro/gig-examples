/*
 * Copyright (C) 2011-2014 Eiichiro Uchiumi. All Rights Reserved.
 */
package gig.examples.guestbook;

import java.util.List;

import org.eiichiro.acidhouse.Session;
import org.eiichiro.acidhouse.metamodel.Metamodels;
import org.eiichiro.gig.Repository;
import org.eiichiro.jaguar.inject.Inject;
import org.eiichiro.jaguar.inject.Name;

@Repository
@Name("gig.examples.guestbook.GuestbookRepository")
public class GuestbookRepository {

	@Inject Session session;
	
	public void post(Comment comment) {
		session.put(comment);
	}
	
	public List<Comment> list(int limit) {
		_Comment _Comment = Metamodels.metamodel(Comment.class);
		return session.get(_Comment).sort(_Comment.date.desc).limit(limit).execute();
	}
	
}
