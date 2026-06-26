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
            if(pq.size() > k) {
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size() > k) {
            pq.poll();
        }

        return pq.peek();
    }
}
