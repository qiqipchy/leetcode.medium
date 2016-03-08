import java.util.Arrays;

public class Solution {
	public int hIndex(int[] citations) {
		Arrays.sort(citations);
		int temp;
		for (int i = 0, j = citations.length - 1; i < j; i++, j--) {
			temp = citations[i];
			citations[i] = citations[j];
			citations[j] = temp;
		}
		int max = 0;
		for (int i = 0; i < citations.length; i++)
			if (citations[i] < (i + 1))
				return i;
