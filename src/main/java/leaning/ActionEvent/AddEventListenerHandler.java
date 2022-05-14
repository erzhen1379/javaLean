package leaning.ActionEvent;

/**
 * 添加事件监听器，实现监听器接口类
 */
public class AddEventListenerHandler implements EventListenerHandler {

    public void handler(EventInfo eventInfo) {
        if(eventInfo==null){
            return;
        }
        if(eventInfo.getEventType().equals("add")){
            System.out.println("添加购物车事件。。。");
        }

        EventSource eventSource=(EventSource)eventInfo.getEventSource();
        int productCount=eventSource.getCount();
        System.out.println("购物车中现在有商品：" + productCount + "件");
    }
}