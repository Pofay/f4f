package utils;

/**
 * Created by Gilos on 2/23/2017.
 */

public interface Maybe<T> {

    boolean hasValue();

    T Value();
}
