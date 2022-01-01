class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int time = Integer.MIN_VALUE;
        Stack<Integer> start = new Stack<>();
        Stack<Integer> ids = new Stack<>();
        int totTimes[] = new int[n];
        int id, ts;

        int lastPop = 0;
        for(String s:logs){
            String[] spl = s.split(":");
            id = Integer.parseInt(spl[0]);
            ts = Integer.parseInt(spl[2]);
            if(time == Integer.MIN_VALUE)
                time = ts;

            if(spl[1].length()==5){
                if(!start.isEmpty())
                    totTimes[ids.peek()] += ts - lastPop;
                start.push(ts);
                ids.push(id);
                lastPop = ts;
            }

            else{
                totTimes[id] += ts - lastPop+1;
                start.pop();
                ids.pop();
                lastPop = ts+1;
            }
        }
        return totTimes;

    }
}