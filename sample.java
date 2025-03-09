// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class sample{
    /*****************PROBLEM-1***************/
//TC:0(M) M=no.of logs
//SC:0(M)
    class Solution {
        public int[] exclusiveTime(int n, List<String> logs) {
            if(logs==null || logs.size()==0){
                return new int[]{};
            }
            int[] result=new int[n];
            int curr=0,prev=0;
            Stack<Integer> s=new Stack<>();
            for(String log:logs){
                String[] strArray=log.split(":");
                curr=Integer.parseInt(strArray[2]);
                if(strArray[1].equals("start")){
                    if(!s.isEmpty()){
                        result[s.peek()]+=curr-prev;
                    }
                    s.push(Integer.parseInt(strArray[0]));
                    prev=curr;
                }else{
                    result[s.pop()]+=curr-prev+1;
                    prev=curr+1;
                }

            }
            return result;
        }
    }

    /*********************problem-2****************/
    
}
