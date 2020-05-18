package MultiThreadingUtils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueIml {

  public static void main(String[] args)
      throws InterruptedException
  {

    // create object of DelayQueue
    // using DelayQueue() constructor
    BlockingQueue<DelayObject> DQ
        = new DelayQueue<DelayObject>();

    // Add numbers to end of DelayQueue
    DQ.add(new DelayObject("A", 1));
    DQ.add(new DelayObject("B", 2));
    DQ.add(new DelayObject("C", 3));
    DQ.add(new DelayObject("D", 4));

    // print Dequee
    System.out.println("DelayQueue: "
        + DQ);

    // create object of DelayQueue
    // using DelayQueue(Collection c) constructor
    BlockingQueue<DelayObject> DQ2
        = new DelayQueue<DelayObject>(DQ);

    // print Dequee
    System.out.println("DelayQueue: "
        + DQ2);
  }



}

class DelayObject implements Delayed {
  private String name;
  private long time;

  // Contructor of DelayObject
  public DelayObject(String name, long delayTime)
  {
    this.name = name;
    this.time = System.currentTimeMillis()
        + delayTime;
  }

  // Implementing getDelay() method of Delayed
  @Override
  public long getDelay(TimeUnit unit)
  {
    long diff = time - System.currentTimeMillis();
    return unit.convert(diff, TimeUnit.MILLISECONDS);
  }
  @Override
  public int compareTo(Delayed obj)
  {
    if (this.time < ((DelayObject)obj).time) {
      return -1;
    }
    if (this.time > ((DelayObject)obj).time) {
      return 1;
    }
    return 0;
  }

  // Implementing toString() method of Delayed
  @Override
  public String toString()
  {
    return "\n{"
        + "name=" + name
        + ", time=" + time
        + "}";
  }

}
