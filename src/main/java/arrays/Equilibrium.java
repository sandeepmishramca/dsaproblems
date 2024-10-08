package arrays;

import java.io.File;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Equilibrium {

    class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return "(" + first + ", " + second + ")";
        }
    }
    public boolean findPair(ArrayList<Integer> A){
        ArrayList<Pair> result = new ArrayList<>();
        HashMap<Integer, Pair> map = new HashMap<>();
        int n = A.size();
        for(int i = 0; i < n; ++i){
            for(int j = i + 1; j < n; ++j){
                int sum = A.get(i) + A.get(j);
                if(!map.containsKey(sum)){
                    Pair pair = new Pair(i, j);
                    map.put(sum, pair);

                }else {
                    Pair pair = map.get(sum);

                    if((pair.first < pair.second) && (i<j) && (pair.first < i) &&(pair.second < j)
                    && (pair.second!=j) && (pair.second!=i) && (pair.second<i)
                    ){
                        System.out.println("(" + pair.first + ", " + pair.second +
                                ") and ("+ i + ", " + j + ")");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static ArrayList<Integer> readInputFile(String filename){
        ArrayList<Integer> result = new ArrayList<>();
        try{
            Scanner sc = new Scanner(new File(filename));
            while(sc.hasNext()){
                result.add(sc.nextInt());
            }
            sc.close();
        }catch (Exception e){
            System.out.println(e);
        }finally {

        }
        return result;
    }

    public static void main(String[] args) {
        Equilibrium equilibrium = new Equilibrium();
        ArrayList<Integer> inputArray = new ArrayList<>();
        inputArray.add(3);
        inputArray.add(4);
        inputArray.add(7);
        inputArray.add(1);
        inputArray.add(2);
        inputArray.add(3);
        inputArray.add(8);
        System.out.println(inputArray);
        equilibrium.findPair(inputArray);

    }
}
