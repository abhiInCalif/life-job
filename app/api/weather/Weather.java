package api.weather;

import play.libs.F;


/**
 * Created by yding on 7/17/15.
 */
public interface Weather {

  F.Promise<Integer> get(String location);

}
