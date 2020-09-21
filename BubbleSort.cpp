#include <iostream>
using namespace std;

void main(){
    int i,j;
    int temp;
    int a[5]={4,2,3,5,1};

    for(int i=0;i<4;i++){
        for(int j=0;j<4-i;j++){
            if(a[j]>a[j+1]){
                temp=a[j];
                a[j]=a[j+1];
                a[j+1]=temp;
            }
        }
    }

    for(int i=0;i<5;i++){
        cout<<a[i]<<endl;
    }
}