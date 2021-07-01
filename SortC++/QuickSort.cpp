#include <iostream>
#include <algorithm>
using namespace std;
int quick[7] = {5, 1, 6, 3, 4, 2, 7};

void quickSort(int i, int j)
{
    if (i >= j)
        return;

    int pivot = quick[(i + j) / 2];
    int left = i;
    int right = j;

    while (left <= right)
    {
        while (quick[left] < pivot)
            left++;
        while (quick[right] > pivot)
            right--;

        if (left <= right)
        {
            swap(quick[left], quick[right]);
            left++;
            right--;
        }
    }

    quickSort(i, right);
    quickSort(left, j);
}

int main()
{
    quickSort(0, sizeof(quick) / sizeof(int) - 1);
    for (int i = 0; i < 7; i++)
    {
        cout << quick[i] << " ";
    }
    cout << endl;
}