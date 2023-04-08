public class Threading extends Thread{

//    public Threading(Thread thread){
//        super(thread);
//    }

    @Override
    public void run(){
        for(int i=11;i<=20;i++){
            System.out.println("ThreadName" + " " + i);
        }
    }
}
