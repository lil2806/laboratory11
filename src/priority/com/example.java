package priority.com;

public class example implements Runnable {

    int count;
    Thread thread;
    static boolean stop=false;
    static String currentName;
    example (String name){
        thread = new Thread(this,name);
        count=0;
        currentName=name;

    }
    public void run(){
        System.out.println(thread.getName()+"starts running");
        do{
            count++;
            if (currentName.compareTo(thread.getName())!=0){
                currentName=thread.getName();
                System.out.println(currentName+" executed");
            }

        }while(stop==false && count<15_000_000);
        stop=true;
        System.out.println("\n"+ thread.getName()+"finished running");
    }
}
class PriorityDemo{
    public static void main(String[] args){
        example mt1 = new example("High priority thread");
        example mt2 = new example("Thread with low priority");
        example mt3 = new example("Thread #1 with normal priority");
        example mt4 = new example("Thread #2 with normal priority");
        example mt5 = new example("Thread #3 with normal priority");
        //
        mt1.thread.setPriority(Thread.NORM_PRIORITY -4);
        mt2.thread.setPriority(Thread.NORM_PRIORITY +5);
        //
        mt1.thread.start();mt2.thread.start();mt3.thread.start();mt4.thread.start();mt5.thread.start();
        try {

            mt2.thread.join();
            mt3.thread.join();
            mt4.thread.join();
            mt5.thread.join();
            mt1.thread.join();
        } catch (InterruptedException e)
        {System.out.println("The main thread starts running");}
        System.out.println("\n High priority thread counted to "+mt1.count);
        System.out.println("\n The low priority thread counted to "+mt2.count);
        System.out.println("\n #1 Normal Priority thread counted to "+mt3.count);
        System.out.println("\n #2 Normal Priority thread counted to "+mt4.count);
        System.out.println("\n #3 Normal Priority thread counted to "+mt5.count);
    }

}
