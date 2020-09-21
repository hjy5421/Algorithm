#include <iostream>
using namespace std;
//int arr[1000000];
//int *ans=new int[1000000];
int arr[8] = {6, 5, 3, 1, 8, 7, 2, 4};
int *ans = new int[8];

void merge(int start, int end)
{
    int mid = (start + end) / 2;

    int i = start;
    int j = mid + 1;
    int idx = start;

    cout << "merge : " << start << " " << end << endl;

    while (i <= mid && j <= end)
    {
        if (arr[i] <= arr[j])
            ans[idx++] = arr[i++];
        else
            ans[idx++] = arr[j++];
    }

    int tmp = i > mid ? j : i;
    while (idx <= end)
    {
        ans[idx++] = arr[tmp++];
    }

    for (int i = start; i <= end; i++)
        arr[i] = ans[i];

    cout << "arr : ";
    for (int i = 0; i < 8; i++)
    {
        cout << arr[i] << " ";
    }
    cout << endl;
    cout << "ans : ";
    for (int i = 0; i < 8; i++)
    {
        cout << ans[i] << " ";
    }
    cout << endl;
}

void partition(int start, int end)
{
    int mid;
    cout << "partition : " << start << " " << end << endl;
    if (start < end)
    {
        mid = (start + end) / 2;
        partition(start, mid);
        partition(mid + 1, end);
        merge(start, end);
    }
}

int main()
{
    partition(0, sizeof(arr) / sizeof(int) - 1);
    for (int i = 0; i < 8; i++)
    {
        cout << arr[i] << " ";
    }
    cout << endl;
}