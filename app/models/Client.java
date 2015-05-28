package models;

import java.sql.Timestamp;
import javax.persistence.*;
import play.db.ebean.*;

@Entity
public class Client extends Model {

    @Id
    public Long codCliente;

    public String nome;
    public String cpf;
    public String cnpj;
    public String endereco;
    public String cartaoCredito;

    @Version
    public Timestamp lastUpdate;

    public static Finder<Long, Client> find = new Finder<Long, Client>(
            Long.class, Client.class);
}
