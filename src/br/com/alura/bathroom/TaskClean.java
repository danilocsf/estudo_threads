package br.com.alura.bathroom;

public class TaskClean implements Runnable{

    Bathroom bathroom;

    public TaskClean(Bathroom bathroom) {
        this.bathroom = bathroom;
    }
    @Override
    public void run() {
        while(true){
            this.bathroom.clean();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
