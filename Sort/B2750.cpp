#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    int N = 0;
    cin >> N;
    vector<int> num;
    for (int i = 0; i < N; i++)
    {
        int tmp = 0;
        cin >> tmp;
        num.push_back(tmp);
    }
    sort(num.begin(), num.end());

    for (int i = 0; i < num.size(); i++)
    {
        cout << num.at(i) << endl;
    }
}