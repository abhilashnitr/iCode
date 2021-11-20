package main.FAANG.GraphUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class KeysAndRoom {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> dfs = new Stack<>(); dfs.add(0);
        HashSet<Integer> seen = new HashSet<Integer>(); seen.add(0);
        while (!dfs.isEmpty()) {
            int i = dfs.pop();
            for (int j : rooms.get(i))
                if (!seen.contains(j)) {
                    dfs.add(j);
                    seen.add(j);
                    if (rooms.size() == seen.size()) return true;
                }
        }
        return rooms.size() == seen.size();
    }

    public boolean canVisitAllRooms2(List<List<Integer>> rooms) {
        return dfs(rooms, 0, new HashSet<Integer>());
    }

    private boolean dfs(List<List<Integer>> rooms,
                           int key, Set<Integer> seen){
        seen.add(key);
        List<Integer> keys = rooms.get(key);
        for(int k : keys){
            if(!seen.contains(k))
                dfs(rooms, k, seen);
        }
        return seen.size()==rooms.size();
    }


    HashSet<Integer> enteredRooms = new HashSet<>();

    public boolean canVisitAllRooms3(List<List<Integer>> rooms) {
        enterRoom(0, rooms);
        return enteredRooms.size() == rooms.size();
    }

    private void enterRoom(int roomId, List<List<Integer>> rooms) {
        enteredRooms.add(roomId);
        List<Integer> keysInRoom = rooms.get(roomId);
        for (int key: keysInRoom)
            if (!enteredRooms.contains(key))
                enterRoom(key, rooms);
    }
}
