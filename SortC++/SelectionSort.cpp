#include <iostream>
using namespace std;

int main()
{
    int i, j;
    int temp = 0;
    int min_index = 0;
    int a[5] = {4, 2, 3, 5, 1};

    for (int i = 0; i < 4; i++)
    {
        min_index = i;

        for (int j = i + 1; j < 5; j++)
        {
            if (a[j] < a[min_index])
            {
                min_index = j;
            }
        }

        temp = a[min_index];
        a[min_index] = a[i];
        a[i] = temp;
    }

    for (int i = 0; i < 5; i++)
    {
        cout << a[i] << endl;
    }
}
