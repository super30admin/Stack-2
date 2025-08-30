class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(n == 0){
            return new int[]{};
        }

        Stack<Integer>bucket = new Stack<>();
        int[] result = new int[n];
        int prev = 0;
        int curr = 0;
        for(String log : logs){
            String[] strArray = log.split(":");
            curr = Integer.parseInt(strArray[2]);
            if(strArray[1].equals("start")){
                
                if(!bucket.isEmpty()){
                    result[bucket.peek()] += curr-prev;
                }

                bucket.push(Integer.parseInt(strArray[0]));
                prev = curr;
            }

            else{
                result[bucket.pop()] += curr-prev+1;
                prev = curr +1;
            }
        }
        return result;
    }
}
