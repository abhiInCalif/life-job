package api.restaurant;

import play.libs.F;


/**
 * Created by yding on 7/17/15.
 */
public class RestaurantApiDummy implements RestaurantApi {
  @Override
  public F.Promise<Integer> get(String location) {
    return F.Promise.pure(1);
  }
}
