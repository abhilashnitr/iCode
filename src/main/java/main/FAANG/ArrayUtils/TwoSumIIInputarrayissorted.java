package main.FAANG.ArrayUtils;

//Given an array of integers numbers that is already sorted in ascending order, find two numbers such that they add up
// to a specific target number.
//
//Return the indices of the two numbers (1-indexed) as an integer array answer of size 2,
// where 1 <= answer[0] < answer[1] <= numbers.length.
//
//You may assume that each input would have exactly one solution and you may not use the same element twice.
public class TwoSumIIInputarrayissorted {

    public int[] twoSum(int[] num, int target) {
        int[] indice = new int[2];
        if (num == null || num.length < 2) return indice;
        int left = 0, right = num.length - 1;
        while (left < right) {
            int v = num[left] + num[right];
            if (v == target) {
                indice[0] = left + 1;
                indice[1] = right + 1;
                break;
            } else if (v > target) {
                right --;
            } else {
                left ++;
            }
        }
        return indice;
    }
}
