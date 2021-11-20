package main.FAANG.CompanySpecific;

//There is a forest with an unknown number of rabbits. We asked n rabbits "How many rabbits have the same color as you?
// " and collected the answers in an integer array answers where answers[i] is the answer of the ith rabbit.
//
//Given the array answers, return the minimum number of rabbits that could be in the forest.

import java.util.HashMap;
import java.util.Map;

//Input: answers = [1,1,2]
//Output: 5
//Explanation:
//The two rabbits that answered "1" could both be the same color, say red.
//The rabbit that answered "2" can't be red or the answers would be inconsistent.
//Say the rabbit that answered "2" was blue.
//Then there should be 2 other blue rabbits in the forest that didn't answer into the array.
//The smallest possible number of rabbits in the forest is therefore 5: 3 that answered plus 2 that didn't.
public class RabbitsInForest {

    //If x+1 rabbits have same color, then we get x+1 rabbits who all answer x.
    //now n rabbits answer x.
    //If n % (x + 1) == 0, we need n / (x + 1) groups of x + 1 rabbits.
    //If n % (x + 1) != 0, we need n / (x + 1) + 1 groups of x + 1 rabbits.
    //
    //the number of groups is math.ceil(n / (x + 1)) and it equals to (n + x) / (x + 1) , which is more elegant.


    public static void main(String[] args) {
        int[] x ={5};
        int[] x1={5,5};
        int[] x2={5,5,5};
        int[] x3={5,5,5,5};

        System.out.println(numRabbits(x));
        System.out.println(numRabbits(x1));
        System.out.println(numRabbits(x2));
        System.out.println(numRabbits(x3));
    }
    public static int numRabbits(int[] answers) {
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int answer : answers){
            map.put(answer,map.getOrDefault(answer,0)+1);
        }
        for(Integer n : map.keySet()){
            int group = map.get(n)/(n+1);
            int rem=map.get(n)%(n+1);
            if(rem!=0){
                res +=(group+1)*(n+1);
            }else {
                res +=group*(n+1);
            }
        }
        return res;
    }

}
