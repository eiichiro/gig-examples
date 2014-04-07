/*
 * Copyright (C) 2011-2014 Eiichiro Uchiumi. All Rights Reserved.
 */
package gig.examples.guestbook;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Comment {

	@Id
	String id;
	
	String text;
	
	@Temporal(TemporalType.TIMESTAMP)
	Date date;
	
}
