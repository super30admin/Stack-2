// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        // checking left rating
        for(int i=1;i<n;i++) {
            if(ratings[i] > ratings[i-1]) res[i] = Math.max(res[i-1]+1, res[i]);
        }
        // checing right rating
        for(int i=n-2;i>=0;i--) {
            if(ratings[i] > ratings[i+1]) res[i] = Math.max(res[i+1]+1, res[i]);
        }

        int result = 0;
        // summing up all the result values
        for(int i=0;i<n;i++)
            result += res[i];

        return result;
    }
}