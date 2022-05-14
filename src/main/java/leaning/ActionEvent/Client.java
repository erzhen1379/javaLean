package leaning.ActionEvent;

public class Client {
    public static void main(String[] args) {
        EventSource eventSource=new EventSource();
        EventListenerHandler addEventListenerHandler=new AddEventListenerHandler();
        eventSource.registryEventListenerHandler(addEventListenerHandler);
        //eventSource.removeEventListenerHandler(addEventListenerHandler);
        eventSource.addCar();
        eventSource.addCar();
        eventSource.addCar();
    }
}