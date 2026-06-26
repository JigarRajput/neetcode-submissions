// Jai Ganesh
// import java.collections.*;

class KthLargest {

    PriorityQueue<Integer> pq;
    Iterator it;
    int k = 0;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<Integer>();
        this.k = k;

        for(int num: nums) {
            pq.add(num);
        }
    }
    
    public int add(int val) {
        while(pq.size() >= k) {
            pq.poll();
        }

        pq.offer(val);

        return pq.peek();
    }
}
