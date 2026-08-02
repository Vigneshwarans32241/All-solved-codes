class Solution {
    // private int checkGreatest(List<Integer> list){
    //     if(list.size()<1) return 0;
    //     if(list.get(0)>=list.get(list.size()-1)) return 0;
    //     else return list.size()-1;
    // }
    public boolean predictTheWinner(int[] nums) {
        // List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        // int p1 = 0,p2 = 0;
        // int remove1,remove2;
        // while(list.size()>0){
        //     int front = list.get(0),back = list.get(list.size()-1);
        //     if(front>=back){
        //         remove1 = front;
        //         p1+=front;
        //         if(list.size()>0) list.remove(0);
        //         if(list.size()<1) break;
        //         remove2 = list.get(checkGreatest(list));
        //         p2+=remove2;
        //         if(list.size()>0) list.remove(checkGreatest(list));
        //     }
        //     else{
        //         remove1 = back;
        //         p1+=back;
        //         if(list.size()>0) list.remove(list.size()-1);
        //         if(list.size()<1) break;
        //         remove2 = list.get(checkGreatest(list));
        //         p2+=remove2;
        //         if(list.size()>0) list.remove(checkGreatest(list));
        //     }
        // }
        // if(p1>=p2) return true;
        // else return false;
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int i = 0;i<n;i++) dp[i][i] = nums[i];
        for(int len = 2;len<=n;len++){
            for(int i = 0;i+len-1<n;i++){
                int j = i+len-1;
                int takeleft = nums[i] - dp[i+1][j];
                int takeright = nums[j] - dp[i][j-1];
                dp[i][j] = Math.max(takeleft,takeright);
            }
        }
        return dp[0][n-1]>=0;
    }
}
