// Time Complexity : O(size of logs)
// Space Complexity : O(n) no of tasks
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nopes

class SolutionTwo {
    public int[] exclusiveTime(int n, List<String> logs) {

        if(logs==null || logs.size()==0)
            return new int [0];

        int[] result = new int[n];

        int prev = 0;

        Stack<Integer> stack = new Stack();

        for(String log:logs)
        {
            String[] splitLog = log.split(":");

            int curr = Integer.parseInt(splitLog[2]);

            if(splitLog[1].equals("start"))
            {
                if(!stack.isEmpty())
                {
                    result[stack.peek()] += curr - prev;
                    prev = curr;
                }
                stack.push(Integer.parseInt(splitLog[0]));
            }
            else
            {
                result[stack.pop()] += curr - prev + 1;
                prev = curr + 1;
            }
        }

        return result;
    }
}