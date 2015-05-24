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

    public static Result cadastrar() {
        Client client = Form.form(Client.class).bindFromRequest().get();
        client.save();
        return redirect(routes.ClientController.index());
    }

    public static Result list() {
        List<Client> clients = new Model.Finder<String, Client>(String.class, Client.class).all();
        return ok(toJson(clients));
    }
}
