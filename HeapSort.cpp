#include <iostream>
#include <algorithm>
using namespace std;
int heap[8] = {-1, 3, 4, 5, 1, 7, 2, 8};
int n = 7; //노드 수

void heapify(int i) //최대힙 만드는 함수
{
    int cur = 2 * i; //왼쪽자식노드

    if (cur < n && heap[cur] < heap[cur + 1])
        cur++;

    if (heap[i] < heap[cur])
    {
        swap(heap[i], heap[cur]);
        if (cur <= n / 2)
            heapify(cur);
    }

    cout << i << " "
         << "heapify : ";
    for (int i = 1; i < 8; i++)
    {
        cout << heap[i] << " ";
    }
    cout << endl;
}

void heapsort(int i)
{
    swap(heap[1], heap[i]);

    int root = 1;
    int cur = 2;

    while (cur / 2 < i)
    {
        cur = 2 * root;
        if (cur < i - 1 && heap[cur] < heap[cur + 1])
            cur++;
        if (cur < i && heap[root] < heap[cur])
            swap(heap[root], heap[cur]);

        root = cur;

        cout << "i : " << i << " cur : " << cur << " heapsort : ";
        for (int i = 1; i < 8; i++)
        {
            cout << heap[i] << " ";
        }
        cout << endl;
    }
}

int main()
{
    for (int i = n / 2; i > 0; i--) // 최초 heap 생성
        heapify(i);

    for (int i = n; i > 0; i--) // heap 정렬
        heapsort(i);

    for (int j = 1; j <= n; j++)
        cout << heap[j] << " ";
}