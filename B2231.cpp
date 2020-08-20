#include <iostream>
#define INF 10000000
using namespace std;

int main()
{
    int N = 0;
    cin >> N;
    int div = 1;
    int idx = 0;
    for (int i = 0; i < 6; i++)
    {
        if (N / div > 0)
        {
            idx++;
            div *= 10;
        }
        else
            break;
    }
    cout << "index : " << idx << endl;
    cout << "div : " << div << endl;
    int sum = 0;
    int ret = INF;
    for (int num = div / 100; num < div / 10; num++)
    {
        for (int i = 0; i < idx; i++)
        {
            sum += (num % 10);
            num /= 10;
        }
        ret = min(ret, N - sum);
        sum = 0;
        cout << "for1 : " << ret << endl;
    }
    for (int num = div / 10; num < div; num++)
    {
        for (int i = 0; i < idx; i++)
        {
            sum += (num % 10);
            num /= 10;
        }
        ret = min(ret, N - sum);
        sum = 0;
        cout << "for2 : " << ret << endl;
    }

    if (ret <= 0)
        ret = 0;

    cout << "answer : ";
    cout << ret << endl;
}