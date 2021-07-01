#include <iostream>
using namespace std;

int main()
{
    int i, j;
    int temp;
    int a[5] = {4, 2, 3, 5, 1};

    for (int i = 1; i < 5; i++)
    {
        j = i - 1;

        cout << "while out : " << j << endl;
        while ((a[j] > a[j + 1]) && (j >= 0))
        {
            temp = a[j];
            a[j] = a[j + 1];
            a[j + 1] = temp;
            j--;

            cout << "while in : " << j << endl;
            for (int k = 0; k < 5; k++)
            {
                cout << a[k] << " ";
            }
            cout << endl;
        }
    }

    for (int i = 0; i < 5; i++)
    {
        cout << a[i] << endl;
    }
}