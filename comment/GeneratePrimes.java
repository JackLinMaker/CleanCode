import java.util.*;

public class GeneratePrimes
{
	public static int[] generatePrimes(int maxValue)
	{
		if(maxValue >= 2) // the only valid case
		{
			// declarations
			int s = maxValue + 1; // size of array
			boolean[] f = new boolean[s];
			int i;
			// initialization array to true.
			for(int i = 0; i < s; i++)
				f[i] = true;
			// get rid of known non-primes
			f[0] = f[1] = false;
			// sieve
			int j;
			for(int i = 2; i < Math.sqrt(s) + 1; i++)
			{
				if(f[i]) // if i is uncrossed, cross its multiples.
				{
					for(j = 2 * i; j < s; j += i)
						f[j] = false; // multiple is not prime
				}
			}
			
			// how many primes are there ?
			int count = 0;
			for(int i = 0; i < s; i++)
			{
				if(f[i])
					count++; // bump count.
			}
			
			int[] primes = new int[count];
			
			// move the primes into the result
			for(int i = 0, j = 0; i < s; i++)
			{
				if(f[i])	// if prime
					primes[j++] = i;
			}
			return primes;	// return the primes
		}else // maxValue < 2
			return new int[0]; // return null array if bad input. 
	}
}