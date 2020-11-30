class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Arrays.fill(result,-1);
        HashMap<Integer,Integer> hmap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i= 0 ; i< nums1.length ; i++){
            hmap.put(nums1[i],i);
        }
        for(int j = 0; j<nums2.length ; j++){
            while(!stack.isEmpty() && nums2[j]>nums2[stack.peek()] && hmap.containsKey(nums2[stack.peek()]))            {
                result[hmap.get(nums2[stack.pop()])] = nums2[j];
            }
            stack.push(j);
        }
        
        return result;
    }
}