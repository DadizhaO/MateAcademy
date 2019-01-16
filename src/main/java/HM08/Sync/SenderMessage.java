package HM08.Sync;

import java.util.ArrayList;
import java.util.List;


public class SenderMessage {

    List list = new ArrayList();

    public synchronized void send(String msg) { //example of synchronized method
        System.out.println("Sending" + msg);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void sendTo(String msg) { //I know there is a synchronizedList it's for example
        synchronized (list) {       //For synchronized ArrayList need to use synchronized block.
            list.add(msg);
        }
    }

    public void getMsg() {
        synchronized (list) {
            String msg = null;
            while (!list.isEmpty()) {
                msg = (String) list.remove(0);
                System.out.println(msg);
            }
        }
    }


}
