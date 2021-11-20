package main.FAANG.CompanySpecific;

//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/discuss/256729/JavaC%2B%2BPython-Binary-Search

public class CapacityToShipPackagesWithinDDays {

    public static void main(String[] args) {

        int[] weights={12, 34, 67, 90};
        int days=2;
        System.out.println(shipWithinDays(weights,days));
    }

    public static int shipWithinDays(int[] weights, int D) {
        int left = 0, right = 0;
        for (int w: weights) {
            left = Math.max(left, w);
            right += w;
        }
        while (left < right) {
            int mid = (left + right) / 2, need = 1, cur = 0;
            for (int w: weights) {
                if (cur + w > mid) {
                    need += 1;
                    cur = 0;
                }
                cur += w;
            }
            if (need > D) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    //Explanation of this solution:
    //
    //The key is left = max(weights), right = sum(weights),
    //which are the minimum and maximum possible weight capacity of the ship.
    //
    //Therefore the question becomes Binary Search to find the minimum weight capacity of the ship between left and right.
    //We start from
    //mid = (left + right) / 2 as our current weight capacity of the ship.
    //need = days needed == 1
    //cur = current cargo in the ship == 0
    //
    //Start put cargo into ship in order.
    //when need > D, it means the current ship is too small, we modify left = mid + 1 and continue
    //If all the cargo is successfully put into ships, we might have a chance to find a smaller ship, so let right = mid and continue.
    //Finally, when our left == right, we reach our answer
}
