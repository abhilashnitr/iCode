package main.FAANG.GraphUtils;

import java.util.*;

//The lock initially starts at '0000', a string representing the state of the 4 wheels.
//
//You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.
//
//Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.
public class OpenTheLock {
//Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
//Output: 6
//Explanation:
//A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
//Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
//because the wheels of the lock become stuck after the display becomes the dead end "0102".

    public int openLock(String[] deadends, String target) {

        // BFS because we want to find the minimum numbers of times switching!

        if (target == "0000")
            return 0;

        Set<String> visited = new HashSet<>(Arrays.asList(deadends)); // don't revisit locations! and let's add all of the deadends to our visited hashset

        if (visited.contains("0000"))
            return -1;

        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        visited.add("0000");

        int cnt = 0;
        while (!q.isEmpty()) {

            int len = q.size();

            while (len > 0) {
                String curr = q.poll();

                for (int i = 0; i < 4; i++) {
                    // add both up and down!
                    char c = curr.charAt(i);

                    // the - 0 converts the character to an int so math can be performed, once the numbers are added they get converted back to a string! -- clean code inspired by top voted answer
                    String up = curr.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + curr.substring(i + 1);
                    String dwn = curr.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + curr.substring(i + 1);

                    if (up.equals(target) || dwn.equals(target))
                        return cnt + 1;
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    if (!visited.contains(dwn)) {
                        q.offer(dwn);
                        visited.add(dwn);
                    }
                }
                len--;
            }
            cnt++;
        }
        return -1;
    }


    private static final String START = "0000";

    public int openLock2(String[] deadends, String target) {
        if (target == null || target.length() == 0) return -1;
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        Queue<String> queue = new LinkedList<>();
        int level = 0;
        queue.offer(START);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentLock = queue.poll();
                if (!visited.add(currentLock)) continue;
                if (currentLock.equals(target)) return level;

                for (String nextLock : getNextStates(currentLock)) {
                    if (!visited.contains(nextLock)) queue.offer(nextLock);
                }
            }
            level++;
        }

        return -1;
    }

    private List<String> getNextStates(String lock) {
        List<String> locks = new LinkedList<>();
        char[] arr = lock.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            arr[i] = c == '9' ? '0' : (char) (c + ((char) 1));
            locks.add(String.valueOf(arr));
            arr[i] = c == '0' ? '9' : (char) (c - ((char) 1));
            locks.add(String.valueOf(arr));
            arr[i] = c;
        }
        return locks;
    }
}
