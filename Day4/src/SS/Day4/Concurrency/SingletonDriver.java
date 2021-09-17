/**
 * 
 */
package SS.Day4.Concurrency;

/**
 * @author Colin Bradshaw
 *
 */
public class SingletonDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DoubleCheckedSingleton dcs1 = DoubleCheckedSingleton.getInstance(1);
		dcs1.printValue();
		DoubleCheckedSingleton dcs2 = DoubleCheckedSingleton.getInstance(2);
		dcs2.printValue();
	}

}
