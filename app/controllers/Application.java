package controllers;

import api.restaurant.RestaurantApi;
import api.weather.WeatherApi;
import com.ybrikman.ping.javaapi.bigpipe.BigPipe;
import com.ybrikman.ping.javaapi.bigpipe.HtmlPagelet;
import com.ybrikman.ping.javaapi.bigpipe.HtmlStreamHelper;
import com.ybrikman.ping.javaapi.bigpipe.Pagelet;
import com.ybrikman.ping.javaapi.bigpipe.PageletRenderOptions;
import javax.inject.Inject;
import play.libs.F;
import play.mvc.*;

import play.twirl.api.Html;
import views.html.restaurant;
import views.html.weather;
import views.stream.test;


public class Application extends Controller {

  private final RestaurantApi _restaurantApi;

  private final WeatherApi _weatherApi;

  @Inject
  public Application(RestaurantApi restaurantApi, WeatherApi weatherApi) {
    _restaurantApi = restaurantApi;
    _weatherApi = weatherApi;
  }

  public Result index() {

    F.Promise<Html> restaurantPromise = _restaurantApi.get("").map(restaurant::apply);
    F.Promise<Html> weatherPromise = _weatherApi.get("").map(weather::apply);

    Pagelet restaurantPagelet = new HtmlPagelet("restaurant", restaurantPromise);
    Pagelet weatherPagelet = new HtmlPagelet("weather", weatherPromise);

    BigPipe bigPipe = new BigPipe(PageletRenderOptions.ClientSide, restaurantPagelet, weatherPagelet);

    return ok(HtmlStreamHelper.toChunks(test.apply(bigPipe, restaurantPagelet, weatherPagelet)));
  }
}
