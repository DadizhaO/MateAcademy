package HM08.Sync;

public class SyncDemo {
    public static void main(String args[]) {
        SenderMessage snd = new SenderMessage();
        ThreadedSend th1 = new ThreadedSend(" Hello ", snd);
        ThreadedSend th2 = new ThreadedSend(" Good Bye ", snd);

        ThreadedSave thSave = new ThreadedSave(snd, "message1");
        ThreadedSave thSave2 = new ThreadedSave(snd, "message2");
        ThreadedSave thSave3 = new ThreadedSave(snd, "message3");
        ThreadedGet threadedGet  = new ThreadedGet(snd);
        ThreadedGet threadedGet2  = new ThreadedGet(snd);


        th1.start();
        th2.start();

        thSave.start();
        thSave2.start();
        thSave3.start();
        threadedGet.start();
        threadedGet2.start();

        }

}