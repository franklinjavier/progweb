package models;

import play.db.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person extends Model {

    private static final long serialVersionUID = 1L;

    @Id
	public int id;

	public String name;

}

