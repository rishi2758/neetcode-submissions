class MedianFinder {

    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        // 2 3
        // 2 1
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());

        int n = maxHeap.size() + minHeap.size();
        int expMinHeapSz = n / 2;

        while (minHeap.size() > expMinHeapSz) {
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        return maxHeap.size() > minHeap.size() ? maxHeap.peek() : (minHeap.peek() + maxHeap.peek()) / 2.0;
    }
}
