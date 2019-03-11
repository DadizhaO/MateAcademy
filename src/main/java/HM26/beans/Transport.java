package HM26.beans;

public abstract class Transport implements Moving {

    int speed;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public abstract void moveForward();
}
