// TC: O(n)
// SC: O(n)
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(logs == null || logs.size() == 0) {
            return new int[] {};
        }
        int[] result = new int[n];
        Stack<Integer> s = new Stack<>();
        int prev = 0;
        for(String log : logs) {
            String[] splitLog = log.split(":");
            int id = Integer.parseInt(splitLog[0]);
            int time = Integer.parseInt(splitLog[2]);
            if(splitLog[1].equals("start")) {
                if(!s.isEmpty()) {
                    result[s.peek()] += time - prev;
                }
                prev = time;
                s.push(id);
            } else {
                result[s.pop()] += time + 1 - prev;
                prev = time + 1;
            }
        }
        return result;
    }
}