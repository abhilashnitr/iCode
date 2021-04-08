package main.FAANG.DesignPatterns.structural.decorator.ex2;

public class SLACKNotification  extends NotificationDecorator{
    public SLACKNotification(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(){
        super.send();
        System.out.println("SLACK Notification sent");
    }
}
