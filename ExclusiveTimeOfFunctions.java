class ExclusiveTimeOfFunctions {
    
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    
    class Pair {
        int id, startTime, prevTime;
        
        public Pair(int id, int startTime, int prevTime){
            this.id = id;
            this.startTime = startTime;
            this.prevTime = prevTime;
        }
    }
    
    public int[] exclusiveTime(int n, List<String> logs) {
        // Edge Case Checking
        if(n < 1 || logs.size() < 1)
            return new int[]{-1};
        
        int[] result = new int[n];
        Stack<Pair> stack = new Stack<>();
        
        for(String s : logs){
            String[] arr = s.split(":");
            
            /*
                For a start operation:
                we calculate the previous computed time if any - (currTime - startTime of previously pushed pair in stack)
                Push to the stack - (id, currTime, prevTime)
            */
            if(arr[1].equals("start")){
                // If stack is empty - then we directly push prevTime as 0
                if(stack.isEmpty()){
                    int id = Integer.parseInt(arr[0]);
                    int currTime = Integer.parseInt(arr[2]);
                    stack.push(new Pair(id, currTime, 0));
                }else{
                    Pair p = stack.pop();
                    int id = Integer.parseInt(arr[0]);
                    int currTime = Integer.parseInt(arr[2]);
                    p.prevTime += currTime - p.startTime;
                    stack.push(p);
                    stack.push(new Pair(id, currTime, 0));
                }
            }
            /*
                For end operation:
                we calculate the total computed time for that id --> currTime - startTime + prevTime + 1
                and add this computed time to the result array of that id.
                
                if stack is not empty --> we update the previously pushed Pair's startTime ==> currTime + 1
            */
            else{
                Pair p = stack.pop();
                int id = Integer.parseInt(arr[0]);
                int currTime = Integer.parseInt(arr[2]);
                result[id] += currTime - p.startTime + p.prevTime + 1;
                if(!stack.isEmpty()){
                    Pair t = stack.pop();
                    t.startTime = currTime+1;
                    stack.push(t);
                }
            }
        }
        return result;
    }
}