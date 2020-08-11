// Time Complexity : O(n) - where n is the length of the input
// Space Complexity : O(n) - where n is the length of the input
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, just the for each loop iteration of strings
// Your code here along with comments explaining your approach : Iterate along the strings, whenever a start is encountered end the previous one and calculate along with pushing to the stack. whenever an end is encountered, pop the stact and update the resultant array.This process is analogus to recursion.



class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result= new int[n];
        if(logs==null || logs.size()==0) return result;
        Stack<Integer> st=new Stack<>();
        int prev=0;
        for(String log: logs){
            String[] strArr=log.split(":");
            int curr=Integer.parseInt(strArr[2]);
            int index =Integer.parseInt(strArr[0]);
            if(strArr[1].equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()]+= curr-prev;
                }
                st.push(index);
                prev=curr;
                
            }
            else{  //end case
               result[st.pop()]+= curr-prev+1; 
               prev=curr+1;
            }
        }
        return result;
    }
}