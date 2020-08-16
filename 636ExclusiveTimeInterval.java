class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
		 int[] result = new int[n];
       if(logs == null || logs.size()== 0 ) return result;
        
        Stack<Integer> st = new Stack<>();
        int prev = 0 ;
       
        for(String log : logs){
            String[] strArr = log.split(":"); // [1: start:2]
			int curr = Integer.parseInt(strArr[2]);
            if(strArr[1].equals("start")){
                
                if(!st.isEmpty()){
                    result[st.peek()]+= curr-prev;
                }
                st.push(Integer.parseInt(strArr[0]));
                prev = curr;
            }
        
            else //end case
            {
                result[st.pop()]+= curr - prev + 1;
                prev = curr + 1; // +1 because one entire interval is processed completely for end
            }
        }
        return result;
    }
            
         
}

/*
Approach : Start interval calculated as curr-prev and reset prev = curr 
           End interval calculated as curr-prev+1 and reset prev = curr+1 
           For start functions push in  stack & place in resultant array location
           For end  functions pop from stack and place in resultant array 
Time complexity : O(n)
Space complexity:O(n)
*/