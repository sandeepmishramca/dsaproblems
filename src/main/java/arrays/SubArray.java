package arrays;

import java.util.ArrayList;
import java.util.Arrays;

//A continues part of an array is called subarray
public class SubArray {
    public static void printSubArray(ArrayList<Integer> A){
        int n = A.size();
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                for(int k = i; k<=j;k++){
                    System.out.print(A.get(k)+" ");
                    count++;
                }
                System.out.println();
            }
        }
        System.out.println("count: "+count);
    }

    public static ArrayList<Integer> subArraySumUsingPrefixSum(ArrayList<Integer> A){
        int n = A.size();
        //calculate prefix subarray
        Integer[] input = A.toArray(new Integer[n]);
        Integer[] prefixSum = new Integer[n];
        for (int i = 0; i < n; i++) {
            if(i==0){
                prefixSum[i] = input[i];
            }else{
                prefixSum[i] = prefixSum[i-1] + input[i];
            }
        }
        int sum = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(i==0){
                   sum = prefixSum[j];
                }else{
                    sum = prefixSum[j] - prefixSum[i-1];
                }
                result.add(sum);
            }
        }
        return result;
    }
    public static ArrayList<Integer> subArraySumUsingCarryForward(ArrayList<Integer> A){
        int n = A.size();
        int sum = 0;
        int total_sum = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++){
            sum = 0;
            for(int j = i; j < n; j++){
                sum = sum + A.get(j);
                total_sum = total_sum + sum;
                result.add(sum);

            }

        }
        System.out.println(total_sum);
        return result;
    }

    public static int subArraySumUsingContribution(ArrayList<Integer> A){
        int n = A.size();
        int total_sum =0;
        int frequency = 0;
        for(int i = 0; i < n; i++){
            frequency = (i+1)*(n-i);
            total_sum += A.get(i) * frequency;
        }
        return total_sum;
    }
    public static int countSubarrayStringWithLetterA(String A){
        int n = A.length();
        int count =0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(A.charAt(i) == 'a'){
                    count+=1;
                }
            }
        }
        return count;
    }

    public static int amazingSubStringBF(String A){
        A = A.toLowerCase();
        int mod = 10003;
        int n = A.length();
        int count =0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if((A.charAt(i)=='a')||(A.charAt(i)=='e')||(A.charAt(i)=='i')||(A.charAt(i)=='o')||(A.charAt(i)=='u')){
                    count=(count+1)%mod;
                }
            }
        }
        return count;
    }

    public static int amazingSubStringN(String A){
        A = A.toLowerCase();
        int mod = 10003;
        int n = A.length();
        int count =0;
        for(int i = 0; i < n; i++){
            if((A.charAt(i)=='a')||(A.charAt(i)=='e')||(A.charAt(i)=='i')||(A.charAt(i)=='o')||(A.charAt(i)=='u')){
                count= (count + (n-i)%mod)%mod;
            }
        }
        return count;
    }
    public static String evenSubArray(ArrayList<Integer> A){
        /*
        You are given an integer array A.
        Decide whether it is possible to divide the array into one or more subarrays of even length such that the first and last element of all subarrays will be even.
        Return "YES" if it is possible; otherwise, return "NO" (without quotes).
        1. Array length must be even
        2. Array first and last element must be even
         */

        int n = A.size();
        if(n%2==0 && A.get(0)%2==0 && A.get(n-1)%2==0){
            return "YES";
        }else{
            return "NO";
        }
    }
    public static int pickeFromBothSides(ArrayList<Integer> A, int B){
        /*
        Problem Description
        You are given an integer array A of size N.
        You have to perform B operations. In one operation, you can remove either the leftmost or the rightmost element of the array A.
        Find and return the maximum possible sum of the B elements that were removed after the B operations.
        NOTE: Suppose B = 3, and array A contains 10 elements, then you can:

        Remove 3 elements from front and 0 elements from the back, OR
        Remove 2 elements from front and 1 element from the back, OR
        Remove 1 element from front and 2 elements from the back, OR
        Remove 0 elements from front and 3 elements from the back.
         */
        int n = A.size();
        Integer[] input = A.toArray(new Integer[n]);
        Integer[] prefixSum = new Integer[n];
        Integer[] suffixSum = new Integer[n];
        prefixSum[0] = input[0];
        for(int i = 1; i < n; i++){
            prefixSum[i] = prefixSum[i-1] + input[i];
        }
        suffixSum[n-1] = input[n-1];
        for(int i = n-2; i >= 0; i--){
            suffixSum[i] = suffixSum[i+1] + input[i];
        }
        int sum = 0;
        //edge case
        int ans = 0;
        ans = Math.max(prefixSum[B-1],suffixSum[n-B]);
        for(int i = 1; i < B; i++){
            sum = prefixSum[i-1] + suffixSum[n-B+i];
            ans = Math.max(ans,sum);
        }
        return ans;
    }

    public static int bulbsN2(ArrayList<Integer> A){
        /*
        A wire connects N light bulbs.
        Each bulb has a switch associated with it; however, due to faulty wiring, a switch also changes the state of all the bulbs to the right of the current bulb.
        Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs.
        You can press the same switch multiple times.
        Note: 0 represents the bulb is off and 1 represents the bulb is on.
         */
        int count = 0;
        int n = A.size();
        Integer[] arr = A.toArray(new Integer[n]);
        for(int i = 0; i < n; i++){
            if(arr[i]==0){
                count+=1;
                for(int j = i; j < n; j++){
                    arr[j] = 1 - arr[j];
                }
            }
        }
        return count;
    }



    public static int bulbsN(ArrayList<Integer> A) {
        /*
        A wire connects N light bulbs.
        Each bulb has a switch associated with it; however, due to faulty wiring, a switch also changes the state of all the bulbs to the right of the current bulb.
        Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs.
        You can press the same switch multiple times.
        Note: 0 represents the bulb is off and 1 represents the bulb is on.

        Observation:1. if switch is pressed  even times if it is already on, then bulb will be on
        2. if buld is off , then swich odd no of times , it will toggle to all right bulbs
         */
        int count = 0;
        int n = A.size();
        Integer[] arr = A.toArray(new Integer[n]);
        for (int i = 0; i < n; i++) {
            int state = arr[i];
            if (count%2 != 0) {//odd
                state = 1 - arr[i];//toggle
            }
            if(state == 0){
                count++;
            }
        }
        return count;
    }

    public static ArrayList<Integer> getSubArray(ArrayList<Integer> A, int B, int C){
        int n = A.size();
        Integer[] arr = A.toArray(new Integer[n]);
//        Integer[] output = new Integer[n];
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = B; i <= C; i++){
            result.add(arr[i]);
        }
        return result;
    }
    public static int maxSubArray(int A, int B ,ArrayList<Integer> C){
    /*
    You are given an integer array C of size A. Now you need to find a subarray (contiguous elements) so that the sum of contiguous elements is maximum.
    But the sum must not exceed B.
     */
        int n = C.size();
        int maxSum = 0;
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j = i; j < n; j++){
                sum += C.get(j);
                if(sum <=B && sum>maxSum){
                    maxSum = sum;
                }
            }
        }
        return maxSum;

    }
    public  static Long sumOfAllSubArray(ArrayList<Integer> A){
        // find sum of all subarray using contribution technique
        int n = A.size();
        Long sum = 0L;
        Long frequency = 0L;
        for(int i = 0; i < n; i++){
            frequency = (long)(i+1)*(n-i);
            sum += frequency * A.get(i);
        }
        return sum;
    }

    public static ArrayList<ArrayList<Integer>> generateAllSubArrays(ArrayList<Integer> A){
        int n = A.size();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                ArrayList<Integer> current_list = new ArrayList<>();
                for(int k = i; k <= j; k++){
                    current_list.add(A.get(k));
                }
                result.add(current_list);
            }
        }
        return result;
    }
    public static ArrayList<Integer> alternativeSubArray(ArrayList<Integer> A, int B){
        /*
        You are given an integer array A of length N comprising of 0's & 1's, and an integer B.
        You have to tell all the indices of array A that can act as a center of 2 * B + 1 length 0-1 alternating subarray.
        A 0-1 alternating array is an array containing only 0's & 1's, and having no adjacent 0's or 1's. For e.g. arrays [0, 1, 0, 1], [1, 0] and [1] are 0-1 alternating, while [1, 1] and [0, 1, 0, 0, 1] are not.
         */
        //len of subarray = 2*B+1
        int n = A.size();
        int len = 2*B+1;
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < n-len+1; i++){
            int prev=-1;
            int flag = 1;
            for(int j = i; j < i+len; j++){
                if(A.get(j)==prev){
                    flag = 0;
                    break;
                }
                prev = A.get(j);
            }
            if(flag == 1){
                result.add(i+B);
            }
        }
        return result;
    }
    public static int goodSubarray(ArrayList<Integer> A, int B){
        /*
        Given an array of integers A, a subarray of an array is said to be good if it fulfills any one of the criteria:
        1. Length of the subarray is be even, and the sum of all the elements of the subarray must be less than B.
        2. Length of the subarray is be odd, and the sum of all the elements of the subarray must be greater than B.
        Your task is to find the count of good subarrays in A.
         */
        int n = A.size();
        int countOfGoodSubarray = 0;
        for(int i = 0; i < n; i++){
            int sum = 0;
            int subarrayLength=0;
            for (int j = i; j < n; j++){
                sum += A.get(j);
                subarrayLength = j-i+1;
                if((sum < B && subarrayLength%2==0) || (sum>B && subarrayLength%2!=0)){
                    countOfGoodSubarray++;
                }
            }
        }
        return countOfGoodSubarray;
    }

    public static int countSubarray(ArrayList<Integer> A, int B){
        int n = A.size();
        int countSubarray = 0;
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = i; j < n; j++){
                sum += A.get(j);
                if(sum<B){
                    countSubarray++;
                }
            }
        }
        return countSubarray;
    }

    public static void main(String[] args) {
//        Integer[] arr = {0,0,0,1,0,0,0,1,0,1,1};
//        Integer[] arr   = {13, 16, 16, 15, 9, 16, 2, 7, 6, 17, 3, 9};
        Integer[] arr = {2,5,6};
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(arr));
//        printSubArray(A);
//        System.out.println(subArraySumUsingPrefixSum(A));
//        System.out.println(subArraySumUsingCarryForward(A));
//        System.out.println(subArraySumUsingContribution(A));
//        System.out.println(countSubarrayStringWithLetterA("amazon"));
//        String A = "pGpEusuCSWEaPOJmamlFAnIBgAJGtcJaMPFTLfUfkQKXeymydQsdWCTyEFjFgbSmknAmKYFHopWceEyCSumTyAFwhrLqQXbWnXSn";
//        System.out.println(amazingSubString(A));
//        System.out.println(bulbsN(A));
//        System.out.println(pickeFromBothSides(A,3));
//        System.out.println(getSubArray(A,1,3));
//        System.out.println(maxSubArray(9,14,A));
//        System.out.println(sumOfAllSubArray(A));
//        System.out.println(generateAllSubArrays(A));

//        System.out.println(alternativeSubArray(A,1));
//        System.out.println(goodSubarray(A,65));
        System.out.println(countSubarray(A,10));
    }

}
