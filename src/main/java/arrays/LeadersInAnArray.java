package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an integer array A containing N distinct integers, you have to find all the leaders in array A.
An element is a leader if it is strictly greater than all the elements to its right side.
input  A = [16, 17, 4, 3, 5, 2]
output [17, 2, 5]
 */
public class LeadersInAnArray {
    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        /*
        ---------Array Carry forward------
        1. get max for each index and add the max value in the list
         */
        int n = A.size();
        Integer[] arr = A.toArray(new Integer[n]);
        ArrayList<Integer> result = new ArrayList<>();

        result.add(arr[n-1]);
        int max = arr[n-1];
        for(int i = n-2; i >=0; i--) {
            if(arr[i]>max){
                max = arr[i];
                result.add(arr[i]);
            }

        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] input= {16, 17, 4, 3, 5, 2};
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(input));
        System.out.println(LeadersInAnArray.solve(A));
    }
}
