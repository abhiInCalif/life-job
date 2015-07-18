package api.weather;

import play.libs.F;


/**
 * Created by yding on 7/17/15.
 */
public class WeatherApiDummy implements WeatherApi {
  @Override
  public F.Promise<Integer> get(String location) {
    return F.Promise.pure(2);
  }
}
