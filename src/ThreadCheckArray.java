import java.util.ArrayList;

/**
 * Description of ThreadCheckArray
 * 
 * @auther Tal-chen
 * @version 1.0 27/10/2021
 */
public class ThreadCheckArray implements Runnable {
	private boolean flag;
	private boolean[] winArray;
	SharedData sd;
	// int[] array;
	ArrayList<Integer> array;
	int b;

	/**
	 * Description of contractor ThreadCheckArray
	 * 
	 * @param sd - given sd type of sheredData
	 */
	public ThreadCheckArray(SharedData sd) {
		this.sd = sd;
		synchronized (sd) {
			array = sd.getArray();
			b = sd.getB();
		}
		winArray = new boolean[array.size()];
	}

	/**
	 * Description of method rec
	 * 
	 * @param n - an int
	 * @param b - an int
	 */
	void rec(int n, int b) {
		synchronized (sd) {
			if (sd.getFlag())
				return;
		}
		if (n == 1) {
			if (b == 0 || b == array.get(n - 1)) {
				flag = true;
				synchronized (sd) {
					sd.setFlag(true);
				}
			}
			if (b == array.get(n - 1))
				winArray[n - 1] = true;
			return;
		}

		rec(n - 1, b - array.get(n - 1));
		if (flag)
			winArray[n - 1] = true;
		synchronized (sd) {
			if (sd.getFlag())
				return;
		}
		rec(n - 1, b);
	}

	/**
	 * Description of method run
	 */
	public void run() {
		if (array.size() != 1)
			if (Thread.currentThread().getName().equals("thread1"))
				rec(array.size() - 1, b - array.get(array.size() - 1));
			else
				rec(array.size() - 1, b);
		if (array.size() == 1)
			if (b == array.get(0) && !flag) {
				winArray[0] = true;
				flag = true;
				synchronized (sd) {
					sd.setFlag(true);
				}
			}
		if (flag) {
			if (Thread.currentThread().getName().equals("thread1"))
				winArray[array.size() - 1] = true;
			synchronized (sd) {
				sd.setWinArray(winArray);
			}
		}
	}
}