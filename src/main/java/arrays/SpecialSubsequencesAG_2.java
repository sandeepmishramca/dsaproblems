package arrays;

import java.util.ArrayList;
/*
Use Carry forward technique
You have given a string A having Uppercase English letters.

You have to find the number of pairs (i, j) such that A[i] = 'A', A[j] = 'G' and i < j.
 */
public class SpecialSubsequencesAG_2 {
    public static Long solveNSquereSolution(String A) {
        int n = A.length();
        Long count=0L;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if((A.charAt(i)=='A') && (A.charAt(j)=='G')) {
                    count +=1;
                }
            }
        }
        return count;
    }

    public static Long solveNSolution(String A) {
        int n = A.length();
        Long count=0L;
        Long ans = 0L;
        for (int i = 0; i < n; i++) {
           if(A.charAt(i)=='A') {
               count +=1;
           }
           if(A.charAt(i)=='G') {
               ans += count;
           }
        }
        return ans;
    }

    public static void main(String[] args) {
        String A = "ABCGAG";
        System.out.println(solveNSolution(A));
    }
}
