#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    int N = 0, M = 0;
    int card[100];
    cin >> N >> M;
    for (int i = 0; i < N; i++)
    {
        cin >> card[i];
    }

    int ret = 0;
    for (int i = 0; i < N - 2; i++)
    {
        for (int j = i + 1; j < N - 1; j++)
        {
            for (int k = j + 1; k < N; k++)
            {
                int sum = card[i] + card[j] + card[k];
                if (sum <= M && M - sum <= M - ret)
                    ret = sum;
            }
        }
    }

    cout << ret << endl;
}