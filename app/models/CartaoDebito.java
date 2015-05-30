package models;

import java.sql.Timestamp;
import javax.persistence.*;
import play.db.ebean.*;

@Entity
public class CartaoDebito extends Model {

    @Id
    public Long codPedido;

    public String numero;

    @Version
    public Timestamp lastUpdate;

    public static Finder<Long, Pedido> find = new Finder<Long, Pedido>(
            Long.class, Pedido.class);
}
