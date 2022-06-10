//TC : O(max(m,n)) where m in total numer of logs and n is total no of functions
//SC : O(m)
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(logs==null||logs.size()==0) return new int[] {};

        int curr = 0;
        int prev = 0;
        Stack <Integer> s = new Stack<>();
        int[] result = new int[n];
        for(int i=0;i<logs.size();i++)
        {
            String[] log = logs.get(i).split(":");
            if(log[1].equals("start"))
            {
                curr= Integer.parseInt(log[2]);
                if(!s.isEmpty())
                {
                    result[s.peek()] += curr - prev;
                }
                s.add(Integer.parseInt(log[0]));
                prev = curr;
            }
            else
            {
                if(s.peek() == Integer.parseInt(log[0]))
                {
                    curr = Integer.parseInt(log[2]);
                    result[s.pop()] += curr+1 - prev;
                    prev = curr+1;
                }
            }
        }
        return result;
    }
}