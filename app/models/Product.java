package models;

import java.sql.Timestamp;
import javax.persistence.*;
import play.db.ebean.*;

@Entity
public class Product extends Model {

    @Id
    public Long codProd;

    public String nome;
    public Float precoCompra;
    public Float precoVenda;
    public Long qtdEstoque;

    @Version
    public Timestamp lastUpdate;

    public static Finder<Long, Product> find = new Finder<Long, Product>(
            Long.class, Product.class);
}
