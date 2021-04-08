package main.FAANG.DesignPatterns.structural.decorator.ex2;

public class EmailNotification extends NotificationDecorator{
    public EmailNotification(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(){
        super.send();
        System.out.println("EMAIL Notification sent");
    }
}
