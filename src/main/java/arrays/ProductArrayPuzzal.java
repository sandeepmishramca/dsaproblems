package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/*
Given an array of integers A, find and return the product array of the same size where the ith element of the product array will be equal to the product of all the elements divided by the ith element of the array.

Note: It is always possible to form the product array with integer (32 bit) values. Solve it without using the division operator.
 */
public class ProductArrayPuzzal {
    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        int n = A.size();
        Integer[] inputArray = A.toArray(new Integer[n]);
        Integer[] outputArray = new Integer[n];
        Integer[] prefixProudct = new Integer[n];
        Integer[] suffixProudct = new Integer[n];

        //calculate prefix and suffix array list
        prefixProudct[0] = inputArray[0];
        suffixProudct[n-1] = inputArray[n-1];

        //calculate prefix product array
        for (int i = 1; i < n; i++) {
            prefixProudct[i] = prefixProudct[i-1] * inputArray[i];
        }
        //calculate suffix product array
        for(int i=n-2;i>=0;i--){
            suffixProudct[i] = suffixProudct[i+1] * inputArray[i];
        }

        for (int i = 0; i < n; i++) {
            if(i==0){
                outputArray[i] = suffixProudct[i+1];
            } else if (i==n-1) {
                outputArray[i] = prefixProudct[i-1];
            }else{
                outputArray[i] = prefixProudct[i-1] * suffixProudct[i+1];
            }
        }
        return new ArrayList<>(Arrays.asList(outputArray));
    }
    public static void main(String[] args) {
        Integer[] ip = {5,1,10,1};
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(ip));
        System.out.println(solve(A));
    }
}
