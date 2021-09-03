package br.com.alura.bathroom;

public class Bathroom {

    private boolean isDirty = true;

    public void pee() throws InterruptedException {
        knockOnDoor();
        usingBathroom("pee", 5000);
    }

    public void poo() throws InterruptedException {
        knockOnDoor();
        usingBathroom("poo", 15000);
    }
     private void knockOnDoor(){
         System.out.println(Thread.currentThread().getName()+" knocking on the door... ");
     }

    private synchronized void usingBathroom(String whatAreYouDoing, long time) throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+" checking whether the bathroom is clean... ");
        while(isDirty){
            System.out.println(Thread.currentThread().getName()+" waiting to clean the bathroom... ");
            this.wait();
        }
        System.out.println(Thread.currentThread().getName()+" entering into the bathroom... ");
        System.out.println(Thread.currentThread().getName()+" doing "+whatAreYouDoing+"...");
        Thread.sleep(time);
        System.out.println(Thread.currentThread().getName()+" flushing... ");
        System.out.println(Thread.currentThread().getName()+" washing hands... ");
        System.out.println(Thread.currentThread().getName()+" leaving...");
        isDirty = true;
    }

    public synchronized void clean() {
        knockOnDoor();
        if(!isDirty){
            System.out.println("Not dirty.. leaving ...");
            return;
        }
        System.out.println(Thread.currentThread().getName()+" cleaning... ");
        System.out.println(Thread.currentThread().getName()+" leaving...");
        isDirty = false;
        this.notifyAll();
    }
}
