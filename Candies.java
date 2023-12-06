// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None 
// Your code here along with comments explaining your approach
class Candies {
    int[] result;
    public int candy(int[] ratings) {
        int n = ratings.length;
        result = new int[n];
        Arrays.fill(result,1);
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                result[i] = result[i-1]+1;
            }
        }
        int min = result[n-1];
        for(int i=n-2;i>=0;i--){
            if(ratings[i] > ratings[i+1]){
                result[i] = Math.max(result[i],result[i+1]+1);
            }
            min+=result[i];
        }
        return min;
    }
}