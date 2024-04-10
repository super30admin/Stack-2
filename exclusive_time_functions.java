
//TimeComplexity: O(length of logs)
//space Complexity : O(n)
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int []result = new int[n];
        int previous = 0;
        Stack<Integer> stack = new Stack<>();
        for(String log : logs) {
            String []array = log.split(":");
            int currentTask = Integer.parseInt(array[0]);
            int currentTime = Integer.parseInt(array[2]);
            if(array[1].equals("start")) {
                if(!stack.isEmpty()) {
                    result[stack.peek()] = result[stack.peek()] + currentTime-previous;
                }
                previous = currentTime;
                stack.push(currentTask);
            } else {
                result[stack.pop()] += currentTime+1 - previous;
                previous = currentTime+1;
            }
            
        }

        return result;
    }
}