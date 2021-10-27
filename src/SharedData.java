import java.util.ArrayList;

/**
 * Description of SharedData
 * 
 * @auther Tal-chen
 * @version 1.0 27/10/2021
 */
public class SharedData {
	// private int [] array;
	private ArrayList<Integer> array;
	private boolean[] winArray;
	private boolean flag;
	private final int b;

	// public SharedData(int[] array, int b) {
	/**
	 * Description of contractor SharedData
	 * 
	 * @param array given array of Integers
	 * @param b     - an int
	 */
	public SharedData(ArrayList<Integer> array, int b) {
		this.array = array;
		this.b = b;
	}

	/**
	 * Description of method getWinArray
	 * 
	 * @return winArray - array of boolean
	 */
	public boolean[] getWinArray() {
		return winArray;
	}

	/**
	 * Description of method setWinArray
	 * 
	 * @param winArray - array of boolean
	 */
	public void setWinArray(boolean[] winArray) {
		this.winArray = winArray;
	}

	// public int[] getArray()
	/**
	 * Description of method getArray
	 * 
	 * @return array - array of Integers
	 */
	public ArrayList<Integer> getArray() {
		return array;
	}

	/**
	 * Description of method getB
	 * 
	 * @return b - an int
	 */
	public int getB() {
		return b;
	}

	/**
	 * Description of method getFlag
	 * 
	 * @return flag - an boolean
	 */
	public boolean getFlag() {
		return flag;
	}

	/**
	 * Description of method setFlag
	 * 
	 * @param flag - an boolean
	 */
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}