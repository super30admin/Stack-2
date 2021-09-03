
//TC: O(N)
//SC: O(N)
//N is the numebr of uniques ids

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(logs==null || logs.size()==0)
            return new int[]{};
        Stack<Integer> stack=new Stack<>();
        int[] res=new int[n];
        String first[] = logs.get(0).split(":");
        int prev=Integer.parseInt(first[2]),cur=0;
        stack.push(Integer.parseInt(first[0]));
        for(int i=1;i<logs.size();i++){
            String[] curLog = logs.get(i).split(":");
            //start
            cur=Integer.parseInt(curLog[2]); //current timestamp
            if(curLog[1].equals("start")){
                if(!stack.isEmpty()){
                    res[stack.peek()]+=cur-prev;
                }
                prev=cur;
                stack.push(Integer.parseInt(curLog[0]));
            }
            //end
            else{
                res[stack.pop()]+=(cur+1)-prev;
                prev=cur+1;
            }
        }
        return res;
    }
}