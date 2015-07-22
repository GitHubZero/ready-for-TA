class CPUNode {
    int startTime;
    int burstTime;
    int leftExcTime = 0;
    CPUNode(int s, int b) {
        startTime = s;
        burstTime = b;
        leftExcTime = b;
    }
    CPUNode(int s, int b, int l) {
        startTime = s;
        burstTime = b;
        leftExcTime = l;
    }
}