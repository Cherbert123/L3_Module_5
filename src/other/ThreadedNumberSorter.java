package other;

import java.util.Random;

public class ThreadedNumberSorter {
	static final int TOTAL_NUMS = 10000;

	// Complete the method below so that it uses threads to sort the integer array.
	// Try to get the completion time as short as possible.
	// Use the printArray method to check sorting accuracy
	public static void parallelSort(int[] nums) {
		long startTime = System.nanoTime();
		// Complete this method starting at this point
		
		Thread t1 = new Thread(()->{
			boolean Sorted = false;
			while (Sorted == false) {
				for (int i = 0; i <2500; i++) {
					int i1 = i + 1;
					if (nums[i] > nums[i1]) {
						int temp = nums[i];
						nums[i] = nums[i1];
						nums[i1] = temp;
					}
				}
				Sorted = true;
				int Errors = 0;
				for (int i = 0; i < 2500; i++) {
					int i1 = i + 1;
					if (nums[i] > nums[i1]) {
						Sorted = false;
						Errors++;
					}	
				}
			}
		});
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread t2 = new Thread(()->{
			boolean Sorted = false;
			while (Sorted == false) {
				for (int i = 2500; i <5000; i++) {
					int i1 = i + 1;
					if (nums[i] > nums[i1]) {
						int temp = nums[i];
						nums[i] = nums[i1];
						nums[i1] = temp;
					}
				}
				Sorted = true;
				int Errors = 0;
				for (int i = 2500; i < 5000; i++) {
					int i1 = i + 1;
					if (nums[i] > nums[i1]) {
						Sorted = false;
						Errors++;
					}	
				}
			}
		});
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread t3 = new Thread(()->{
			boolean Sorted = false;
			while (Sorted == false) {
				for (int i = 500; i <7500; i++) {
					int i1 = i + 1;
					if (nums[i] > nums[i1]) {
						int temp = nums[i];
						nums[i] = nums[i1];
						nums[i1] = temp;
					}
				}
				Sorted = true;
				int Errors = 0;
				for (int i = 5000; i < 7500; i++) {
					int i1 = i + 1;
					if (nums[i] > nums[i1]) {
						Sorted = false;
						Errors++;
					}	
				}
			}
		});
		t3.start();
		try {
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread t4 = new Thread(()->{
			boolean Sorted = false;
			while (Sorted == false) {
				for (int i = 7500; i < 9999; i++) {
					int i1 = i + 1;
					if (nums[i] > nums[i1]) {
						int temp = nums[i];
						nums[i] = nums[i1];
						nums[i1] = temp;
					}
				}
				Sorted = true;
				int Errors = 0;
				for (int i = 7500; i < 9999; i++) {
					int i1 = i + 1;
					if (nums[i] > nums[i1]) {
						Sorted = false;
						Errors++;
					}	
				}
			}
		});
		t4.start();
		try {
			t4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printArray(nums);

		long totalTime = System.nanoTime() - startTime;
		double timeInSeconds = (double) totalTime / 1_000_000_000;
		System.out.println("The total computing time in seconds was: " + timeInSeconds);
	}

	public static void main(String[] args) {
		int[] nums = new int[TOTAL_NUMS];

		Random randGen = new Random();
		for (int i = 0; i < TOTAL_NUMS; i++) {
			nums[i] = randGen.nextInt(TOTAL_NUMS);
		}

		// printArray(nums);
		parallelSort(nums);
		// printArray(nums);
	}

	private static void printArray(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
}
