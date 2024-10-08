package arrays;

import java.util.ArrayList;
/*
Given an array A of N integers.
Count the number of elements that have at least 1 elements greater than itself.
 */
public class CountOfElemet {

    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        int max = Integer.MIN_VALUE;
        int max_count = 0;
        //find max element
        for (int i = 0; i < n; i++) {
            if(max <= A.get(i)) {
                max = A.get(i);
            }
        }
        for (int i = 0; i < n; i++) {
            if(max == A.get(i)) {
                max_count+=1;
            }
        }
        return n - max_count;

    }
    public static void main(String[] args) {
        CountOfElemet c = new CountOfElemet();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(3);
        A.add(1);
        A.add(2);
        c.solve(A);
        System.out.println(c.solve(A));
    }
}
