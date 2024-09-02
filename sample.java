// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack=new Stack<>();
        int cur=0;
        int prev=0;
        for(String l:logs){
            String[] str=l.split(":");
            int preTask=Integer.parseInt(str[0]);
            cur=Integer.parseInt(str[2]);
            if(str[1].equals("start")){
                if(!stack.isEmpty()){
                    res[stack.peek()]+=cur-prev;
                }
                stack.push(preTask);
                prev=cur;
            }
            else{
                res[stack.pop()]+=cur+1-prev;
                prev=cur+1;
            }
        }
        return res;
    }
}
// T.C=O(n)
// S.C=O(n)
class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int[] res=new int[n];
        for(int i=0;i<n;i++)
            res[i]=1;
        for(int i=1;i<n;i++)
        {
            if(ratings[i]>ratings[i-1])
                res[i]=res[i-1]+1;
        }
        
        int total=res[n-1];
        for(int i=n-2;i>=0;i--)
        {
            if(ratings[i]>ratings[i+1])
                res[i]=Math.max(res[i],res[i+1]+1);
        total+=res[i];
        }
        return total;
    }
}
// T.C=O(2n)
// S.C=O(n)