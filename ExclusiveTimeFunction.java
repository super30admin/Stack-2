//Time Complexity: O(n)
//Space Complexity: O(n)
public class ExclusiveTimeFunction {
    public int[] exclusiveTime(int n, List<String> logs)
    {
        if(logs == null || logs.size() == 0)
            return new int[]{};

        int result[] = new int[n];
        Stack<Integer> st = new Stack<>();
        int prev = 0;
        for(String log : logs)
        {
            // get all vals from string
            String [] arr = log.split(":");
            
            int curr = Integer.parseInt(arr[2]);

            if(arr[1].equals("start"))
            {
                // compute how long earlier process ran
                if(!st.isEmpty()) // first task will not have earlier process
                {
                    result[st.peek()] = curr - prev;
                }
                // update old timestamp
                prev = curr;
                // new function
                int fid = Integer.parseInt(arr[0]);
                st.push(fid);
            }
            else if(arr[1].equals("end")) 
            {
                // update run time for earlier process and since end we can pop
                int fid = st.pop();
                result[fid] += curr + 1 - prev; // need 1 for current timestamp
                prev = curr + 1; // add single unit timestamp as 1
            }
        }
        return result;
    }
}
