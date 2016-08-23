public class Solution {
   public String intToRoman(int num) {
        String[][] can={{"","I","II","III","IV","V","VI","VII","VIII","IX"},{"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
			{"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},{"","M","MM","MMM"}};
		int i=0;
		String path="";
		while(num!=0)
		{
			path=can[i++][num%10]+path;
			num=num/10;
		}
		return path;
    }
	
}
