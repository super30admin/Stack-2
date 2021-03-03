// TC: O(2N), N -> size of logs list
// SC: O(N/2), N -> size of logs list
// Did it successfully run on Leetcode? : Yes
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        if ( logs == null || logs.size() == 0)
            return result;
        Stack<Integer> stack = new Stack();
        int prev = 0;
        for (String log : logs)
        {
            String[] str = log.split(":");
            int curr = Integer.parseInt(str[2]);
            if (str[1].equals("start"))
            {
              if (!stack.isEmpty())
              {
                result[stack.peek()] +=  curr - prev;
                prev = curr;
              }
              stack.push(Integer.parseInt(str[0]));
            }
            else
            {
                result[stack.pop()] += curr + 1 - prev;
                prev = curr+1;
            }
        }
        return result;
    }
}
