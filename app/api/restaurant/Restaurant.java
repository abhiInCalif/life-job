package api.restaurant;

import play.libs.F;
import play.mvc.Controller;
import play.mvc.Result;


/**
 * Created by yding on 7/17/15.
 */
public interface Restaurant {

  F.Promise<Integer> get(final String location);

}
