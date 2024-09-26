// Time complexity - 0(n)
// space complexity - 0(n)
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
          Stack<Integer> st = new Stack<>();
          int prev =0;
          int [] result = new int[n];
          for(String log:logs){
              String [] arr = log.split(":");
              int curr = Integer.parseInt(arr[2]);
              // case 1: (Start)
              if(arr[1].equals("start")){
              if(!st.isEmpty()){
                  result[st.peek()] += curr-prev;  
              }
              st.push(Integer.parseInt(arr[0]));
              prev = curr;
          } else {
              result [st.pop()] += curr - prev +1; // because of exculsive and inclusive
              prev = curr +1;
          }   
    }
           return result;
    }
}