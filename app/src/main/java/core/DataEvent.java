package core;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gilos on 2/28/2017.
 */
public class DataEvent<T> {

    private final List<DataEventListener> listeners;

    public DataEvent(){
        listeners = new ArrayList<>();
    }

    public void addListener(DataEventListener listener) {
        listeners.add(listener);
    }

    public void dispatch(T data) {
        for (DataEventListener l : listeners) {
            l.onDispatch(data);
        }
    }
}
