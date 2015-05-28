package controllers;

import static play.data.Form.form;

import java.util.List;

import models.Product;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.product.*;

public class ProductController extends Controller {

    final static Form<Product> productForm = form(Product.class);

	/**
	 * This method is used to get the index Page which I have set to
	 * product.scala.html
	 *
	 *
	 * @return Result This method returns product.scala.html
	 */
    public static Result index() {
        String currentSession = "list";
        return ok(product.render(null, null, currentSession));
    }

    /**
     * This method is used to save the product data to database
     *
     *
     * @return Result This method redirects to product.scala.html by
     *         calling index() method
     */
    public static Result save() {
        Product product = Form.form(Product.class).bindFromRequest().get();
        product.save();
        return redirect(routes.ProductController.index());
    }

    /**
	 * This method is used to get update form of product specified by codProd.
	 *
	 * @param codProd
	 *            This is the product codProd
	 *
	 * @return Result This method redirects to update.scala.html
	 */
    public static Result edit(Long codProd) {
        String currentSession = "edit";
        Form<Product> productForm = form(Product.class).fill(
                Product.find.byId(codProd));
        return ok(product.render(productForm, codProd, currentSession));
    }

    /**
	 * This method is used to save update form of product specified by codProd.
	 *
	 * @param codProd
	 *            This is the product codProd
	 *
	 * @return Result This method redirects to productList.scala.html
	 */
    public static Result update(Long codProd) {
        String currentSession = "update";
		Form<Product> productForm = form(Product.class).bindFromRequest();
		if (productForm.hasErrors()) {
            return badRequest(product.render(productForm, codProd, currentSession));
		}
		productForm.get().update(codProd);

		return redirect(routes.ProductController.list());
	}

    /**
	 * This method is used to delete product specified by codProd.
	 *
	 * @param codProd
	 *            This is the product codProd
	 *
	 * @return Result This method redirects to productList.scala.html
	 */
	public static Result delete(Long codProd) {
		Product.find.ref(codProd).delete();
		return redirect(routes.ProductController.list());
	}

    /**
     * This method is used to show the product data from database
     *
     *
     * @return Result This method returns productList.scala.html
     */
    public static Result list() {
        List<Product> products = new Model.Finder<String, Product>(String.class, Product.class).all();
        Product product = (Product) new Model.Finder<Integer, Product>(Integer.class, Product.class).byId(2);
        return ok(productList.render(products));
    }

    /**
	 * This method is used to get update form of product specified by codProd.
	 *
	 * @param codProd
	 *            This is the product codProd
	 *
	 * @return Result This method redirects to update.scala.html
	 */
    public static Result find(String nome) {

        if ( nome != null ) {
            List<Product> products = new Model.Finder(String.class, Product.class)
                .where().like("nome", "%" + nome + "%").findList();

            return ok(productList.render(products));

        } else {

            return ok(productFind.render());
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
        List<Product> products = new Model.Finder<String, Product>(String.class, Product.class).all();
        return ok(toJson(products));
    }
    */
}
