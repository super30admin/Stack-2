class Solution {
    //Time Complexity :O(n)
    //Space Complexity :O(n)

    public int[] exclusiveTime(int n, List<String> logs) {
        
        int[] res = new int[n];
        Stack<Integer> s= new Stack<>();
        int curr = 0, prev =0;
        for (String log : logs ){
            String[] strArray = log.split(":"); // 0: pID , 1: start | end , 2: time unit
            curr = Integer.parseInt(strArray[2]);
            if (strArray[1].equals( "start")){
                if (!s.isEmpty()){
                    res[s.peek()] += curr - prev; 
                }
            s.push(Integer.parseInt(strArray[0]));
            prev= curr;
            } else { //process end
                res [s.pop()] += curr - prev +1;
                prev = curr+1;
            }
           }
        return res;
    }
}
