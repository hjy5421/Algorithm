#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
vector<int> num;

int main()
{
    int N = 0;
    cin >> N;
    num.reserve(N);
    for (int i = 0; i < N; i++)
    {
        int tmp = 0;
        cin >> tmp;
        num.push_back(tmp);
    }
    sort(num.begin(), num.end());

    for (int i = 0; i < N; i++)
    {
        cout << num.at(i) << endl;
    }
}