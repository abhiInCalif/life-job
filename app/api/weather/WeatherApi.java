package api.weather;

import play.libs.F;


/**
 * Created by yding on 7/17/15.
 */
public interface WeatherApi {

  F.Promise<Integer> get(String location);

}
