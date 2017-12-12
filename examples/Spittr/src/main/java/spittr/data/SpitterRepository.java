package spittr.data;

import spittr.Spitter;

/**
 * Created by wusj on 2017/12/10.
 */
public interface SpitterRepository {

    Spitter save(Spitter spitter);
    Spitter findByUsername(String username);
}
