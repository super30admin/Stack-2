//Time -> O(n)
//Space -> O(n)
public class Problem1 {
        public int[] exclusiveTime(int n, List<String> logs) {
            if(logs == null)
                return new int[0];
            int curr = 0; 
            int prev = 0; 
            Stack<Integer> st = new Stack<>();
            int result[] = new int[n];
            for(String log: logs){
                String strArr[] = log.split(":");
                curr = Integer.parseInt(strArr[2]);
                if(strArr[1].equals("start")){
                    if(!st.isEmpty())
                        result[st.peek()] += curr - prev;
                    st.push(Integer.parseInt(strArr[0]));
                    prev = curr;
                }
                else{
                    result[st.pop()] += curr + 1 - prev; 
                    prev = curr + 1;
                }
            }
            return result;
        }
    }

