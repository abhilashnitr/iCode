package main.FAANG.LLD.PubSubSystem;

public interface Publisher {
    boolean addToMessageQueue(Message message);
}
