public class Stack {
    private int[] array;
    private int stackTop;
    Stack(int capacity){
        array=new int[capacity];
        stackTop=-1;
    }

    public boolean isEmpty(){
        return stackTop<0;
    }

    public boolean isFull(){
        return stackTop>=array.length-1;
    }

    public synchronized boolean push(int element) throws InterruptedException {
        if(isFull()){
            return false;
        }
        ++stackTop;
        Thread.sleep(1000);

        array[stackTop]=element;
        return true;
    }

    public synchronized int pop() throws InterruptedException {
        if(isEmpty()){
            return Integer.MIN_VALUE;
        }
        Thread.sleep(1000);
        int element=array[stackTop];
        array[stackTop]=Integer.MIN_VALUE;
        stackTop--;
        return element;
    }
}


    /*
Thread safe - It is design of a class in such a way that objects will always remain in consistent state.
If we don't use synchronized keyword then lets say initially stackTop==-1 and in push method its value changed to 0
and thread went on sleep. Not pop method called from another thread and value of stackTop changed to -1.
Now when we trt to add element in push - array[stackTop]=array[-1] -> It will throw index out of bound exception

To avoid this we use synchronized keyword. It is basically locking mechanism so only 1 thread will be executed
at a time.

When method is non static lock is this.class i.e object of class
When method is static lock is class name i.e. Stack.class

     */