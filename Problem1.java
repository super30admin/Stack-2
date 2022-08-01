class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(logs == null || logs.size() == 0) {
            return new int[0];
        }
        Stack<Integer> stack = new Stack<>();

        int prev = 0;
        int current = 0;
        int[] result = new int[n];

        for(String s : logs) {
            String[] parts = s.split(":");
            current = Integer.parseInt(parts[2]);

            if(parts[1].equals("start")) {
                if(!stack.isEmpty()) {
                    result[stack.peek()] +=  current - prev;
                    prev = current;
                }
                stack.push(Integer.parseInt(parts[0]));
            } else {
                result[stack.pop()] += (current+1) - prev;
                prev = current + 1;
            }

        }
        return result;
    }
}