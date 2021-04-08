import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

class Test{

    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        long heapSize = Runtime.getRuntime().totalMemory();
        List<Integer> list = new ArrayList<>();
        System.out.println("Befpre heap current " + heapSize);
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
            hashMap.put(i, i);
        }
        System.out.println("hashMap current  size   " + hashMap.size());

        System.out.println(" Inside : " + Thread.currentThread().getName());
        System.out.println("creating ExecutorService");
        ExecutorService executorservice = Executors.newFixedThreadPool(10);
        System.out.println("creating a runnable");
        Runnable runnable = () -> {
            Test t=new Test();
            System.out.println("inside: "+ Thread.currentThread().getName());
            t.m1(hashMap);
        };
        System.out.println("submit the task specified by the runnable to the executorservice");
        for(int i=0;i<10;i++){
            executorservice.submit(runnable);

        }

        heapSize = Runtime.getRuntime().totalMemory();
        System.out.println("After heap current " + heapSize);
    }


     void m1(HashMap<Integer, Integer> hashMap) {
        //System.out.println("address reference is " + hashMap.hashCode());
        long heapSize = (Runtime.getRuntime().totalMemory());
        System.out.println("current " + heapSize);
        System.out.println(  "hash is" + hashMap);

    }

}