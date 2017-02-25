package utils;

/**
 * Created by Gilos on 2/23/2017.
 */

@FunctionalInterface
public interface GenericAction<T>{

    void execute(T message);
}
