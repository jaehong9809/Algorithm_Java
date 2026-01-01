using System;
using System.Collections.Generic;


class Program
{
    public static void Main(string[] args)
    {
        string a = Console.ReadLine();
        int n = int.Parse(a);

        for (int i = 0; i < n; i++)
        {
            string  b = Console.ReadLine();
            Stack<char> stack = new Stack<char>();
            bool q = true;
            for (int j = 0; j < b.Length; j++)
            {
                char c = b[j];
                if(c=='(')
                {
                    stack.Push(c);
                }
                else
                {
                    if (stack.Count == 0)
                    {
                        q = false;
                        break;
                    }
                    if (stack.Peek() == '(')
                    {
                        stack.Pop();
                    }
                }

            }

            if (!q || stack.Count > 0)
            {
                Console.WriteLine("NO");
                continue;
            }
            else Console.WriteLine("YES");
            
        }
    }
}