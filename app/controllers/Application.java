package controllers;

import api.restaurant.Restaurant;
import api.weather.Weather;
import com.ybrikman.ping.javaapi.bigpipe.BigPipe;
import com.ybrikman.ping.javaapi.bigpipe.HtmlPagelet;
import com.ybrikman.ping.javaapi.bigpipe.HtmlStreamHelper;
import com.ybrikman.ping.javaapi.bigpipe.Pagelet;
import com.ybrikman.ping.javaapi.bigpipe.PageletRenderOptions;
import javax.inject.Inject;
import play.*;
import play.libs.F;
import play.mvc.*;

import play.twirl.api.Html;
import views.html.restaurant;
import views.html.weather;
import views.stream.test;


public class Application extends Controller {

  private final Restaurant _restaurant;

  private final Weather _weather;

  @Inject
  public Application(Restaurant restaurant, Weather weather) {
    _restaurant = restaurant;
    _weather = weather;
  }

  public Result index() {

    F.Promise<Html> restaurantPromise = _restaurant.get("").map(restaurant::apply);
    F.Promise<Html> weatherPromise = _weather.get("").map(weather::apply);

    Pagelet restaurantPagelet = new HtmlPagelet("restaurant", restaurantPromise);
    Pagelet weatherPagelet = new HtmlPagelet("weather", weatherPromise);

    BigPipe bigPipe = new BigPipe(PageletRenderOptions.ClientSide, restaurantPagelet, weatherPagelet);

    return ok(HtmlStreamHelper.toChunks(test.apply(bigPipe, restaurantPagelet, weatherPagelet)));
  }
}
