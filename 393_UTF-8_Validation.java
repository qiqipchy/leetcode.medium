public class Solution {
	public boolean validUtf8(int[] data) {
		int i = 0;
		while (i < data.length) {
			int p = 1;
			String oct = Integer.toBinaryString(data[i]);
			while (oct.length() < 8) {
				oct = "0" + oct;
			}

			int zeroindex = oct.indexOf('0');
			// 找不到0
			if (zeroindex == -1)
				zeroindex = oct.length() - 1;
			// 一个字节，应该以0开头
			if (zeroindex == 1)
				return false;
			// 不是一个字节的时候；
			if (zeroindex != 0) {
				for (p = 1; p < zeroindex; p++) {
					if (i + p > data.length - 1)
						return false;
					String oct1 = Integer.toBinaryString(data[i + p]);
					while (oct1.length() < 8) {
						oct1 = "0" + oct1;
					}

					if (!oct1.startsWith("10"))
						return false;
				}
			}
			i = i + p;
		}
		return true;
	}
	public static void main(String[] args) {
		int[] data = {145};
		System.out.println(new Solution().validUtf8(data));
	}
}
