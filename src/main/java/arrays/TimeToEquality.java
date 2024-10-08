package arrays;

import java.util.ArrayList;
import java.util.Collections;

/*
Given an integer array A of size N. In one second, you can increase the value of one element by 1.
Find the minimum time in seconds to make all elements of the array equal.
 */
public class TimeToEquality {
    public int solve(ArrayList<Integer> A) {
        int max = Collections.max(A);
        int minTime = 0;
        for (int i = 0; i < A.size(); i++) {
            if (max != A.get(i)) {
                minTime += max - A.get(i);
            }
        }
        return minTime;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(4);
        list1.add(1);
        list1.add(3);
        list1.add(2);
        System.out.println(new TimeToEquality().solve(list1));

    }

}
