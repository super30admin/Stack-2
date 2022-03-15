//Time Complexity: O(n)
//Space complexity: O(n)
//n is logs size;
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(logs==null || logs.size()==0)
            return new int[0];
        int []res= new int[n];
        Stack<int[]> st=new Stack<>();
        
        for(int i=0;i<logs.size();i++){
            String[] log=logs.get(i).split("\\:");
            if(log[1].equals("start")){
                int temp[]={Integer.parseInt(log[0]),Integer.parseInt(log[2])};
                st.push(temp);
        
            }else if(log[1].equals("end")){
                if(st.peek()[0]==Integer.parseInt(log[0])){
                    int [] popped=st.pop();
                    int duration=Integer.parseInt(log[2])-popped[1]+1;
                    res[popped[0]]+=duration;
                    if(!st.isEmpty())
                        res[st.peek()[0]]-=duration;
                }
            }
            // System.out.println(st);
        }
        return res;
    }
}
