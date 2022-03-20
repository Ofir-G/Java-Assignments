import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Type a Number");
        int num = scanner.nextInt(); //wanted number input

        MyThreadMath[] tasks = new MyThreadMath[num]; //create runnable tasks arr

        for (int i = 0; i < tasks.length; i++) {

            tasks[i] = new MyThreadMath(i + 1); //create tasks for each number
        }

        ExecutorService executorMathematician = Executors.newFixedThreadPool(5);// created thread pool of 5

        for (int j = 0; j < tasks.length; j++) {

            executorMathematician.execute(tasks[j]); //queue tasks in pool
        }
        executorMathematician.shutdown(); //shut down threads
        try {
            executorMathematician.awaitTermination(6, TimeUnit.SECONDS); //wait for all threads to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("the number with the most divisors is: " + MyThreadMath.getNumMax() + ", with number of divisors: " + MyThreadMath.getMax());

    }

}
