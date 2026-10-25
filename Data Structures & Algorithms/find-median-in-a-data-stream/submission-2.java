class MedianFinder {

    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Comparator.reverseOrder());      
    }
    
    public void addNum(int num) {
        if (max.isEmpty()) {
            max.offer(num);
        } else if (num <= max.peek()) {
            if (max.size() > min.size()) {
                min.offer(max.poll());
            }
            max.offer(num);
        } else {
            min.offer(num);
            if (min.size() > max.size()) {
                max.offer(min.poll());
            }
        }
    }
    
    public double findMedian() {
        return min.size() == max.size() ? (min.peek() + max.peek()) / 2. : max.peek();
    }
}
