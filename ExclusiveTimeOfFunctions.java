//Time : O(n)
//Space: O(n)
public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(logs == null) return new int[0];
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        int lastTimeStamp=0;
        for(String log: logs){
            String[] strArr = log.split(":");
            int currTask = Integer.parseInt(strArr[0]);
            int currTaskStart = Integer.parseInt(strArr[2]);
            if(strArr[1].equals("start")){
                if(!st.empty()){
                    int prevTask = st.peek();
                    result[prevTask] += currTaskStart - lastTimeStamp;
                }
                st.push(currTask);
                lastTimeStamp = currTaskStart;
            }
            else{
                result[st.pop()] += currTaskStart + 1 - lastTimeStamp;
                lastTimeStamp = currTaskStart+ 1;
            }
        }
        return result;
    }
}
