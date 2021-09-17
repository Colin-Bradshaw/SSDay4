/**
 * 
 */
package SS.Day4.Concurrency;

/**
 * @author Colin Bradshaw
 *
 */
public class DoubleCheckedSingleton {

	private static volatile DoubleCheckedSingleton dcs =  null;
	private int data;
	
	private DoubleCheckedSingleton(int num) {
		data = num;
	}
	
	public static DoubleCheckedSingleton getInstance(int num) {
		if(dcs == null) {
			synchronized (DoubleCheckedSingleton .class) {
				if (dcs == null) {
					dcs = new DoubleCheckedSingleton(num);
					System.out.println("A DCLSingleton was instantiated and returned.");
				}
			}
		} else {
			System.out.println("A reference to the existing DCLSingleton was returned.");
		}
		
		return dcs;
	}
	
	public void printValue() {
		System.out.println("The number contained in the singleton is: " + data);
	}
}
