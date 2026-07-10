#include<stdio.h>
#include<stdlib.h>
int main(){
    int a,b,n;
    scanf("%d %d",&a,&b);
    if(a>b) n = a;
    else n = b;
    int hcf = 1;
    for(int i = 1;i<n;i++){
        if(a%i==0 && b%i==0){
            if(i>hcf) hcf = i;
        }
    }
    printf("%d",hcf);
}