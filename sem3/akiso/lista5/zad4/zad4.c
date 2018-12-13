#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>

int main()
{
	int n;
	printf("Rozmiar: ");
	scanf("%d", &n);
	int first[n][n], second[n][n], result[n][n];
	struct timeval begin, end;
	double tm;
	
	// wypelnij
	for(int i = 0; i < n; i++)
		for(int j = 0; j < n; j++)
		{
			first[i][j] = rand() % 100;
			second[i][j] = rand() % 100;
			result[i][j] = 0;
		}
	
	// pomnoz

	gettimeofday(&begin, NULL);
	
	for(int i = 0; i < n; i++)
		for(int j = 0; j < n; j++)
			for(int k = 0; k < n; k++)
				result[i][j] += first[i][k] * second[k][j];
	
	gettimeofday(&end, NULL);
	tm = (end.tv_sec - begin.tv_sec) + ((end.tv_usec - begin.tv_usec) / 1000000.0);
	printf("Mnozenie wynioslo: %f\n", tm);
	
	// transpozycja drugiej macierzy
	int tmp[n][n];
	for(int i = 0; i < n; i++)
		for(int j = 0; j < n; j++)
			tmp[i][j] = second[j][i];
		
	// pomnoz
		
	gettimeofday(&begin, NULL);
		
	for(int i = 0; i < n; i++)
		for(int j = 0; j < n; j++)
			for(int k = 0; k < n; k++)
				result[i][j] += first[i][k] * tmp[j][k];
				
	gettimeofday(&end, NULL);
	tm = (end.tv_sec - begin.tv_sec) + ((end.tv_usec - begin.tv_usec) / 1000000.0);
	printf("Mnozenie wynioslo: %f\n", tm);
			
	return 0;
}
