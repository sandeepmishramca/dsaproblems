package twodarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Matrix {
    public static ArrayList<Integer> rowSum(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            int sum  = 0;
            for(int j=0;j<m;j++){
                sum += A.get(i).get(j);
            }
            result.add(sum);
        }
        return result;
    }

    public static int mainDiagonal(final List<ArrayList<Integer>> A) {
        //get sum of main diagonal with TC.O(N) is left diagonal
        int n = A.size();
        int sum = 0;
        for(int i=0;i<n;i++){
            sum+=A.get(i).get(i);
        }
        return sum;
    }

    public static int rightDiagonal(final List<ArrayList<Integer>> A) {
        //get sum of main diagonal with TC.O(N) is left diagonal
        int n = A.size();
        int sum = 0;
        int i=0;
        int j =n-1;
        while(i<n && j>=0){
            sum+=A.get(i).get(j);
            i++;
            j--;
        }
        return sum;
    }

    public static int minorDiagonalSum(final List<ArrayList<Integer>> A) {
        /*
        You are given a N X N integer matrix. You have to find the sum of all the minor diagonal elements of A.
        Minor diagonal of a M X M matrix A is a collection of elements A[i, j] such that i + j = M + 1 (where i, j are 1-based)
        --only trick to understand make an expression relationship to convert 1-based indexing to 0-based indexing since
        we have to process in 0-based indexing
         */
        int n = A.size();
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=A.get(i).get(n-1-i);
        }
        return sum;
    }

    public static ArrayList<Integer> columnSum(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = A.size();
        int m = A.get(0).size();
//        System.out.println(n+" "+m);

        for(int j = 0; j < m; j++){
            int sum=0;
            for(int i=0;i<n;i++){
                sum+=A.get(i).get(j);
//                System.out.println(A.get(i).get(j));
            }
            result.add(sum);
        }
        return result;
    }
    public static ArrayList<ArrayList<Integer>> convertToArrayList(Integer[][] array) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(Integer[] row : array){
            ArrayList<Integer> list = new ArrayList<>();
            for(Integer i : row){
                list.add(i);
            }
            result.add(list);
        }
        return result;
    }
    public static void main(String[] args) {
//        Integer[][] matrix = new Integer[][]{
//                {1,2,3,4},
//                {5,6,7,8},
//                {9,2,3,4}
//        };
//        ArrayList<ArrayList<Integer>> A = convertToArrayList(matrix);
//        System.out.println(columnSum(A));
        Integer[][] input = {{1,2,3}, {4,5,6}, {10,8,9}};

        List<ArrayList<Integer>> A = convertToArrayList(input);
//        System.out.println(mainDiagonal(A));
        System.out.println(rightDiagonal(A));
    }
}
