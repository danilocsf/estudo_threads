package br.com.alura.thread_simples.list;

public class CustomList {
    private String[] elements = new String[1000];
    private int index = 0;

    public synchronized void addElement(String element) {
        doSomeLongProcess();
        this.elements[index] = element;
        this.index++;
        notifyIfListIsFull();
    }

    public boolean isFull(){
        return index == elements.length;
    }

    private void notifyIfListIsFull(){
        if(isFull()){
            System.out.println("Lista cheia ... notificando Thread para imprimir");
            this.notify();
        }
    }

    private void doSomeLongProcess(){
        try{
            Thread.sleep(10);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int length() {
        return this.elements.length;
    }

    public String getElement(int position) {
        return this.elements[position];
    }
}