package gig.examples.guestbook;

import javax.annotation.Generated;
import org.eiichiro.acidhouse.metamodel.Metamodel;

@Generated("org.eiichiro.acidhouse.metamodel.processing.MetamodelGenerator")
public class _Comment extends Metamodel<Comment> {

	public _Comment() {
		super(Comment.class);
	}

	public _Comment(Metamodel<?> parent, String name) {
		super(parent, Comment.class, name);
	}

	public org.eiichiro.acidhouse.metamodel.ComparableProperty<Comment, java.util.Date> date = new org.eiichiro.acidhouse.metamodel.ComparableProperty<Comment, java.util.Date>(this, java.util.Date.class, "date");

	public org.eiichiro.acidhouse.metamodel.ComparableProperty<Comment, java.lang.String> id = new org.eiichiro.acidhouse.metamodel.ComparableProperty<Comment, java.lang.String>(this, java.lang.String.class, "id");

	public org.eiichiro.acidhouse.metamodel.ComparableProperty<Comment, java.lang.String> text = new org.eiichiro.acidhouse.metamodel.ComparableProperty<Comment, java.lang.String>(this, java.lang.String.class, "text");

}
