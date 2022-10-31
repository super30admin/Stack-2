//Time  O(N)
//Space O(N/2)
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<Integer> funcStack = new ArrayDeque<>();
        int [] ans = new int [n];
        int prevTimeStamp = 0;
        for(String log : logs){
            String [] logSplit = log.split(":");
            int funcID = Integer.valueOf(logSplit[0]);
            int timeStamp = Integer.valueOf(logSplit[2]);
            if(logSplit[1].equals("start")){
                if(!funcStack.isEmpty())
                    ans[funcStack.peek()] += timeStamp - prevTimeStamp;
                funcStack.push(funcID);
                prevTimeStamp = timeStamp;
            }
            else{
                ans[funcStack.pop()] += timeStamp - prevTimeStamp + 1;
                prevTimeStamp = timeStamp + 1;
            }
        }
        return ans;
    }
}