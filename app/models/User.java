package models;

import java.sql.Timestamp;
import play.data.format.Formats;
import play.data.validation.Constraints;
import javax.persistence.*;
import play.db.ebean.*;

@Entity
public class User extends Model {

    @Id
    public Integer id;

    @Constraints.Required
    @Formats.NonEmpty
    public String username;

    @Constraints.Required
    @Formats.NonEmpty
    public String password;

    public static Finder<Integer,User> find = new Finder(Integer.class, User.class);
}
