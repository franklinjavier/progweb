package controllers;

import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;

import models.User;

public class Auth extends Security.Authenticator {

    @Override
    public String getUsername(Http.Context ctx) {
        return ctx.session().get("connected");
    }

    @Override
    public Result onUnauthorized(Http.Context ctx) {
        return redirect(routes.LoginController.signin());
    }

}
