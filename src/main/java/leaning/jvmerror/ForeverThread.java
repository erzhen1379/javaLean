package leaning.jvmerror;

/**
 * java.lang.OutOfMemoryError: unable to create new native thread
 */
public class ForeverThread extends Thread {
    @Override
    public void run() {
        while (true){
            try {
               // Thread.sleep(10*60*1000);
                String name = Thread.currentThread().getName();
                System.out.println(name);
            }catch (Exception e){

            }
        }
    }
}
