// TC => O(n)
// SC => O(n)
public class Solution {
    public int[] ExclusiveTime(int n, IList<string> logs) {
        if(logs == null || logs.Count == 0 || n == 0){
            return null;
        }

        Stack<int> stack = new Stack<int>();
        int[] result = new int[n];
        int prev = 0, curr = 0;

        foreach(var log in logs){
            var arr = log.Split(":");
            curr = Convert.ToInt32(arr[2]);
            if(arr[1] == "start"){
                if(stack.Count > 0){
                    result[stack.Peek()] += curr - prev;
                }
                stack.Push(Convert.ToInt32(arr[0]));
                prev = curr;
            }
            else{
                result[stack.Pop()] += curr - prev + 1;
                prev = curr + 1;
            }
        }
        return result;
    }
}