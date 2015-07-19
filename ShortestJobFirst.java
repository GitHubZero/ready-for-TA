import java.util.*;

public class ShortestJobFirst {
    class Node {
        int startTime;
        int burstTime;
        public Node(int s, int b) {
            startTime = s;
            burstTime = b;
        }
    }
    
    Comparator<Node> comp = new Comparator<Node>() {
        public int compare(Node l1, Node l2){
            return l2.burstTime - l1.burstTime;
        }
    };

    public int average(int[] arr, int[] bur) {
        int numberOfProcess = arr.length;
        if (arr == null || bur == null || arr.length == 0 || bur.length == 0) {
            return 0;
        }
        PriorityQueue<Node> queue = new PriorityQueue<Node>(numberOfProcess, comp);
        
        int timeStep = 0;
        int index = 0;
        int excTime = 0;
        int waitTime = 0;


        while(true) {
            if (index < numberOfProcess) {
                if (arr[index] <= timeStep) {
                    queue.add(new Node(arr[index], bur[index]));
                    index++;
                }
            }
            Node cur = queue.poll();
            if (cur != null) {
                waitTime += timeStep - cur.startTime;
                excTime = cur.burstTime;
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