package core;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gilos on 2/28/2017.
 */

public class Event {
    private final List<EventListener> listeners;

    public Event(){
        listeners = new ArrayList<>();
    }

    public void addListener(EventListener listener) {
        listeners.add(listener);
    }

    public void dispatch() {
        for (EventListener l : listeners) {
            l.onDispatch();
        }
    }
}
