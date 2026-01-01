using System;
using System.Security.AccessControl;
using System.Text;

class Program
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());

        int[] arr = new int[n];

        string? str = Console.ReadLine();
        string[] strings = str.Split(" ");
        arr =  Array.ConvertAll(strings, int.Parse);
        
        Array.Sort(arr);

        int m = int.Parse(Console.ReadLine());

        string[] tmp = Console.ReadLine().Split(" ");
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < m; i++)
        {
            var read = int.Parse(tmp[i]);
            var binarySearch = Array.BinarySearch(arr, read);
            if (binarySearch >= 0)
            {
                sb.AppendLine("1");
                
            }
            else
            {
                sb.AppendLine("0");

            }
        }

        Console.WriteLine(sb.ToString());
    }
}