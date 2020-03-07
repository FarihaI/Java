


import components.simplewriter.SimpleWriter;

import components.simplewriter.SimpleWriter1L;

public class heapsort {
	private static int N;
	public static void sort(int[] numbers) {
        // TODO: Lab 1 -- write heapsort here
		heapMethod(numbers);        
        for (int i = N; i > 0; i--){
            swap(numbers,0, i);
            N = N-1;
            heap(numbers, 0);
        }

    }
	public static void heapMethod(int numbers[]){
        N = numbers.length-1;
        for (int i = N/2; i >= 0; i--)
            heap(numbers, i);        
    }
	public static void heap(int numbers[], int i){ 
        int left = 2*i ;
        int right = 2*i + 1;
        int max = i;
        if (left <= N && numbers[left] < numbers[i])
            max = left;
		if (right <= N && numbers[right] < numbers[max])        
            max = right;
        if (max != i){
            swap(numbers, i, max);
            heap(numbers, max);
        }
    }    
	public static void swap(int numbers[], int i, int j){
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp; 
    }   

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleWriter out = new SimpleWriter1L();

		int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 200);
           out.print(numbers[i] + " ");
            
        } // for (int i = 0; i < numbers.length; i++)
        out.println();
        

        sort(numbers);

        for (int n: numbers)
            out.print(n + " ");
        out.println();
    out.close();
    }
	}


    