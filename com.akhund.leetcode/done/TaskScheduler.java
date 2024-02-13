package done;

import done.InsertInterval;

import java.util.HashMap;
import java.util.Map;

public class TaskScheduler {
    public static void main(String[] args) {
        char[] tasks = new char[] {'A','A','A','B','B','B'}; //{'A','A','A','A','A','A','B','C','D','E','F','G'};
        int n = 2;

        System.out.println(leastInterval(tasks, n));
    }

    public static int leastInterval(char[] tasks, int n) {

        if (n == 0)
            return tasks.length;

        int[] count = new int[26];
        int[] last = new int[26];

        for (int i = 0; i < tasks.length; i++) {
            count[tasks[i] - 'A']++;
        }


        int interval = 0;
        boolean taskExist = true;

        while (taskExist) {
            taskExist = false;
            int maxPos = -1;

            for (int i = 0; i < 26; i++) {
                if (count[i] > 0)
                    taskExist = true;
                if (maxPos == -1) {
                    if (count[i] > 0 && last[i] == 0)
                        maxPos = i;
                }
                else {
                    if (count[maxPos] < count[i] && last[i] == 0)
                        maxPos = i;
                }
            }

            if (!taskExist)
                break;

            if (maxPos >= 0) {
                count[maxPos]--;
                interval++;
                for (int i = 0; i < 26; i++)
                    last[i] = last[i] > 0 ? last[i] - 1 : 0;
                last[maxPos] = n;
            }
            else {
                interval++;
                for (int i = 0; i < 26; i++)
                    last[i] = last[i] > 0 ? last[i] - 1 : 0;
            }
        }

        return interval;
    }
}
