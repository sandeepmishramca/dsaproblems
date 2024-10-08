package arrays;

import java.util.ArrayList;
/*
You are given an integer array A.
You have to find the second largest element/value in the array or report that no such element exists.
 */
public class SumOfMaxMin {
    public int getSecondMaxElement(ArrayList<Integer> A) {
        //first get max element then get 2nd max
        int n = A.size();
        if (n == 0) return -1;
        if (n == 1) return -1;
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for(int i = 0; i < A.size(); i++) {
            if(A.get(i) > max) {
                max = A.get(i);
            }
        }
        for(int i = 0; i < A.size(); i++) {
            if(A.get(i) > secondMax && A.get(i) != max) {
                secondMax = A.get(i);
            }
        }
        //if input [4,4,4,4]
        if(secondMax==Integer.MIN_VALUE) {
            return -1;
        }
        return secondMax;
    }
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (A.get(i) > max) {
                max = A.get(i);
            }
        }
        for (int i = 0; i < n; i++) {
            if (A.get(i) < min) {
                min = A.get(i);
            }
        }
        return max+min;
    }
    public static void main(String[] args) {
        SumOfMaxMin sm = new SumOfMaxMin();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(4);
        A.add(4);
        A.add(4);
        System.out.println(sm.getSecondMaxElement(A));
    }
}
