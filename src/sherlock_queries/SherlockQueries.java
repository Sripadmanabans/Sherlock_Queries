package sherlock_queries;

import java.util.Scanner;

public class SherlockQueries 
{
	public static void queries(long a[], int b[], long c[], int n, int m)
	{
		long value[] = new long[n+1];
		for(int i = 1; i <= n; i++)
		{
			value[i] = -1;
		}
		for(int i = 1; i <= m; i++)
		{
			if(value[b[i]] == -1)
			{
				value[b[i]] = c[i];
			}
			else
			{
				value[b[i]] = (value[b[i]] * c[i]) % 1000000007;
			}
		}
		for(int i = 1 ; i <= n; i++)
		{
			for( int j = 1; (j*i) <= n; j++)
			{
				if(value[i]!= -1)
					a[j*i] = (a[j*i] * value[i]) % 1000000007;
			}
		}
		for(int i = 1; i <= n; i++)
		{
			System.out.print((int)a[i]+ " ");
		}
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.next());
		int m = Integer.parseInt(in.next());
		long a[] = new long[n+1];
		int b[] = new int[m+1];
		long c[] = new long[m+1];
		for(int i = 1; i <= n; i++)
		{
			a[i] = in.nextLong();
		}
		for(int i = 1; i <= m; i++)
		{
			b[i] = Integer.parseInt(in.next());
		}
		for(int i = 1; i <= m; i++)
		{
			c[i] = in.nextLong();
		}
		queries(a, b, c, n, m);
		in.close();
	}

}
