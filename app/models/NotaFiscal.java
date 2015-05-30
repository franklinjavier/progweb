package models;

import java.sql.Timestamp;
import javax.persistence.*;
import play.db.ebean.*;

@Entity
public class NotaFiscal extends Model {

    @Id
    public Long codNota;

    public Long numNota;
    public String desc;
    public float valorTotal;

    @Version
    public Timestamp lastUpdate;

    //public static Finder<Long, Client> find = new Finder<Long, Client>(
            //Long.class, Client.class);
}
