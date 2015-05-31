package models;

import java.sql.Timestamp;
import javax.persistence.*;
import play.db.ebean.*;

@Entity
public class User extends Model {

    @Id
    public Integer id;
    public String username;
    public String authToken;

    public static Finder<Integer,User> find = new Finder(Integer.class, User.class);
}
