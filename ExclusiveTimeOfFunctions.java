// TC: O(n)
// SC: O(n)
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(logs == null || logs.size() == 0) {
            return new int[]{};
        }
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        int prev, curr;
        prev = 0;
        for(String log : logs) {
            String[] l = log.split(":");
            curr = Integer.parseInt(l[2]);

            if(l[1].equals("start")) {
                if(!s.isEmpty()) {
                    res[s.peek()] += curr - prev;
                }
                s.push(Integer.parseInt(l[0]));
                prev = curr;
            } else {
                res[s.pop()] += curr + 1 - prev;
                prev = curr + 1;
            }
        }
        return res;
    }
}