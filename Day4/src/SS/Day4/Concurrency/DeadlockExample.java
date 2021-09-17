/**
 * 
 */
package SS.Day4.Concurrency;

/**
 * @author Colin Bradshaw
 *
 */
public class DeadlockExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer a = 5;
		Integer b = 7;
		
		Runnable t1 = new Runnable() {
			@Override
			public void run() {
				try {
					synchronized (a) {
						// should print
						System.out.println("t1 acquired lock on Integer a");
						Thread.sleep(100);
						synchronized (b) {
							// should never print
							System.out.println("t1 acquired lock on Integer b");
							System.out.println("Total of a + b is: " + (a + b));
						}
					}
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		};
		
		Runnable t2 = new Runnable() {
			@Override
			public void run() {
				try {
					synchronized (b) {
						// should print
						System.out.println("t2 acquired lock on Integer b");
						Thread.sleep(100);
						synchronized (a) {
							// should never print
							System.out.println("t2 acquired lock on Integer a");
							System.out.println("Total of a + b is: " + (a + b));
						}
					}
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		};
		/*
		 * both t1 and t2 are trying to perform addition between Integer a and b
		 * because they acquire locks in different orders, they end in deadlock.
		 */
		new Thread(t1).start();
		new Thread(t2).start();
		
		System.out.println("For successful deadlock, t1 should have acquired Integer a, t2 will have acquired Integer b");

	}

}
