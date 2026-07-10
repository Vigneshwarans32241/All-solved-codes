public class kadensalgo {
    public static void main(String[] args){
        int[] arr = {5,4,1,7,8};
        int maxsum = arr[0];
        int currentsum = maxsum;
        int prevsum = currentsum;
        if(maxsum<0) currentsum = 0;
        for(int i = 1;i<arr.length;i++){
            currentsum +=arr[i];
            if(currentsum<0){
                currentsum = 0;
            }
            else{
                prevsum = currentsum;
            }
        }
        System.out.print(prevsum);
    }
}
