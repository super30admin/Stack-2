/*
TC : O(N)
SC : O(N)
*/
class Solution
{
public:
    vector<int> exclusiveTime(int n, vector<string> &logs)
    {
        if (n <= 0)
        {
            return {};
        }

        vector<int> result(n);
        stack<int> store;
        string first, second, third;
        int curr = 0, prev = 0;
        for (int i = 0; i < logs.size(); i++)
        {
            stringstream ss(logs[i]);
            getline(ss, first, ':');
            getline(ss, second, ':');
            getline(ss, third, ':');
            int id = stoi(first);
            int time = stoi(third);

            curr = time;
            if (second == "start")
            {
                if (!store.empty())
                {
                    result[store.top()] += curr - prev;
                }

                store.push(id);
                prev = curr;
            }
            else
            {
                result[store.top()] += curr - prev + 1;
                store.pop();
                prev = curr + 1;
            }
        }

        return result;
    }
};