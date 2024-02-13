package todo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CourseSchedule {

    public static void main(String[] args) {
        int numCourses = 5;
        int[][] prerequisites = new int[][] {{1,4},{2,4},{3,1},{3,2}};

        System.out.println(canFinish2(numCourses, prerequisites));
    }

    public static boolean canFinish2(int numCourses, int[][] prerequisites) {
        int[] flags = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            flags[i]++;
        }

        return false;
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Boolean> courses = new HashMap<>();
        for (int i = 0; i < numCourses; i++)
            courses.put(i, true);

        for (int i = 0; i < prerequisites.length; i++) {
            courses.put(prerequisites[i][1], false);
        }

        boolean oneMoreTimes = true;
        while (oneMoreTimes) {
            oneMoreTimes = false;
            for (int i = 0; i < prerequisites.length; i++) {
                if (courses.get(prerequisites[i][0]) && !courses.get(prerequisites[i][1])) {
                    courses.put(prerequisites[i][1], true);
                    oneMoreTimes = true;
                }
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (!courses.get(i))
                return false;
        }

        return true;
    }
}
