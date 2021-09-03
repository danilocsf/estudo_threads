package br.com.alura.thread_simples.bathroom;

public class TaskPoo  implements Runnable {

    Bathroom bathroom;

    public TaskPoo(Bathroom bathroom) {
        this.bathroom = bathroom;
    }
    @Override
    public void run() {
        try {
            this.bathroom.poo();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
