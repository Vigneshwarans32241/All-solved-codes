public class deleteelem {
    public static int ones(int[] arr){
        int sum = 0,j = 0,maxsum = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]!=0){
                sum+=arr[i];
                if(sum>maxsum) maxsum = sum;
            }
            else{
                sum = 0;
            }
        }   
        return maxsum;
    }
    public static void main(String[] args){
        int[] arr = {0,1,1,1,0,1,1,0,1};
        int max = 0;
        for(int i = 0;i<arr.length;i++){
            int[] newarray = new int[arr.length-1];
            int k = 0;
            for(int j = 0;j<arr.length;j++){
                if(j!=i){
                    newarray[k] = arr[j];
                    k++; 
                }
            }
            max = Math.max(max,ones(newarray));
        }
        System.out.print(max);
    }
}
