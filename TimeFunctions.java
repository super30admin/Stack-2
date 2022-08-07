import java.util.List;
import java.util.Stack;

//Time Complexity=O(n)
//Space Comlexity=O(1)
public class TimeFunctions {

    public int[] exclusiveTime(int n, List<String> logs) {

        Stack<Integer> st=new Stack<>();
        int prev=0;
        int[] result=new int[n];
        for(String log:logs){

            String[] str=log.split(":");
            int curr=Integer.parseInt(str[2]);

            if(str[1].equals("start")){
                if(!st.isEmpty()){
                    int prevTask=st.peek();
                    result[prevTask]+=curr-prev;
                }
                st.push(Integer.parseInt(str[0]));
                prev=curr;
            }else{
                result[st.pop()]+=curr+1-prev;
                prev=curr+1;

            }
        }
        return result;
    }
}
