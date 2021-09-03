package br.com.alura.bathroom;

public class Main {

    public static void main(String[] args) {
        Bathroom bathroom = new Bathroom();
        Thread person1 = new Thread(new TaskPee(bathroom), "Danilo");
        Thread person2 = new Thread(new TaskPoo(bathroom), "Ze");
        Thread person3 = new Thread(new TaskPee(bathroom), "Pedro");
        Thread person4 = new Thread(new TaskPoo(bathroom), "JOAO");
        Thread person5 = new Thread(new TaskClean(bathroom), "Limpeza");
        person5.setDaemon(true);
        person1.start();
        person2.start();
        person3.start();
        person4.start();
        person5.start();
    }
}
