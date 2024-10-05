class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> s = new Stack<>();
        int p = 0 ;
        int[] a = new int[n];
        for(int i=0;i<logs.size();i++){
            String[] st = logs.get(i).split(":");
            int fid = Integer.parseInt(st[0]);
            String t = st[1];
            System.out.println(t);
            int time = Integer.parseInt(st[2]);
            if(t.equals("start")){
                if(!s.isEmpty()){
                    int crpeek = s.peek();
                    if(logs.get(p).split(":")[1].equals("start")){
                        a[crpeek] =  a[crpeek] + time - Integer.parseInt(logs.get(p).split(":")[2]);
                    }
                    else{
                        if((time - Integer.parseInt(logs.get(p).split(":")[2]))> 1){
                            int diff = time - Integer.parseInt(logs.get(p).split(":")[2])-1;
                            if(!s.isEmpty()){
                                System.out.println("helloworld");
                                int idx = s.peek();
                                a[idx] = a[idx] + diff;
                            }
                        }
                    }
                    

                    System.out.println(a[crpeek]);
                    s.push(fid);
                }
                else{
                    System.out.println("FIrst element");
                    System.out.println(a[fid]);
                    s.push(fid);
                }
            }
            else if(t.equals("end")){
                int crpeek = s.pop();
                if(logs.get(p).split(":")[1].equals("start")){
                    a[crpeek] = a[crpeek] + time - Integer.parseInt(logs.get(p).split(":")[2]) + 1;
                }
                else{
                    a[crpeek] = a[crpeek] + time - Integer.parseInt(logs.get(p).split(":")[2]) ;
                }
                
            }
            if(i!=0){
                p++;
            }


        }

        return a;
    }

}