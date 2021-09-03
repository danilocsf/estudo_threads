package br.com.alura.thread_simples.bathroom;

public class TaskPee implements Runnable{

    Bathroom bathroom;

    public TaskPee(Bathroom bathroom) {
        this.bathroom = bathroom;
    }
    @Override
    public void run() {
        try {
            this.bathroom.pee();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
