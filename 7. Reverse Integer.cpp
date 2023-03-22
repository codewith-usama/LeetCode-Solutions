class Solution
{
public:
    int reverse(int x)
    {

        if (x == pow(-2, 31))
            return 0;
        long int i = pow(2, 31);
        if (x > i)
            return 0;

        long int remainder = 0, reversed_number = 0;
        while (x != 0)
        {
            remainder = x % 10;
            reversed_number = reversed_number * 10 + remainder;
            x /= 10;
        }
        long int j = pow(-2, 31);

        if (reversed_number < i && reversed_number > j)
            return reversed_number;
        return 0;
    }
};