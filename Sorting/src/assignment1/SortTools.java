// SortTools.java 
/*
 * EE422C Project 1 submission by
 * Replace <...> with your actual data.
 * <Student Name>
 * <Student EID>
 * <5-digit Unique No.>
 * Fall 2018
 * Slip days used: 
 */

package assignment1;



public class SortTools {
    /**
      * This method tests to see if the given array is sorted.
      * @param x is the array
      * @param n is the size of the input to be checked
      * @return true if array is sorted
      */
    public static boolean isSorted(int[] x, int n) { // This method checks if an array is in a non-decreasing order
        if (x.length==0 || n==0) {
            return false;
        }
        int PreviousTerm = x[0];
        for (int i=0 ; i<n; i++) {
            if (x[i] >= PreviousTerm) { // The method compares elements and determines the output.
                PreviousTerm = x[i];
            }
            else return false;
        }
        return true;
    }

    /**
     * This method returns the index of value v within array x.
     * @param x is the array
     * @param n is the size of the input to be checked
     * @param v is the value to be searched for within x
     * @return index of v if v is contained within x. -1 if v is not contained within x
     */
    public static int find(int[] x, int n, int v) { // The method uses binary search to find a certain element with the help of a helper method.
       int result = find_helper(x,0,n-1,v);
       return result;
    }

    public static int find_helper(int[] x, int start, int end, int v) {
           
          if (end >= start ) {
              int MidPoint= start+(end-start)/2; // The helper method runs recursively to find v with binary search implementation. 
              if (x[MidPoint]==v) {
                  return MidPoint;
              }
              if (x[MidPoint] > v) {
                 return find_helper(x, start, MidPoint-1,v); // The method cuts the array in half every time it runs. 
              }
              if (x[MidPoint] < v) {
                  return find_helper(x, MidPoint+1, end, v);
              }
          }
          return -1;
    }
    /**
     * This method returns a newly created array containing the first n elements of x, and v.
     * @param x is the array
     * @param n is the number of elements to be copied from x
     * @param v is the value to be added to the new array
     * @return a new array containing the first n elements of x, and v
     */
    public static int[] insertGeneral(int[] x, int n, int v){ // The method looks for v in x for n range, and if found it returns a new array with n range (sorted via precondition).
        int v_index = find(x, n, v);                          // if not found, it creates an array of n+1 range and it inserts v at the end and then sorts the array and returns it. 
        
        if (v_index != -1) { 
            int[] Arr=new int[n];
            for (int i=0;i<n; i++) {
                Arr[i]=x[i];
            }
            return Arr;
        }
        else {
            int Arr_index=n;
            v_index = find(x, x.length, v);
            int[] Arr=new int[Arr_index+1];
            for (int i=0;i<Arr_index; i++) {
                Arr[i]=x[i];
            }
            Arr[Arr_index]=v;
            if (!isSorted(Arr, Arr_index+1)) {
                insertSort(Arr, Arr_index+1);
            }
            return Arr;

        }
    }

    /**
     * This method inserts a value into the array and ensures it's still sorted
     * @param x is the array
     * @param n is the number of elements in the array
     * @param v is the value to be added
     * @return n if v is already in x, otherwise returns n+1
     */
    public static int insertInPlace(int[] x, int n, int v){ // The method looks for v in the n range of x, if found it returns n and leaves the array unmodified (sorted via precondition)
        int result=find(x, n, v);                           //if v not found, the method inserts v at n range and then sorts it to the required range and return n+1.
        if (result != -1) {
            return n;
        }
        else {
            x[n]=v;
            if (!isSorted(x, n+1)) {
                insertSort(x, n+1);
            }
        }
        return n+1;
    }

    /**
     * This method sorts a given array using insertion sort
     * @param x is the array to be sorted
     * @param n is the number of elements of the array to be sorted
     */
    public static void insertSort(int[] x, int n){ // The method uses a mechanism to sort only when necessary by using a while loop to look at previous elements of 
        int j;                                      // an array when passed by the for loop.
        int temp;
        for (int i=1 ;i<n; i++) {
            temp=x[i];
            j=i-1;
                while (j >= 0 && x[j]>temp) {
                    x[j+1]=x[j];
                     j--;
                }
                x[j+1]=temp;
        }
    }
}

