/*
Focus:
	RecursionI
	Sorting Algorithms
Written by Giana Yang, 05/31/2019
*/
#include <string>
#include <vector>
#include <iostream>
using namespace std;

//FibonacciNubmer
int fibonacci(int K) {
	if (K == 0)return 0;
	else if (K == 1)return 1;
	return fibonacci(K - 1) + fibonacci(K - 2);
}

//a to the power of b
int power(int a, int b) {
	if (b == 0)return 1;
	int result = power(a, b / 2);
	if (b % 2 == 1) return a * result * result;
	else return result * result;
}

//Merge Sort
void mergeSort(vector<int>& array, vector<int>& helper, int left, int mid, int right) {
	for (int i = left; i <= right; i++) {
		helper[i] = array[i];
	}
	int leftIndex = left;
	int rightIndex = mid+1;
	while (leftIndex <= mid && rightIndex <= right) {
		if (helper[leftIndex] <= helper[rightIndex]) {
			array[left] = helper[leftIndex];
			left++;
			leftIndex++;
		}
		else {
			array[left] = helper[rightIndex];
			left++;
			rightIndex++;
		}
	}
	while (leftIndex <= mid) {
		array[left] = helper[leftIndex];
		left++;
		leftIndex++;
	}
}

void mergeSort(vector<int>& array, vector<int>& helper, int left, int right) {
	if (left >= right)return;
	int mid = left + (right - left) / 2;
	mergeSort(array, helper, left, mid);
	mergeSort(array, helper, mid + 1, right);
	mergeSort(array, helper, left, mid, right);
}

vector<int>& mergeSort(vector<int>& array) {
	// write your solution here
	if (array.size() == 0)return array;
	vector<int>helper(array.size());
	mergeSort(array,helper, 0, array.size() - 1);
	return array;
}

//selection sort
vector<int> selectionSort(vector<int>& array) {
	for (size_t i = 0; i < array.size() - 1; i++) {
		size_t globalMin = i;
		for (size_t j = i + 1; j < array.size(); j++) {
			if (array[j] < array[globalMin]) {
				globalMin = j;
			}
		}
		int temp = array[i];
		array[i] = array[globalMin];
		array[globalMin] = temp;
	}
	return array;
}

//move all zeros to the rightI
void swap(vector<int>& array, size_t left, size_t right) {
	int temp = array[left];
	array[left] = array[right];
	array[right] = temp;
}

vector<int> moveZero(vector<int> array) {
	// write your solution here
	if (array.size() == 0) {
		return array;
	}
	int left = 0;
	int right = array.size() - 1;
	while (left <= right-1) {
		if (array[left] != 0) {
			left++;
		}
		else if (array[right] == 0) {
			right--;
		}
		else {
			swap(array, left, right);
			left++;
			right--;
		}
	}
	return array;
}

//0,1,-1 three catergories
vector<int> rainbowSort(vector<int>& array) {
	// write your solution here
	if (array.size() <= 1) {
		return array;
	}
	size_t neg = 0;
	size_t zero = 0;
	size_t one = array.size() - 1;
	while (zero <= one) {
		if (array[zero] == -1) {
			swap(array, neg, zero);
			zero++;
			neg++;
		}
		else if (array[zero] == 0) {
			zero++;
		}
		else {
			swap(array, zero, one);
			if (one > 0) {
				one--;
			}
			else {
				return array;
			}
		}
	}
	return array;
}


//QuickSort

void quickSort(vector<int>& array, int left, int right) {
	if (left >= right) {
		return;
	}
	int pivot = left + (right - left) / 2;
	swap(array, left, pivot);
	int miniWalker = left;
	for (int i = left; i < right; i++) {
		if (array[i] < array[right]) {
			swap(array, i, miniWalker);
			miniWalker++;
		}
	}
	swap(array, miniWalker, right);
	quickSort(array, left, miniWalker - 1);
	quickSort(array, miniWalker + 1, right);
}
void quickSort(vector<int>& array) {
	quickSort(array, 0, array.size() - 1);
}

int main(){
	vector<int> array = {5,4,3,2,1};
	mergeSort(array);
	for (int i : array) {
		cout << i << " ";
	}
	cout << endl;
	vector<int> array1 = {3,6,31,3,9,1,4,2};
	quickSort(array1);
	for (int i : array1) {
		cout << i << " ";
	}
	vector<int> array2 = { 0,0,1,1,0,1,0 };
	moveZero(array2);

	vector<int> array3 = { 1,1,0,-1,0,1,-1 };
	rainbowSort(array3);
}