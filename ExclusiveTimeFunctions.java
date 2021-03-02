class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] arr = new int[n];
        Stack<Integer> tstack = new Stack<>();
        int last = 0;
        for(String s:logs){
            //Split the string into 3 parts to get the type of function call: start/end, number of the function being called and the time at which it is called
            String[] p = s.split(":");
            int num = Integer.parseInt(p[0]);
            String type = p[1];
            int time = Integer.parseInt(p[2]);
            //if the function call type is end, then add the (currtime - lasttime + 1 + already spent time by this function call) value to solution array and update the last value
            if(type.equals("end")){
                arr[num] += time - last + 1 + tstack.pop();
                last = time+1;
            }
            else{
                //if function call type is start and stack is not empty then update the time spent on the previous function call, in the next step add this element into the stack with initial time spent value equal to 0 and update the last value;
                if(!tstack.isEmpty()){
                    int k = tstack.pop();
                    k = k+time-last;
                    tstack.push(k);
                }
                tstack.push(0);
                last = time;
            }
        }
        return arr;
    }
}

//Time complexity : O(N) 
//Space complexity : O(N/2) at max in the stack there can be all the start values for functions.
