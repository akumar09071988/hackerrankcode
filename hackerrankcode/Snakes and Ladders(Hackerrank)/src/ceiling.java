
public class ceiling {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
 
		int [] arr = new int[]{2,3,5,7,9,11};
		int key = 2;
		int low =0;
		int high= arr.length-1;
		System.out.println(ceiling.rank(12,arr));
	}
	
	 public static int rank(int key, int[] a) {
	        int lo = 0;
	        int hi = a.length - 1;
	        while (lo <= hi) {
	            // Key is in a[lo..hi] or not present.
	            int mid = lo + (hi - lo) / 2;
	            if      (key < a[mid]) hi = mid - 1;
	            else if (key > a[mid]) lo = mid + 1;
	            else return mid;
	        }
	        return hi;
	    }

}
