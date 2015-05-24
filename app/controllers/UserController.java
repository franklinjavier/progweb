package controllers;

import static play.libs.Json.toJson;

import java.util.ArrayList;
import java.util.List;

import models.Person;

import play.data.Form;
import play.db.ebean.Model;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class UserController extends Controller {

    public static Result index() {
        return ok(index.render());
    }

    public static Result addPerson() {
        Person person = Form.form(Person.class).bindFromRequest().get();
        person.save();
        return redirect(routes.ApplicationController.index());
    }

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

}
