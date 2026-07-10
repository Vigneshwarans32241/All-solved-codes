public class max {
    public static void main(String[] args){
        int[] arr = {1,1,0,1,1,1,0,1,1,1,1,0};
        int sum = 0,j = 0,maxsum = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]!=0){
                sum+=arr[i];                if(sum>maxsum) maxsum = sum;

            }
            else{
                sum = 0;
            }
        }   
        System.out.print(maxsum);
    }
}
