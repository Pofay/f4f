package giancarlogilos.com.f4f;

import java.util.List;

/**
 * Created by Gilos on 2/28/2017.
 */

public class Event {
    private List<EventListener> listeners;

    public void addListener(EventListener listener) {
        listeners.add(listener);
    }

    public void dispatch() {
        for (EventListener l : listeners) {
            l.onDispatch();
        }
    }
}
