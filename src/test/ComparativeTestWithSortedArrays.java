package test;

import data.Functions;
import data.ParallelQuickSort;
import data.SecuentialQuickSort;

public class ComparativeTestWithSortedArrays {

	public static void main(String[] args) {

		int executions = 10;
		int arraySize = 100000;
		double totalSecuential = 0;
		double totalParallel = 0;

		for (int i = 0; i < executions; i++) {

			double SecuentialStart;
			double SecuentialEnd;
			double SecuentialDuration;

			double ParallelStart;
			double ParallelEnd;
			double ParallelDuration;

			int[] array = Functions.randomArray(arraySize, 1, 1000);
			ParallelQuickSort.parallelQuickSort(array, 0, array.length - 1);

			// Ejecucion secuencial
			SecuentialStart = System.nanoTime();
			SecuentialQuickSort.quickSort(array, 0, array.length - 1);
			SecuentialEnd = System.nanoTime();
			SecuentialDuration = (SecuentialEnd - SecuentialStart) / 1000;
			totalSecuential += SecuentialDuration;

			// Ejecucion paralela
			ParallelStart = System.nanoTime();
			ParallelQuickSort.parallelQuickSort(array, 0, array.length - 1);
			ParallelEnd = System.nanoTime();
			ParallelDuration = (ParallelEnd - ParallelStart) / 1000;
			totalParallel += ParallelDuration;

		}

		double averageSecuential = totalSecuential / (double) executions;
		double averageParallel = totalParallel / (double) executions;

		System.out.printf("Average secuential duration--> %.2f microseconds \n", averageSecuential);
		System.out.printf("Average parallel duration-->  %.2f microseconds ", averageParallel);
	}

}
