package arrays;

import java.util.ArrayList;
/*
Given an array A and an integer B. A pair(i, j)
in the array is a good pair if i != j and (A[i] + A[j] == B). Check if any good pair exist or not.
 */
public class GoodPair {
    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if(A.get(i) + A.get(j)==B) {
                    return 1;
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        System.out.println(new GoodPair().solve(A, 7));
    }
}
