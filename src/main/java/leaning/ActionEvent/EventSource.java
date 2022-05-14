package leaning.ActionEvent;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;


/**
 * 事件源：具体为购物辐操作事件源
 */
public class EventSource {
    private Collection<EventListenerHandler> eventListenerHandlers = null;
    private int count = 0;

    public int getCount() {
        return count;
    }

    public void registryEventListenerHandler(EventListenerHandler eventListenerHandler) {
        if (eventListenerHandlers == null) {
            eventListenerHandlers = new HashSet<EventListenerHandler>();
            eventListenerHandlers.add(eventListenerHandler);
        }
    }

    public void removeEventListenerHandler(EventListenerHandler eventListenerHandler) {
        if (eventListenerHandlers != null) {
            eventListenerHandlers.remove(eventListenerHandler);
        }
    }


    public void addCar() {
        ++count;
        if (eventListenerHandlers != null) {
            EventInfo eventInfo = new AddEvent(this);
            notifies(eventInfo);
        }
        System.out.println("向购物车添加商品成功...");
    }

    private void notifies(EventInfo eventInfo) {
        Iterator iterator = eventListenerHandlers.iterator();
        while (iterator.hasNext()) {
            ((EventListenerHandler) iterator.next()).handler(eventInfo);
        }
    }

}
