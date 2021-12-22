class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        int res[] = new int[n];
        
        Stack<Integer> st = new Stack();
        if(logs == null || logs.size() == 0) return res;
        String[] func = logs.get(0).split(":");
        st.push(Integer.parseInt(func[0]));
        int time = Integer.parseInt(func[2]);
        
        for(int i = 0; i < logs.size(); i++) {
            
            func = logs.get(i).split(":");
            if(func[1].indexOf("start") != -1) {
                if(st != null                                           ) {
                    res[st.peek()] += Integer.parseInt(func[2])-time;
                    st.push(Integer.parseInt(func[0]));
                    time = Integer.parseInt(func[2]);
                }
                
            }else{
                    res[st.peek()] += Integer.parseInt(func[2])-time+1;
                    st.pop();
                    time =  Integer.parseInt(func[2])+1;
                }
        }
        
        return res;
        
    }
}
