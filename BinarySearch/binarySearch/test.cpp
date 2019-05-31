/*
Binary Search: 
	classic binary search
	Search In Sorted Matrix I
	Closest In Sorted Array
	First Occurence
	Last Occurence
	K Closest in Sorted Array
2018/05/27
Written by Giana Yang
*/
#include <string>
#include <vector>
#include <iostream>
using namespace std;
class Solution {
public:
	vector<int> search(vector<vector<int>>& matrix, int target) {
		// write your solution here
		vector<int> result = { -1,-1 };
		int row = matrix.size();
		int column = matrix[0].size();
		int i = 0;
		int j = row * column - 1;
		while (i <= j) {
			int mid = (i+j) / 2;
			int r = mid / column;
			int c = mid % column;
			if (matrix[r][c] == target) {
				result[0] = r;
				result[1] = c;
				return result;
			}
			else if (matrix[r][c] < target) {
				i = mid + 1;
			}
			else {
				j = mid - 1;
			}
		}
		return result;
	}
	int closest(vector<int>& array, int target) {
		// write your solution here
		int left = 0;
		int right = array.size() - 1;
		int mid;
		while (left < right-1) {
			mid = (left + right) / 2;
			if (array[mid] == target) {
				return mid;
			}
			else if (array[mid] < target) {
				left = mid;
			}
			else {
				right = mid;
			}
		}
		if ((array[left] - target) < 0 && (array[right] - target) < 0) {
			if (-1 * (array[left] - target) < -1 * (array[right] - target)) return left;
			else return right;
		}
		else if ((array[left] - target) < 0) {
			if (-1 * (array[left] - target) < (array[right] - target)) return left;
			else return right;
		}
		else {
			if ((array[left] - target) < -1 * (array[right] - target)) return left;
			else return right;
		}

	}

	
	int firstOccur(vector<int> array, int target) {
		// write your solution here
		if (array.size() == 0)return -1;
		int left = 0;
		int right = array.size() - 1;
		while (left < right - 1) {
			int mid = (left + right) / 2;
			if (array[mid] == target) {
				right = mid;
			}
			else if (array[mid] < target) {
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		if (array[left] == target)return left;
		if (array[right] == target)return right;
		return -1;
	}

	int largetestSmallerEqual(const vector<int>& array, int target) {
		int left = 0;
		int right = array.size() - 1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (array[mid] <= target) {
				left = mid;
			}
			else right = mid;
		}
		if (array[right] <= target) return right;
		if (array[left] <= target)return left;
		return -1;
	}
	vector<int> kClosest(const vector<int> & array, int target, int k) {
		// write your solution here
		vector<int>result = {};
		if (k == 0)return result;
		int left = largetestSmallerEqual(array, target);
		int right = left + 1;
		for (int i = 0; i < k; ++i) {
			if (right >= array.size() || (left >= 0 && (target - array[left] <= (array[right] - target)))) {
				result.push_back(array[left]);
				left--;
			}
			else {
				result.push_back(array[right]);
				right++;
			}
		}
		return result;
	}
	
};

int main() {
	Solution solu;
	vector<vector<int>> test3 = { { 1, 2, 3, 3, 4 },{4, 5, 6, 7, 10}, {12, 14, 14, 17, 19}, {22, 22, 22, 24, 26} };
	vector<int> test4 = { 3,4,5,6,6,12,16 };
	int result = solu.closest(test4, 10);
	cout << result<<endl;
	vector<int>test5 = { 1,5 };
	vector<int> result4 = solu.kClosest(test5, 10, 1);
	for (int i : result4) {
		cout << i;
	}
}

