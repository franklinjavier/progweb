package controllers;

import static play.data.Form.form;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.*;
import play.data.*;
import views.html.*;

public class LoginController extends Controller {

    public static Result signin() {
        return ok(signin.render(form(Login.class)));
    }

    public static Result signup() {
        return ok(signup.render());
    }

    public static Result logout() {
        session().remove("connected");
        return redirect(routes.LoginController.signin());
    }

    public static Result authenticate() {
        Form<Login> loginForm = form(Login.class).bindFromRequest();
        if (loginForm.hasErrors()) {
            return badRequest(signin.render(loginForm));
        } else {
            session().clear();
            session("connected", loginForm.get().email);
            return redirect(routes.ApplicationController.index());
        }
    }

    public static class Login {
        public String email;
        public String password;
    }
}
