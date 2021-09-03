package br.com.alura.list;

public class TaskPrint implements Runnable {
    CustomList list;
    public TaskPrint(CustomList list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list){
            if(!list.isFull()){
                System.out.println("Aguardando o preenchimento da lista...");
                // o wait deve ficar dentro de um bloco synchronized
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for(int i = 0; i < list.length(); i++){
                System.out.println(list.getElement(i));
            }
        }

    }
}
