// Time Complexity : O(total logs)
// Space Complexity : O(total logs)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public int[] exclusiveTime(int n, List<String> logs) {
    int[] res = new int[n];
    Stack<Integer> st = new Stack<>();
    int prevTime = 0;
    for (String str : logs) {
        String[] arr = str.split(":");
        if (!st.isEmpty()) res[st.peek()] +=  Integer.parseInt(arr[2]) - prevTime; 
        prevTime = Integer.parseInt(arr[2]);
        if (arr[1].equals("start")) st.push(Integer.parseInt(arr[0]));
        else {
            res[st.pop()]++;
            prevTime++;
        }
    }
    return res;
}
