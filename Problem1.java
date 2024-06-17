package Stack-2;
// TC: O(n)
// SC : O(tasks)
public class Problem1 {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        int prevTime=0;
        for(String log: logs){
            String[] eachLog = log.split(":");
            int task = Integer.parseInt(eachLog[0]);
            int currTime = Integer.parseInt(eachLog[2]);
            String op = eachLog[1];
            if(op.equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()]+=currTime-prevTime;
                }
                st.push(task);
                prevTime=currTime;
            }
            else{
                currTime+=1;
                result[st.pop()]+=currTime-prevTime;
                prevTime=currTime;
            }
            
        }

        return result;
    }
}
