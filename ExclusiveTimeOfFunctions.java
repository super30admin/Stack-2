//  Time Complexity : O(n) --> where n is the length df input logs list
//  Space Complexity : O(n)

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        if(logs == null || logs.size() == 0) return result;
        Stack<Integer> st = new Stack<>();
        int prev = 0;
        for(String log: logs){
            String[] strArr = log.split(":");   // ["1", "start", "2"]
            int curr = Integer.parseInt(strArr[2]); // 2
            if(strArr[1].equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()] += curr - prev;
                }
                st.push(Integer.parseInt(strArr[0]));
                prev = curr;
            }
            else{ // "end" case
                result[st.pop()] += curr - prev + 1;
                prev = curr+1;
            }

        }
        return result;
    }
}
