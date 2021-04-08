package main.FAANG.GraphUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

    //Time Complexcity O(2E+V) E for building the graph and E+V for traversal
    //space O(E+2V) E+V for graph and V for container(indegree)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        Queue queue = new LinkedList();
        int count=0;

        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();

        for(int i=0; i<prerequisites.length;i++){
            degree[prerequisites[i][1]]++;
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        for(int i=0; i<degree.length;i++){
            if(degree[i] == 0){
                queue.add(i);
                count++;
            }
        }

        while(queue.size() != 0){
            int course = (int)queue.poll();
            for(int i=0; i<graph[course].size();i++){
                int pointer = (int)graph[course].get(i);
                degree[pointer]--;
                if(degree[pointer] == 0){
                    queue.add(pointer);
                    count++;
                }
            }
        }
        if(count == numCourses)
            return true;
        else
            return false;
    }


    //
    public boolean canFinishDfs(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 || prerequisites == null || prerequisites.length == 0) return true; //??

        // create the array lists to represent the courses
        List<List<Integer>> courses = new ArrayList<List<Integer>>(numCourses);
        for(int i=0; i<numCourses; i++) {
            courses.add(new ArrayList<Integer>());
        }

        // create the dependency graph
        for(int i=0; i<prerequisites.length; i++) {
            courses.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] visited = new int[numCourses];

        // dfs visit each course
        for(int i=0; i<numCourses; i++) {
            if (!dfs(i,courses, visited)) return false;
        }

        return true;
    }

    private boolean dfs(int course, List<List<Integer>> courses, int[] visited) {

        visited[course] = 1; // mark it being visited

        List<Integer> eligibleCourses = courses.get(course); // get its children

        // dfs its children
        for(int i=0; i<eligibleCourses.size(); i++) {
            int eligibleCourse = eligibleCourses.get(i).intValue();

            if(visited[eligibleCourse] == 1) return false; // has been visited while visiting its children - cycle !!!!
            if(visited[eligibleCourse]  == 0) { // not visited
                if (!dfs(eligibleCourse,courses, visited)) return false;
            }

        }

        visited[course] = 2; // mark it done visiting
        return true;

    }


    public static void main(String[] args) {

        int numCourses=4;
        int[][] prerequisites={{1,0},{2,0},{3,1},{3,2}};
        CourseSchedule courseSchedule=new CourseSchedule();
        int[] ans= courseSchedule.canFinishII(numCourses,prerequisites);
        for(int a:ans){
            System.out.print(a+" ");
        }

    }

    public int[] canFinishII(int numCourses, int[][] prerequisites) {
        int index = 0;
        int order[] = new int[numCourses];
        ArrayList[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        Queue queue = new LinkedList();
        int count=0;

        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();

        for(int i=0; i<prerequisites.length;i++){
            degree[prerequisites[i][0]]++;
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        for(int i=0; i<degree.length;i++){
            if(degree[i] == 0){
                // Add the course to the order because it has no prerequisites.
                order[index++] = i;
                queue.add(i);
            }
        }

        while(queue.size() != 0){
            int course = (int)queue.poll();
            for(int i=0; i<graph[course].size();i++){
                int pointer = (int)graph[course].get(i);
                degree[pointer]--;
                if(degree[pointer] == 0){
                    queue.add(pointer);
                    order[index++] = pointer;
                }
            }
        }
        return (index == numCourses) ? order : new int[0];
    }

    //Course Schedule II
    //additioin is to find the order of
}
