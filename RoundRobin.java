import java.util.*;

public class RoundRobin {
    class Node {
        int startTime;
        int burstTime;
        int leftExcTime = 0;
        Node(int s, int b) {
            startTime = s;
            burstTime = b;
            leftExcTime = b;
        }
        Node(int s, int b, int l) {
            startTime = s;
            burstTime = b;
            leftExcTime = l;
        }
    }
    public int average (int[] arr, int[] bur, int unit) {
        if (arr == null || bur == null || arr.length == 0 || bur.length == 0) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<Node>();

        int timeStep = 0;
        int index = 0;
        int waitTime = 0;
        while (true) {
            //add node to waiting queue
            while (index < arr.length && arr[index] <= timeStep) {
                queue.add(new Node(arr[index], bur[index]));
                index++;
            }
            Node cur = queue.poll();
            if (cur != null) {
                if (cur.leftExcTime > unit) {
                    timeStep += unit;
                    //add new arrival into waiting queue first,
                    while (index < arr.length && arr[index] <= timeStep) {
                        queue.add(new Node(arr[index], bur[index]));
                        index++;
                    }
                    //then add "current" task back
                    queue.add(new Node(cur.startTime, cur.burstTime, cur.leftExcTime - unit));
                } else{
                    timeStep += cur.leftExcTime;
                    waitTime += timeStep - cur.startTime - cur.burstTime;
                }
            }else{
                timeStep++;
            }
            
            if (index >= arr.length && queue.isEmpty()) {
                break;
            }
        }
        return waitTime / arr.length;
    }
    public static void main(String[] args) {
        int[] arr = {0,2,4,5};
        int[] bur = {7,4,1,4};
        RoundRobin test = new RoundRobin();
        System.out.println(test.average(arr, bur, 3));
        
    }
}