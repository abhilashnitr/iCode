package main.FAANG.LLD.PubSubSystem;

public class Node {
    Message message;
    Node next;

    public Node(Message m){
        message = m;
        next=null;
    }
}
