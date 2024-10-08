package arrays;

import java.util.ArrayList;
/*
Given an array A of N integers and also given two integers B and C.
Reverse the elements of the array A within the given inclusive range [B, C].
 */
public class ReverseInRange {

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
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        A.add(6);
        A.add(7);
        A.add(8);
        ReverseInRange r = new ReverseInRange();
//        System.out.println(r.reverseInRange(A, 4,7 ));

    }
}
