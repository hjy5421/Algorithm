#include <iostream>
using namespace std;

int main()
{
    int N = 0;
    cin >> N;

    int answer = 0;
    for (int i = 1; i < N; i++)
    {
        int sum = i;
        int part = i;
        while (part)
        {
            sum += (part % 10);
            part /= 10;
        }

        if (sum == N)
        {
            answer = i;
            break;
        }
    }

    cout << answer << endl;
}