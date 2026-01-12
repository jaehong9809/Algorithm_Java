using System;
using System.Collections.Generic;

class Program
{
    public static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        int result = 0;
        for (int i = 0; i < n; i++)
        {
            var str = Console.ReadLine();
            HashSet<char> set = new HashSet<char>();
            set.Add(str[0]);
            bool sign = false;
            for (int j = 1; j < str.Length; j++)
            {
                if (str[j] == str[j - 1]) continue;
                else
                {
                    if (set.Contains(str[j]))
                    {
                        sign = true;
                        break;
                    }
                    else set.Add(str[j]);
                }
            }

            if (!sign) result++;

        }

        Console.WriteLine(result);
    }
}