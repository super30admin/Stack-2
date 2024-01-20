// Time Complexity :  O(N)
// Space Complexity : O(N/2)
// Did this code successfully run on Leetcode :Yes

import java.util.List;
import java.util.Stack;

public class TimeFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
      Stack<String[]> stack = new Stack<String[]>();
      int[] result = new int[n];
      int prevTime=0;
      for(int i=0; i<logs.size(); i++){
        String[] words = logs.get(i).split(":", -1);
        if(words[1].equals("start")){

          if(!stack.empty()) result[Integer.parseInt(stack.peek()[0])] += Integer.parseInt(words[2])-prevTime;
          prevTime= Integer.parseInt(words[2]);
          stack.push(words);
        }
        else {

          result[Integer.parseInt(stack.peek()[0])] += Integer.parseInt(words[2])+1-prevTime;
          stack.pop();
          prevTime=Integer.parseInt(words[2])+1;
        }
      }
      return result;
    }
  }
