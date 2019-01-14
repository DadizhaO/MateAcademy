package HM08.Sync;

public class ThreadedSend extends Thread {
    private String msg;
    SenderMessage senderMessage;

    ThreadedSend(String m, SenderMessage senderMessage) {
        msg = m;
       this.senderMessage = senderMessage;
    }

    public void run() {

        senderMessage.send(msg);
    }
}
