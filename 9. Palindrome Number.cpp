class Solution
{
public:
    bool isPalindrome(int x)
    {
        string str = to_string(x);
        string rev_str = string(str.rbegin(), str.rend());

        if (str == rev_str)
            return true;
        return false;
    }
};