import java.util.*;

public class ShortestJobFirst {

    public int average(int[] arr, int[] bur) {
        int numberOfProcess = arr.length;
        if (arr == null || bur == null || arr.length == 0 || bur.length == 0) {
            return 0;
        }
        PriorityQueue<CPUNode> queue = new PriorityQueue<CPUNode>(numberOfProcess, new Comparator<CPUNode>(){
            @Override
            public int compare(CPUNode n1, CPUNode n2) {
                return n1.burstTime - n2.burstTime;
            }
        });
        
        int timeStep = 0;
        int index = 0;
        int excTime = 0;
        int waitTime = 0;


        while(true) {
            while(index < numberOfProcess && arr[index] <= timeStep) {
                queue.add(new CPUNode(arr[index], bur[index]));
                index++;
            }
            CPUNode cur = queue.poll();
            if (cur != null) {
                waitTime += timeStep - cur.startTime;
                excTime = cur.burstTime;
                System.out.println(excTime);
                timeStep += excTime;
            }else{
                timeStep++;
            }
            if (index >= numberOfProcess && queue.isEmpty()) {
                break;
            }
        }
        return waitTime / numberOfProcess;

    }
    
    public static void main(String[] args) {
        int[] arrival = {0, 2, 4, 5};
        int[] burst = {7, 4, 1, 4};
        ShortestJobFirst test = new ShortestJobFirst();
        int res = test.average(arrival, burst);
        System.out.println(res);
    }
}