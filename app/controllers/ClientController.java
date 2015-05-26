package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Client;

import static play.libs.Json.toJson;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class ClientController extends Controller {

    public static Result index() {
        return ok(client.render());
    }

    public static Result save() {
        Client client = Form.form(Client.class).bindFromRequest().get();
        client.save();
        return redirect(routes.ClientController.index());
    }

    public static Result edit(int codCliente) {
        Client clients = (Client) new Model.Finder<Integer, Client>(Integer.class, Client.class).byId(codCliente);
        List<Client> list = new ArrayList<Client>();
        list.add(clients);
        return ok(toJson(list));
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
    */

    public static Result list() {
        List<Client> clients = new Model.Finder<String, Client>(String.class, Client.class).all();
        Client client = (Client) new Model.Finder<Integer, Client>(Integer.class, Client.class).byId(2);
        return ok(clientList.render(client, clients));
    }

    //public static Result list() {
        //List<Client> clients = new Model.Finder<String, Client>(String.class, Client.class).all();
        //return ok(toJson(clients));
    //}
}
