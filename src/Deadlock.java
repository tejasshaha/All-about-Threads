public class Deadlock {
    String lock1= "Tejas";
    String lock2= "Shah";

    public void method1() throws InterruptedException {
        synchronized (lock1){
            Thread.sleep(100);
            synchronized (lock2){
                System.out.println("Inside method1");
            }
        }
    }

    public void method2() throws InterruptedException {
        synchronized (lock2){
            Thread.sleep(100);
            synchronized (lock1){
                System.out.println("Inside method 2");
            }
        }
    }
}

/*
 Here lock1 is acquired by method1 and lock2 is acquired by method2 so both will
 wait to acquire opposite lock to enter in critical section and this will never happen.

 And program will never execute so it's a deadlock situation
 */
