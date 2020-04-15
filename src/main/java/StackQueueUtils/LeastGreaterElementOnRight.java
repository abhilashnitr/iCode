package StackQueueUtils;

import java.util.TreeSet;

public class LeastGreaterElementOnRight {

  public static void main(String[] args) {
    int[] a={ 8, 58, 71, 18, 31, 32, 63, 92,
        43, 3, 91, 93, 25, 80, 28 };
    nextLeastGreaterElement(a);
  }

  private static void nextLeastGreaterElement(int[] a) {

    TreeSet<Integer> t = new TreeSet<>();
    for (int i = 0; i < a.length; i++)
      t.add(a[i]);
    for (int i = 0; i < a.length; i++) {

      // If the elements does not have an upper bound
      // or an element greater than it,
      // higher method of TreeSet class will return NULL
      if (t.higher(a[i]) == null)
        System.out.println(a[i] + " ----> "
            + "-1");

        // Otherwise print the upper bound of that element
      else
        System.out.println(a[i] + " ----> " + t.higher(a[i]));

      // Remove the current element from the set
      t.remove(a[i]);
    }

  }

}

//TimeComplexcity O(NlogN)





























/*
Given an array of integers, replace every element with the least greater
element on its right side in the array. If there are no greater element
on right side, replace it with -1.

Examples:
Input: [8, 58, 71, 18, 31, 32, 63, 92,
         43, 3, 91, 93, 25, 80, 28]
Output: [18, 63, 80, 25, 32, 43, 80, 93,
         80, 25, 93, -1, 28, -1, -1]
*/