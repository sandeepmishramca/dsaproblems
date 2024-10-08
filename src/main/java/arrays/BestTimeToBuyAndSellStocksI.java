package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Problem Description

Say you have an array, A, for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Return the maximum possible profit.
 */
public class BestTimeToBuyAndSellStocksI {
    public static int solveN2(final List<Integer> A){
        //T.C = N^2
        int n = A.size();
        if(n == 0) return 0;
        if(n == 1) return 0;
        int max = Integer.MIN_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        int profit = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                max = A.get(i);
                if(A.get(j) > max){
                    max = A.get(j);
                }
                profit = max - A.get(i);
                if(profit > maxProfit){
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }
    public static int solveN(final List<Integer> A){
        int n = A.size();
        if(n == 0) return 0;
        if(n == 1) return 0;
        Integer[] arr = A.toArray(new Integer[n]);
        int max = arr[n-1];
        int maxProfit = Integer.MIN_VALUE;
        int profit = 0;

        for(int i = n-2; i >=0; i--){
            max = Math.max(max, A.get(i));//instead of writing if statement
//            if(arr[i] > max){
//                max = arr[i];
//            }
            profit = max - arr[i];
            maxProfit = Math.max(maxProfit, profit);
//            if(profit > maxProfit){
//                maxProfit = profit;
//            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
//        Integer[] arr = {3,5,7,2,4,3,8,6};
        Integer[] arr = {1, 4, 5, 2, 4};
        List<Integer> A = new ArrayList<Integer>(Arrays.asList(arr));
        System.out.println(solveN(A));
    }
}
