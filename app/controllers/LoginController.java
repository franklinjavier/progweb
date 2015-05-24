package controllers;

//import models.User;
//import models.Person;
import play.*;
import play.mvc.*;

import views.html.*;

public class LoginController extends Controller {

    public static Result signin() {
        return ok(signin.render());
    }

    public static Result signup() {
        return ok(signup.render());
    }
}
