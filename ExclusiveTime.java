class ExclusiveTime {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(n == 0) return new int[] {};
        Stack<Integer> s = new Stack<>();   // Stores id of function.
        int prev = 0;
        int[] result = new int[n];  // Time for each function.
        for(String log: logs) {
            String[] splitArray = log.split(":");
            int curr = Integer.parseInt(splitArray[2]);     // String to int conversion of timestamp.
            if(splitArray[1].equals("start")) {
                if(!s.isEmpty()) {
                    int prev_id = s.peek();
                    result[prev_id] += curr - prev; 
                }
                s.push(Integer.parseInt(splitArray[0]));
                prev = curr;
            }
            else {
                int prev_id = s.pop();
                result[prev_id] += (curr + 1) - prev;
                prev = curr + 1;
            }
        }
        return result;
    }
}