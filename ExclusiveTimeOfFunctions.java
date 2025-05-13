import java.util.List;

//TC: O(m), m=no of logs
//SC: O(m)
class ExclusiveTimeOfFunctions {
  public int[] exclusiveTime(int n, List<String> logs) {
      int[] res=new int[n];
      Stack<Integer> st=new Stack<>();
      int curr=0;
      int prev=0;
      for(int i=0;i<logs.size();i++){
          String[] strarr=logs.get(i).split(":");
          int id=Integer.parseInt(strarr[0]);
          curr=Integer.parseInt(strarr[2]);
          if(strarr[1].equals("start")){
              //startlog
              if(!st.isEmpty()){
                  res[st.peek()] += curr-prev;
              }
              st.push(id);
              prev=curr;

          }else{
              int popped=st.pop();
              res[popped] += curr-prev+1;
              prev=curr+1;
          }
      }
      return res;
  }
}