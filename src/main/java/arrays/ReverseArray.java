package arrays;

import java.util.ArrayList;

public class ReverseArray {
    public ArrayList<Integer> reverseArray(final ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer i : A) {
            result.add(i);
        }
        int n = A.size();
        if (n == 0) return result;
        if (n == 1) {
            result.add(A.get(0));
            return result;
        }
        int p1 = 0;
        int p2 = n - 1;
        while (p1 < p2) {
            int temp = result.get(p1);
            result.set(p1, result.get(p2));
            result.set(p2, temp);
            p1 += 1;
            p2 -= 1;

        }
        return result;
    }
    public static void main(String[] args) {
        ReverseArray reverseArray = new ReverseArray();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        A.add(6);
        System.out.println(reverseArray.reverseArray(A));
    }
}
