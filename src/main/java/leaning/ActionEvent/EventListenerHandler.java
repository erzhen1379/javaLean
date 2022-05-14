package leaning.ActionEvent;

import java.util.EventListener;

/**
 * event listener handler interface must extends EventListener
 */
public interface EventListenerHandler extends EventListener {
    void handler(EventInfo eventInfo);
}