package prediction;

public class Program {

    public static void main(String[] args) {
        Predictor[] predictors = new Predictor[10];
        Producer producer = new Producer(predictors.length);
        producer.start();
         try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
         }

         for(int i=0; i<predictors.length; i++) {
                predictors[i] = new Predictor(producer, predictors.length);
                predictors[i].start();
         }

    }
}