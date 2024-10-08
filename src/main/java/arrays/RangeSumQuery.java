package arrays;

import java.util.ArrayList;
//Prefix sum concept used
public class RangeSumQuery {
    public ArrayList<Long> sumRange(ArrayList<Integer> A,ArrayList<ArrayList<Integer>> B) {
        //calculate prefix sum
        ArrayList<Integer> preSum = new ArrayList<>();
        ArrayList<Long> result = new ArrayList<>();
        int n = A.size();
        preSum.add(A.get(0));
        for (int i = 1; i < n; i++) {
            int add = preSum.get(i-1) + A.get(i);
            preSum.add(add);
            }
        //get sum of range query
        long sum = 0;
        // from 0 to size of B
        for(int i=0;i<B.size();i++){
            int left = B.get(i).get(0);

            int right = B.get(i).get(1);
            if(left==0){
                sum = preSum.get(right);
            }else{
                if(left>0){
                    sum = preSum.get(right) - preSum.get(left-1);
                }

            }
            result.add(sum);
        }
        return result;
    }
    public static void main(String[] args) {
        RangeSumQuery q = new RangeSumQuery();
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        B.add(new ArrayList<>());
        B.add(new ArrayList<>());
        //add element in first row
        B.get(0).add(0);
        B.get(0).add(3);
        //add element in second row
        B.get(1).add(1);
        B.get(1).add(2);
        System.out.println(B);
        System.out.println(q.sumRange(A, B));

    }
}
