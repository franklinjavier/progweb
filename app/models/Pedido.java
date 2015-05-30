package models;

import java.sql.Timestamp;
import javax.persistence.*;
import play.db.ebean.*;

@Entity
public class Pedido extends Model {

    @Id
    public Long codPedido;

    public Timestamp data;
    public String status;
    public float valorTotal;

    @Version
    public Timestamp lastUpdate;

    public static Finder<Long, Pedido> find = new Finder<Long, Pedido>(
            Long.class, Pedido.class);
}
