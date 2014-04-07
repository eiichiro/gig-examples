/*
 * Copyright (C) 2011-2014 Eiichiro Uchiumi. All Rights Reserved.
 */
package gig.examples.guestbook;

import java.util.Date;

import org.eiichiro.acidhouse.Entity;
import org.eiichiro.acidhouse.Key;

@Entity
public class Comment {

	@Key
	String id;
	
	String text;
	
	Date date;
	
}
