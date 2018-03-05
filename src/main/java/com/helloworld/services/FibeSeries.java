package com.helloworld.services;

public class FibeSeries {

	Long f[] = null;
	int i=0;

	public FibeSeries(int num){
		f = new Long[num +1];
		f[0]=0l;
		f[1]=1l;
		i=2;
	}

	public Long[] getFibonacciSeries(int num) {

		if (num == 1) {
			return f; 
		}

		f[i]= f[i-1] + f[i-2];
		i++;
		getFibonacciSeries(num-1);

		return f; 

	}

}
