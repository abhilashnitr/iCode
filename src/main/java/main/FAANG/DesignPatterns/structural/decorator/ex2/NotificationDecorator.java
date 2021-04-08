package main.FAANG.DesignPatterns.structural.decorator.ex2;

abstract class NotificationDecorator implements Notifier{
    private Notifier notifier;

    public NotificationDecorator(Notifier notifier) {
        this.notifier=notifier;
    }

    @Override
    public void send() {
        notifier.send();
    }
}
