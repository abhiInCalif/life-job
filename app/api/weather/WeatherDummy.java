package api.weather;

import play.libs.F;
import play.mvc.Result;


/**
 * Created by yding on 7/17/15.
 */
public class WeatherDummy implements Weather {
  @Override
  public F.Promise<Integer> get(String location) {
    return F.Promise.pure(2);
  }
}
