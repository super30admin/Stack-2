class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(n == 0) {
            return new int[] {};
        }
        int curr = 0;
        int prev = 0;
        Stack<Integer> s = new Stack<>();
        int[] result = new int[n];
        for(String log: logs) {
            String[] strArray = log.split(":");
            curr = Integer.parseInt(strArray[2]);
            if(strArray[1].equals("start")) {
                if(!s.isEmpty()) {
                    result[s.peek()] += curr - prev;
                }
                s.push(Integer.parseInt(strArray[0]));
                prev = curr;
            } else {
                result[s.pop()] += curr + 1 - prev;
                prev = curr + 1;
            }
        }
        return result;
    }
}
