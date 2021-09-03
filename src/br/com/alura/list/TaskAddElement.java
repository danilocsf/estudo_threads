package br.com.alura.list;

public class TaskAddElement implements Runnable {

    CustomList list;
    int threadNumber = 0;
    public TaskAddElement(CustomList list, int threadNumber) {
        this.list = list;
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            list.addElement("Thread " + threadNumber + " - " + i);
        }

    }
}
