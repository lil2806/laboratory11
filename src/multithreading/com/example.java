package multithreading.com;

public class multithreading implements Runnable {

    Thread thread;
    multithreading(String name){
        thread=new Thread(target this, name);

    }

    public static multithreading createAndStart(String name){
        multithreading multithreading =new multithreading(name);
        multithreading.thread.start();
        return multithreading;
    }
    public void run(){


        System.out.println(thread.getName() + "starts to separate");
        try {

            for (int count = 0; count < 10; count++) {
                Thread.sleep(m:100);
                System.out.println(thread.getname() + "is executed,the counter value:" + count);

            }
        }catch (InterruptedException e){

            System.out.println(thread.getName() + "has been interrupted";


            }
        System.out.println(thread.getName() + "finishes running");

        }
    }
    class MoreThread2{
    public static void main (String[] args){
        System.out.println("The main thread starts running");
        multithreading multithreading= multithreading.createAndStart("child thread=1");
        multithreading multithreading1= multithreading.createAndStart("child thread=2");
        multithreading multithreading2= multithreading.createAndStart("child thread=3");

        System.out.print(".");
        try{

            thread1.thread.join();
            thread2.thread.join();
            thread3.thread.join();
        }
        catch (InterruptedException e) {
            System.out.println("The Threads thread has been terminated");
        }

        System.out.println("The thread is exiting");


    }

}
