package br.com.alura.thread_simples.list;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        CustomList list = new CustomList();
        for (int i = 0; i < 100; i++) {
            new Thread(new TaskAddElement(list, i)).start();
        }
        new Thread(new TaskPrint(list)).start();
    }

}