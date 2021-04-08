package main.FAANG.DesignPatterns.structural.decorator.ex2;

public class Demo {
    public static void main(String[] args) {
        Notifier notifier=new SMSNotification(new SMSNotification(new EmailNotification(new SLACKNotification(new CoreNotifier("Abhilash"))))) ;

        notifier.send();
        }
    }
