//T.C=  O(max(N,M))
//S.C= O(N)
class Solution {
       public int[] exclusiveTime(int n, List<String> logs) {
       if(n==0)return new int[]{};
       Stack<Integer>s=new Stack<>();
           int prev=0;
           int[] result=new int[n];
           for(String log:logs){
               //split the log string
               String[] splitArray=log.split(":");
               int curr=Integer.parseInt(splitArray[2]);
               if(splitArray[1].equals("start")){
                   if(!s.isEmpty()){
                       result[s.peek()]=result[s.peek()]+curr-prev;
                   }        
                   s.push(Integer.parseInt(splitArray[0]));
                   prev=curr;
                   
               }else{
                   result[s.pop()]+=curr-prev+1;
                   prev=curr+1;
               }
               
           }
       return result;
    }
}
