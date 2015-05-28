package models;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

import play.db.ebean.Model;

@Entity
public class Client extends Model {

    @Id
    public Long codCliente;

    public String nome;
    public String cpf;
    public String cnpj;
    public String endereco;
    public String cartaoCredito;

    public static Finder<Long, Client> find = new Finder<Long, Client>(
            Long.class, Client.class);
}
