package models;

import java.sql.Timestamp;
import javax.persistence.*;
import play.db.ebean.*;

@Entity
public class PedidoDetalhe extends Model {

    @Id
    public Long codPedido;

    public Long quantidade;
    public String taxStatus;

    @Version
    public Timestamp lastUpdate;

    public static Finder<Long, Pedido> find = new Finder<Long, Pedido>(
            Long.class, Pedido.class);
}
