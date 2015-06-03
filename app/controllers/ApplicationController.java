package controllers;

import play.*;
import play.mvc.*;
import views.html.*;

@Security.Authenticated(Auth.class)
public class ApplicationController extends Controller {

    public static Result index() {
        return ok(index.render());
    }

}
