package utils;

/**
 * Created by Gilos on 2/23/2017.
 */

public class Some<T> implements Maybe<T> {

    private final T t;

    public Some(T value) {
        this.t = value;
    }

    @Override
    public boolean hasValue() {
        return true;
    }

    @Override
    public T Value() {
        return t;
    }
}
