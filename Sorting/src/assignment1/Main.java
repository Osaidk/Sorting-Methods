/* 
 * This file is how you might test out your code.  Don't submit this, and don't 
 * have a main method in SortTools.java.
 */

package assignment1;
import java.util.Arrays;


public class Main {
	public static void main(String [] args) {
    int x[]= {1,2,4,5,-100};
    int z[]= {1,1,10,100};
	System.out.println(SortTools.isSorted(x, 0));
	System.out.println(SortTools.isSorted(z, 4));
	System.out.println(SortTools.find(z, 2, 1));
    
	int[] Array = SortTools.insertGeneral(x, 4, 3);
    System.out.println(Arrays.toString(Array));
    
    SortTools.insertInPlace(x, 4, -9);
    System.out.println(Arrays.toString(x));
   
    SortTools.insertInPlace(z, 3, 3);
    System.out.println(Arrays.toString(z));
   
    int y[]= {-1,100,1,5,6,7,8};
    System.out.println(Arrays.toString(y));

    SortTools.insertSort(y, 3);
    System.out.println(Arrays.toString(y));
	}
}

