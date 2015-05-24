package models;

import play.db.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client extends Model {

    private static final long serialVersionUID = 1L;

    @Id
    public int codCliente;

    public String nome;
    public String cpf;
    public String cnpj;
    public String endereco;
    public String cartaoCredito;

}
