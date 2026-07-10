// import java.util.*;
// public class wordmiss {
//     private static int[][] diff = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int R = sc.nextInt();
//         int C = sc.nextInt();
//         char[][] grid = new char[R][C];
//         for(int row = 0;row<R;row++){
//             for(int col = 0;col<C;col++){
//                 grid[row][col] = sc.next().charAt(0);
//             }
//         }
//         String word = sc.next();
//         int skipped = 0;
//         System.out.println(word);
//         for(int row = 0;row<R;row++){
//             for(int col = 0;col<C;col++){
//                 if(grid[row][col]==word.charAt(0) && dfs(row,col,grid,word,skipped,0,word)){
//                     System.out.println("yes");
//                     return;
//                 }
//             }
//         }
//         for(int row = 0;row<R;row++){
//             for(int col = 0;col<C;col++){
//                 if(grid[row][col]==word.charAt(1) && dfs(row,col,grid,1,1,word)){
//                     System.out.println("yes");
//                     return;
//                 }
//             }
//         }
//         System.out.println("no");
//     }
//     private static boolean dfs(int row,int col,char[][] grid,int skipped,int index,String word){
//         if(index==word.length()) return true;
//         if(skipped>1) return false;
//         for(int d = 0;d<8;d++){
//             int adjR = row+diff[d][0];
//             int adjC = col+diff[d][1];
//             if(adjR < R && adjC < C && adjR>=0 && adjC>=0 && grid[adjR][adjC]==word.charAt(index)){
//                 if(dfs(adjR,adjC,grid,skipped,index+1,word)) return true;
//             }
//         }
//         return dfs(row,col,grid,skipped+1,index+1,word);
//     }
// }
// #include<iostream>
// #include<vector>
// #include<set>
// #include <map>
// #include<algorithm>
// #include<numeric>
// using namespace std;
// #define ll long long int
// #define MOD 1000000007
// int N,M,bonus;
// int stitch(vector<vector<int>>& dp, vector<pair<int,int>>& ns,
// vector<pair<int,int>>& ms,int nsi,int msi,int ptxt){
// 	if(nsi>=N && msi>=M) return 0;
	
// 	if(dp[nsi][msi]!=MOD){
// 		return dp[nsi][msi];
// 	}
// 	int maxpts=0;
// 	if(nsi<N){
// 		int nextpts=stitch(dp,ns,ms,nsi+1,msi,ns[nsi].first);
// 		int currpts=ns[nsi].second;
// 		if(ptxt==ns[nsi].first) currpts+=bonus;
// 		if(nextpts>0) currpts+=nextpts;
// 		maxpts=max(maxpts,currpts);
// 	}
// 	if(msi<M){
// 		int nextpts=stitch(dp,ns,ms,nsi,msi+1,ms[msi].first); 
// 		int currpts=ms[msi].second;
// 		if(ptxt==ms[msi].first) currpts+=bonus;
// 		if(nextpts>0) currpts+=nextpts;
// 		maxpts=max(maxpts,currpts);
// 	}
// 	dp[nsi][msi]=maxpts;
// 	return maxpts;
// }
// void solve(){	
 
//    cin >> N >> M >> bonus;
//    vector<pair<int,int>> ns(N),ms(M);
//    for(int i=0;i<N;i++){
//    	 int txt,pts;
//    	 cin >> txt >> pts;
//    	 ns[i]=make_pair(txt,pts);
//    }
//    for(int i=0;i<M;i++){
//    	 int txt,pts;
//    	 cin >> txt >> pts;
//    	 ms[i]=make_pair(txt,pts);
//    }
//    vector<vector<int>> dp(N+1,vector<int>(M+1,MOD));
   
  
//    int maxpts=stitch(dp,ns,ms,0,0,2000);
//    cout << max(0,maxpts) << endl;
// }

// int main()
// {
// 	ios::sync_with_stdio(false);
// 	cin.tie(nullptr);
// 	int T=1;
// 	//cin>>T;
// 	while(T--) solve();
// }
import java.util.*;
public class wordmiss{
    private static int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N,M,bonus;
    }
}