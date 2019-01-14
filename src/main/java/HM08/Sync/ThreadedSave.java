package HM08.Sync;


public class ThreadedSave extends Thread {

    SenderMessage senderMessage;
    private String msg;

    ThreadedSave(SenderMessage senderMessage, String msg) {
        this.senderMessage = senderMessage;
        this.msg = msg;
    }

    public void run() {
        senderMessage.sendTo(msg);
    }

}
