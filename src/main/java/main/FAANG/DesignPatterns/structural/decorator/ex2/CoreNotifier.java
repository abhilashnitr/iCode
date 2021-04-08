package main.FAANG.DesignPatterns.structural.decorator.ex2;


public class CoreNotifier implements Notifier{

    String name;

    public CoreNotifier(String name) {
        this.name = name;
    }

    @Override
    public void send() {
        System.out.println("Notification Process initiated for"+this.name);
    }
}
