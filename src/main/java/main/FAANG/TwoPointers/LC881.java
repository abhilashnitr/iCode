package main.FAANG.TwoPointers;

import java.util.Arrays;

//You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats where
// each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time, provided the
// sum of the weight of those people is at most limit.
//
//Return the minimum number of boats to carry every given person.
public class LC881 {

    public int numRescueBoats(int[] people, int limit) {

        if(people == null || people.length == 0 || limit<=0){
            return 0;
        }

        Arrays.sort(people);

        int start = 0;
        int end = people.length-1;
        int numberOfBoats = 0;

        while(start<=end){
            if(people[start]+people[end]>limit){
                end--;
            }
            else{
                start++;
                end--;
            }

            numberOfBoats++;
        }
        return numberOfBoats;
    }

    //Time Complexity:O(NlogN), where N is the length of people.
    //
    //Space Complexity: O(N)O(N).
}
