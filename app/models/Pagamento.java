package models;

import java.sql.Timestamp;
import javax.persistence.*;
import play.db.ebean.*;

@Entity
public class Pagamento extends Model {

    @Id
    public Long codPagamento;

    public float valorTotal;

    @Version
    public Timestamp lastUpdate;

    public static Finder<Long, Pedido> find = new Finder<Long, Pedido>(
            Long.class, Pedido.class);
}
