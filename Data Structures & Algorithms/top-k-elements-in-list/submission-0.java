class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        //step-1 count the freq and store in map
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        //step-2 creat min heap ordered by frequency
        Queue<Integer> heap = new PriorityQueue<>(
            (a,b) -> Integer.compare(map.get(a),map.get(b))
        );
        
        // step-3 keep only to k most frequent numbers in heap
        for(int num : map.keySet()){
            heap.offer(num);

            if(heap.size() > k){
                heap.poll();
            }
        }
        //step-4 extract k elements
        int[] res = new int[k];
        for(int i=0; i<k; i++){
            res[i] = heap.poll();
        }
        return res;


        /*
        Interview-ready explanation
"I create a PriorityQueue with a comparator that compares the frequencies of the numbers using the frequency map. Since the comparator orders elements by ascending frequency, the least frequent element is at the head. I iterate through the distinct numbers, insert each into the heap, and whenever its size exceeds k, remove the least frequent element. This keeps only the k most frequent elements in the heap."

Remember: The heap stores the numbers, but the comparator uses their frequencies to determine their priority.
*/
    }
}
