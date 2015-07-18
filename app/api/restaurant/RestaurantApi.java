package api.restaurant;

import play.libs.F;


/**
 * Created by yding on 7/17/15.
 */
public interface RestaurantApi {

  F.Promise<Integer> get(final String location);

}
