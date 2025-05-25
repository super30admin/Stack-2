/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class ExclusiveTime {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> myStack = new Stack<>();
        int prev = 0;
        for(int i=0; i<logs.size(); i++){
            String[] log = logs.get(i).split(":");
            int processId = Integer.parseInt(log[0]);
            String processType = log[1];
            int curr = Integer.parseInt(log[2]);

            if(processType.equals("start")){
                if(!myStack.isEmpty()){
                    res[myStack.peek()] += curr - prev;
                }
                myStack.add(processId);
            }
            else{
                curr = curr+1;
                res[myStack.pop()] += curr - prev;
            }
            prev = curr;
        }
        return res;
    }   
}