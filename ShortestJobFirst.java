import java.util.*;

public class ShortestJobFirst {
    class Node {
        int startTime;
        int burstTime;
        Node(int s, int b) {
            startTime = s;
            burstTime = b;
        }
    }

    public int average(int[] arr, int[] bur) {
        if (arr == null || bur == null || arr.length == 0 || bur.length == 0) {
            return 0;
        }
        //use PriorityQueue to get shortest job
        PriorityQueue<Node> queue = new PriorityQueue<Node>(arr.length, new Comparator<Node>(){
            @Override
            public int compare(Node n1, Node n2) {
                return n1.burstTime - n2.burstTime;
            }
        });
        
        int timeStep = 0;
        int index = 0;
        int excTime = 0;
        int waitTime = 0;


        while(true) {
            while(index < arr.length && arr[index] <= timeStep) {
                queue.add(new Node(arr[index], bur[index]));
                index++;
            }
            
            Node cur = queue.poll();
            if (cur != null) {
                waitTime += timeStep - cur.startTime;
                excTime = cur.burstTime;
                timeStep += excTime;
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
        int[] arrival = {0, 2, 4, 5};
        int[] burst = {7, 4, 1, 4};
        ShortestJobFirst test = new ShortestJobFirst();
        int res = test.average(arrival, burst);
        System.out.println(res);
    }
}