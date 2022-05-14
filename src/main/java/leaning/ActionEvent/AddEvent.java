package leaning.ActionEvent;

import java.util.EventObject;

public class AddEvent extends EventObject implements EventInfo {

    private final String eventType = "add";

    public AddEvent(Object source) {
        super(source);
    }

    public String getEventType() {
        return eventType;
    }


    public Object getEventSource() {
        return getSource();
    }
}