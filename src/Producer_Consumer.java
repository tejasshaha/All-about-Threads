import java.util.LinkedList;
import java.util.Queue;

public class Producer_Consumer {
    int capacity;
     Queue<Integer> q;

     public Producer_Consumer(int capacity){
         q=new LinkedList<>();
         this.capacity=capacity;
     }

     public synchronized boolean produce(int element) throws InterruptedException {
         while(q.size()>=capacity){
             //do something
             this.wait(); // Waiting till element is consumed from queue
         }

         q.add(element);
         this.notifyAll(); // Notifies to consume element
         return true;
     }

     public synchronized int consume() throws InterruptedException {
         while(q.size()==0){
             //do something
             this.wait(); // Waiting for element to be added in queue
         }

         int element = q.poll();
         this.notifyAll(); // Notifies all the threads that you can add element now
         return element;
     }
}

