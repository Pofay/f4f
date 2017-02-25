package utils;

/**
 * Created by Gilos on 2/23/2017.
 */

public class None<T> implements Maybe<T> {

    @Override
    public boolean hasValue() {
        return false;
    }

    @Override
    public T Value() {
        throw new RuntimeException();
    }
}
