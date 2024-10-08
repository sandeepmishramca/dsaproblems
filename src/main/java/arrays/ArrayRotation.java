package arrays;

import java.util.ArrayList;
/*
Given an integer array A of size N and an integer B, you have to return the same array after rotating it B times towards the right.
 */
public class ArrayRotation {
    public ArrayList<Integer> reverseInRange(ArrayList<Integer> A, int B, int C) {
        int n = A.size();
        if(n == 0) return A;
        if(n == 1) return A;
        if(B < n && C < n){
            int p1 = B;
            int p2 = C;
            while(p1<p2){
                int temp = A.get(p1);
                A.set(p1, A.get(p2));
                A.set(p2, temp);
                p1+=1;
                p2-=1;
            }
        }
        return A;
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B){
        int n = A.size();
        B = B%n;
        reverseInRange(A, 0, n-1);
        reverseInRange(A, 0, B-1);
        reverseInRange(A, B, n-1);
        return A;
    }
    public static void main(String[] args) {
        int B = 1;
        ArrayRotation arrayRotation = new ArrayRotation();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        A.add(6);
        A.add(7);
        A.add(8);
        System.out.println(arrayRotation.solve(A,B));
    }
}
