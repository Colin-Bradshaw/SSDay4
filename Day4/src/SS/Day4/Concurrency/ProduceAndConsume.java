/**
 * 
 */
package SS.Day4.Concurrency;

/**
 * @author Colin Bradshaw
 *
 */
import java.util.ArrayList;
public class ProduceAndConsume {

	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// buffer ArrayList will be prevented from growth by checking MAXSIZE
		final ArrayList<Integer> buffer = new ArrayList<Integer>(7);
		final int MAXSIZE = 7;
		
		Runnable Producer = new Runnable() {
			@Override
			public void run(){
				// currentNumber is incremented every time it is placed into the buffer
				int currentNumber = 1;
				while(true) {
					try {
						synchronized (buffer) {
							while(buffer.size() == MAXSIZE) {
								buffer.wait();
							}
							// add values into buffer
							buffer.add(currentNumber);
							System.out.println("Producer thread added: " + (currentNumber) + " into the buffer");
							
							currentNumber++;
							
							//notify consumer
							buffer.notify();
							
							//slow things down
							Thread.sleep(500);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		Runnable Consumer = new Runnable() {
			@Override
			public void run(){
				// runningTotal adds all numbers consumed
				int runningTotal = 0;
				while(true) {
					try {
						synchronized (buffer) {
							while(buffer.size() == 0) {
								buffer.wait();
							}
							// remove first item, 
							runningTotal += buffer.get(0);
							System.out.println("Consumer thread removed: " + (buffer.remove(0)) + " from the buffer");
							System.out.println("Running total is: " + runningTotal);
							
							//notify producer
							buffer.notify();
							
							//slow things down
							Thread.sleep(500);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		new Thread(Producer).start();
		new Thread(Consumer).start();

	}

}
