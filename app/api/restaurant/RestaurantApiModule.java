package api.restaurant;

import play.api.Configuration;
import play.api.Environment;
import play.api.inject.Binding;
import play.api.inject.Module;
import scala.collection.Seq;


/**
 * Created by yding on 7/17/15.
 */
public class RestaurantApiModule extends Module {
  @Override
  public Seq<Binding<?>> bindings(Environment environment, Configuration configuration) {
    return seq(bind(RestaurantApi.class).to(RestaurantApiDummy.class));
  }
}
