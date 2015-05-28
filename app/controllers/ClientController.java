package controllers;

import static play.data.Form.form;
//import static play.libs.Json.toJson;

//import java.util.ArrayList;
import java.util.List;

import models.Client;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.client.*;

public class ClientController extends Controller {

    final static Form<Client> clientForm = form(Client.class);

	/**
	 * This method is used to get the index Page which I have set to
	 * client.scala.html
	 *
	 *
	 * @return Result This method returns client.scala.html
	 */
    public static Result index() {
        String currentSession = "list";
        return ok(client.render(null, null, currentSession));
    }

    /**
     * This method is used to save the client data to database
     *
     *
     * @return Result This method redirects to client.scala.html by
     *         calling index() method
     */
    public static Result save() {
        Client client = Form.form(Client.class).bindFromRequest().get();
        client.save();
        return redirect(routes.ClientController.index());
    }

    /**
	 * This method is used to get update form of client specified by codCliente.
	 *
	 * @param codCliente
	 *            This is the client codCliente
	 *
	 * @return Result This method redirects to update.scala.html
	 */
    public static Result edit(Long codCliente) {
        String currentSession = "edit";
        Form<Client> clientForm = form(Client.class).fill(
                Client.find.byId(codCliente));
        return ok(client.render(clientForm, codCliente, currentSession));
    }

    /**
	 * This method is used to save update form of client specified by codCliente.
	 *
	 * @param codCliente
	 *            This is the client codCliente
	 *
	 * @return Result This method redirects to clientList.scala.html
	 */
    public static Result update(Long codCliente) {
        String currentSession = "update";
		Form<Client> clientForm = form(Client.class).bindFromRequest();
		if (clientForm.hasErrors()) {
            return badRequest(client.render(clientForm, codCliente, currentSession));
		}
		clientForm.get().update(codCliente);

		return redirect(routes.ClientController.list());
	}

    /**
	 * This method is used to delete client specified by codCliente.
	 *
	 * @param codCliente
	 *            This is the client codCliente
	 *
	 * @return Result This method redirects to clientList.scala.html
	 */
	public static Result delete(Long codCliente) {
		Client.find.ref(codCliente).delete();
		return redirect(routes.ClientController.list());
	}

    /**
     * This method is used to show the client data from database
     *
     *
     * @return Result This method returns clientList.scala.html
     */
    public static Result list() {
        List<Client> clients = new Model.Finder<String, Client>(String.class, Client.class).all();
        Client client = (Client) new Model.Finder<Integer, Client>(Integer.class, Client.class).byId(2);
        return ok(clientList.render(clients));
    }

    /**
	 * This method is used to get update form of client specified by codCliente.
	 *
	 * @param codCliente
	 *            This is the client codCliente
	 *
	 * @return Result This method redirects to update.scala.html
	 */
    public static Result find(String nome) {

        if ( nome != null ) {
            List<Client> clients = new Model.Finder(String.class, Client.class)
                .where().like("nome", "%" + nome + "%").findList();

            return ok(clientList.render(clients));

        } else {

            return ok(clientFind.render());
        }
    }












    /*
    public static Result getPersons() {
        Person persons = (Person) new Model.Finder<Integer, Person>(Integer.class, Person.class).byId(107);

        System.out.println(toJson(persons));

        List<Person> list = new ArrayList<Person>();
        list.add(persons);
        return ok(toJson(list));
    }

    public static Result getUsers() {
        List<Person> persons = new Model.Finder<String, Person>(String.class, Person.class).all();
        Person person = (Person) new Model.Finder<Integer, Person>(Integer.class, Person.class).byId(107);
        return ok(user.render(person, persons));
    }

    public static Result getJson() {

        List<Person> persons = new Model.Finder<String, Person>(String.class, Person.class).all();

        return ok(toJson(persons));
    }

    public static Result list() {
        List<Client> clients = new Model.Finder<String, Client>(String.class, Client.class).all();
        return ok(toJson(clients));
    }
    */
}
