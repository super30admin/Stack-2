
/*
Time: O(n) where n = logs.size() 
Space: O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/class ExclusiveTimeofFunction {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        if( n == 0 ) return new int[] {};
        int[] result = new int[n];
        Stack<Integer> s = new Stack<>();
        int prev = 0 ;
        for( String log : logs){
            String[] strArray = log.split(":");
            int curr = Integer.parseInt(strArray[2]);
            if(strArray[1].equals("start")){
            if(!s.isEmpty()){
                result[s.peek()] += curr - prev ;
                prev = curr ;
            }
            s.push(Integer.parseInt(strArray[0]));
        }
        else{
            result[s.pop()] += curr - prev + 1;
            prev = curr + 1 ;
        }
        
    }
    return result ;
}
}