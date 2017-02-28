package core;

/**
 * Created by Gilos on 2/28/2017.
 */
public interface DataEventListener<T> {
    void onDispatch(T data);
}
