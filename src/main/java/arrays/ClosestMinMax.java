package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
use carry forward technique
Given an array A, find the size of the smallest subarray such that it contains at least one occurrence of
 the maximum value of the array and at least one occurrence of the minimum value of the array.
 input A = [2, 6, 1, 6, 9]
            0  1  2  3  4 eg.(a,b) = b-a+1 = 4-2+1=3
 output 3
 solve:
 max:9 and min:1, find  the min length of subarray eg.[1,6,9]
 1. find min for outer loop
 2. once min finds search for max for inner loop j=i+1 to n
 3. once found get the min(ans, j-i+1) break;
 */
public class ClosestMinMax {
    public static int solveWithN2(ArrayList<Integer> A) {
        //TC-N^2
        int min = Collections.min(A);
        int max = Collections.max(A);
        System.out.println(min + " " + max);
        int ans = Integer.MAX_VALUE;
        int n = A.size();
        if(min==max) return 1;//edge case when array values are like 4,4,4,4,4
        for (int i = 0; i < A.size(); i++) {
            if(A.get(i) == min){
                for(int j=i+1;j<n;j++){
                    if(A.get(j) == max){
                        ans = Math.min(ans,j-i+1);
                    }
                }
            }
            else if(A.get(i) == max){
               for(int j=i+1;j<n;j++){
                   if(A.get(j) == min){
                       ans = Math.min(ans,j-i+1);
                   }
               }
            }

        }
        return ans;
    }
    public static int solveWithN(ArrayList<Integer> A) {
        //TC-O(N)
        int min = Collections.min(A);
        int max = Collections.max(A);
        int n = A.size();
        int ans = n;
        int mini=-1;
        int maxi=-1;
        if(min==max) return 1;//edge case when array values are like 4,4,4,4,4
        for (int i=n-1;i>=0;i--) {
            if(A.get(i) == min){
                if(maxi!=-1){
                    ans = Math.min(ans,maxi-i+1);
                }
                mini=i;
            }else if(A.get(i) == max){
                if(mini!=-1){
                    ans = Math.min(ans,mini-i+1);
                }
                maxi=i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Integer[] input = {2, 6, 1, 6, 9};
//        Integer[] input = {4,4,4,4,4};
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(input));
        System.out.println(solveWithN(A));
    }
}
