class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(n == 0) return new int[] {};
        
        int[] result = new int[n];
        Stack<Integer> st = new Stack();
        int prev = 0;
        for(String s : logs){
            String[] splitArray = s.split(":");
            int curr = Integer.parseInt(splitArray[2]);
            if(splitArray[1].equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()] += curr - prev;
                }
                st.push(Integer.parseInt(splitArray[0]));
                prev = curr;
            }
            else{
                result[st.pop()] += (curr + 1) - prev;
                prev = curr + 1;
            }
        }
        return result;
    }
}

//time complexity O(max(n, logs))
//space complexity O(number of logs)