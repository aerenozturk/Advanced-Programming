package JavaApplication1.code;

import java.util.BitSet;

public class program {
    public static void main(String[] args){
        Thread[] thread = new Thread[5];
        synchoronizedCounter3 c= new synchoronizedCounter3();
        for (int i = 0; i < thread.length; i++) {
            thread[i]=new Thread(() -> {
                for(int k=0; k<100000;k++) {
                    c.increment();
                }
            });
            thread[i].start();
            }
        BitSet allAlive = new BitSet(thread.length);
        allAlive.set(0,thread.length,true);
        while(allAlive.cardinality()>0) {
            for(int i=0; i<thread.length;i++)
            if(!thread[i].isAlive())
            allAlive.set(i,false);

        } 
        System.out.println("Value: "+ c.value());  
    }
}
