public class MyThreadMath implements Runnable {

    private int num;
    private static int max;
    private static int numMax;

    public MyThreadMath(int num) {
        this.num = num;
    }

    public static int getMax() {
        return max;
    }

    public static void setMax(int max) {
        MyThreadMath.max = max;
    }

    public static int getNumMax() {
        return numMax;
    }

    public static void setNumMax(int numMax) {
        MyThreadMath.numMax = numMax;
    }

    public synchronized void maxNum(int current_count, int num) {
        if (current_count > max) {
            max = current_count;
            numMax = num;
        }
    }

    @Override
    public void run() {
        int count = 0;

        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++; //count number of divisors
            }
        }
        this.maxNum(count, num); //save max
        System.out.println("The number of divisors for number " + num + " is: " + count);

    }

}
