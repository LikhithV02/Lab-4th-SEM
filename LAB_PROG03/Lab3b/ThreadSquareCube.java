/**
 * Write a Java program that implements a multi-thread application
 * that has three threads. First thread generates a random integer for every 1 second;
 * second thread computes the square of the number and prints;
 * third thread will print the value of cube of the number.
 * <p>
 * Two Command line inputs i.e. args[0] and args[1]
 * param1 - count i.e. number of values to be generated
 * param2 - max value to be generated randomly
 */

/**
 * Two Command line inputs i.e. args[0] and args[1]
 * param1 - count i.e. number of values to be generated
 * param2 - max value to be generated randomly
 */
package thread;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadSquareCube {
  public static void main(String[] args) {
// insert code for validating command line args

    int count = // insert code here
    int maxval = // insert code here
    BlockingQueue<Integer> square = new LinkedBlockingQueue<>(count);
    BlockingQueue<Integer> cube = new LinkedBlockingQueue<>(count);
    Thread t1 = new Thread(new GeneratorThread(count, maxval, square, cube));
    Thread t2 = new Thread(new PowerThread(square, 2));
    Thread t3 = new Thread(new PowerThread(cube, 3));
    t2.setDaemon(true);
    t2.start();
    t3.setDaemon(true);
    t3.start();
    t1.start();
  }

  public static class PowerThread implements Runnable {
    private final BlockingQueue<Integer> queue;
    private final int expon;

    public PowerThread(BlockingQueue<Integer> queue, int expon) {
//insert code here
    }

    @Override
    public void run() {
      try {
        while (true) {
          int number = queue.take(); // this is blocking queue
          int term = 1;
// insert code here to compute the power
          System.out.format("%d**%d=%d%n", number, expon, term);
        }
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }

  public static class GeneratorThread implements Runnable {
    private final int count;
    private final int maxval;
    private final BlockingQueue<Integer> square;
    private final BlockingQueue<Integer> cube;
    private final Random random = new Random();

    public GeneratorThread(int count, int maxval,
                           BlockingQueue<Integer> square,
                           BlockingQueue<Integer> cube) {
//insert code here
    }

    @Override
    public void run() {
      try {
        for (int x = 0; x < count; x++) {
          Thread.sleep(1000);
          int rndval = random.nextInt(maxval);
          System.out.println("Generated:" + rndval);
          square.put(rndval);
          cube.put(rndval);
        }
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }//try catch
    }// run
  }//Generator thread
}//ThreadSquareCube

