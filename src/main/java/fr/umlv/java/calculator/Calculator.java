package fr.umlv.java.calculator;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;

/**
 *
 * @author Besnard Arthur
 */
public class Calculator extends AbstractVerticle {

    @Override
    public void start() {
        Router router = Router.router(vertx);

        router.get("/add/:a/:b/").handler(rc -> {
            double a = Double.valueOf(rc.request().getParam("a"));
            double b = Double.valueOf(rc.request().getParam("b"));
            rc.response()
                    .putHeader("content-type", "application/json")
                    .end(new JsonObject().put("result", "" + (a + b)).encode());
        });
        
        router.get("/multiply/:a/:b/").handler(rc -> {
            double a = Double.valueOf(rc.request().getParam("a"));
            double b = Double.valueOf(rc.request().getParam("b"));
            rc.response()
                    .putHeader("content-type", "application/json")
                    .end(new JsonObject().put("result", "" + (a * b)).encode());
        });
        
        router.get("/square/:a/:b/").handler(rc -> {
            double a = Double.valueOf(rc.request().getParam("a"));
            double b = Double.valueOf(rc.request().getParam("b"));
            rc.response()
                    .putHeader("content-type", "application/json")
                    .end(new JsonObject().put("pow", "" + Math.pow(a, b)).encode());
        });

        vertx.createHttpServer().requestHandler(router::accept).listen(8080);
    }
}
