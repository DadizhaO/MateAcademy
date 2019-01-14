package HM08.Sync;

public class ThreadedGet extends Thread{

    SenderMessage senderMessage;

    ThreadedGet(SenderMessage senderMessage)
    {
        this.senderMessage = senderMessage;
    }

    public void run(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        senderMessage.getMsg();
    }
}
