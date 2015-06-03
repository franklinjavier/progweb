package models;

import java.util.Date;

import java.sql.Timestamp;
import javax.persistence.*;
import play.db.ebean.*;

@Entity
public class CartaoCredito extends Model {

    @Id
    public Long codPedido;

    public String numero;
    public String tipo;
    public Date dataExp;

    @Version
    public Timestamp lastUpdate;

    public static Finder<Long, Pedido> find = new Finder<Long, Pedido>(
            Long.class, Pedido.class);
}
