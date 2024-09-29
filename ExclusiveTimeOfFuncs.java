public class ExclusiveTimeOfFuncs {

  // TC: O(n)
  // SC: O(n)
  // works on leetcode

  public int[] exclusiveTime(int n, List<String> logs) {
    // the idea is to have a stack that holds the current running process
    // and store corresponding time in result array

    /*
     * i am getting stuck at the fact that when we are given the start time
     * it is considered as a unit of 1
     * if you get this the rest of the problem solves itself
     **
     * find the pattern in the question
     *
     * thus, when we have a process with start and end given we need to calculate as
     * it is current - prev + 1
     *
     * else if another process starts to execute halting the previous one it becomes
     * current - prev
     */

    /*
         


         */

    // to maintain the previous unit of time for the process on top of the stack
    int[] result = new int[n];

    int prev = 0;
    int curr = 0;

    Stack<Integer> st = new Stack<>();

    // i did not know this part, how to work with list of strings
    for (String log : logs) {
      String[] record = log.split(":");

      // current time coming from each record
      curr = Integer.parseInt(record[2]);

      // we check for start or end
      /**********************/
      // keep repeating equals mistake with string
      /*********************/
      if (record[1].equals("start")) {
        //check that there is nothing in the stack -- to stop previous process
        if (!st.isEmpty()) {
          result[st.peek()] = result[st.peek()] + (curr - prev);
        }

        st.push(Integer.parseInt(record[0]));
        prev = curr;
      } else {
        // st.peek() has to be equal to record[0]
        result[st.peek()] += curr - prev + 1;
        st.pop();

        prev = curr + 1;
        // should i be popping in case of recurssive call?
        // yes cause we aren't checking at start if we are adding a similar number to stack

      }
    }

    return result;
  }
}
