package main.FAANG.DesignPatterns.structural.decorator.ex2;

public class SMSNotification extends NotificationDecorator{
    public SMSNotification(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(){
        super.send();
        System.out.println("SMS Notification sent");
    }
}
