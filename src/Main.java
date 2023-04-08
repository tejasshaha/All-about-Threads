public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main started");
        //Using Thread clas
        Thread thread1 = new Threading();
        thread1.start();
        //Using runnable interface
        Thread thread2 = new Thread(()->{
            for(int i=0;i<100;i++){
                System.out.println(i);
            }
        },"thread2");
        thread2.start();

        // Its always good to use runnable interface as we can implement multiple interfaces but not multiple inheritance

        // Stack multithreading
        Stack stack = new Stack(5);
        new Thread(() ->{
            int counter=0;
            while(++counter<10){
                try {
                    System.out.println("Pushed " + stack.push(10));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"Pusher").start();

        new Thread(()->{
            int counter=0;
            while(++counter<10){
                try {
                    System.out.println("Popped " + stack.pop());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"Popper").start();

        //Producer Consumer problem

        Producer_Consumer producer_consumer = new Producer_Consumer(5);
        new Thread(()->{
            int counter=0;
            while(++counter<=10){
                try {
                    System.out.println("Element is produced and added to the queue " + producer_consumer.produce(100));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                };
            }
        },"producer").start();

        new Thread(()->{
            int counter=0;
            while(++counter<=10){
                try {
                    System.out.println("Element is consumed from queue" + producer_consumer.consume());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"Consumer").start();

        Deadlock deadlock= new Deadlock();

        new Thread(()->{
            try {
                deadlock.method1();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"Method1").start();

        new Thread(()->{
            try {
                deadlock.method2();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"Method2").start();

        System.out.println("Main ended");
        Thread thread4 = new Thread(()->{
            System.out.println("Sample thread");
        },"Sample Thread");
        thread4.start();
        thread4.join();
    }


}
/*
If we declare variable as Volatile
Eg - private volatile String flag;

Then this flag belongs to main memory instead of local cache.
so thread will directly change this value in main memory instead of cache
to avoid different values.

 */


/*
Thread join

When we create thread, thread and main method both will be executed asynchronously.
What if we want thread to execute first then main thread so we write thread.join()

Eg-

    Thread thread4 = new Thread(()->{
            System.out.println("Sample thread");
        },"Sample Thread");
        thread4.start();
        thread4.join();

 */