public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list=new ArrayList<Integer>();
         
        int i=1;
        while(i<=n)
        {
			list.add(i);
			if(list.size()==n)
				return list;
			i=i*10;
		}
		i=i/10;
		if(i==n)
			i=i/10;
		while(list.size()<n)
		{
			i++;
			int temp=i,index=list.size();
			while(temp%10==0&&temp!=0&&list.size()<n){
				list.add(index,temp/10);
				temp=temp/10;
			}
			if(i==n)
			{
				if(list.indexOf(i)==-1)
					list.add(i);
				i=n/10+1;
				// 4999,要处理5,50的情况;
				if(i%10==0){
					int tmp=i,ind=list.size();
					while(i%10==0 && i!=0 && list.size() < n){
						i=i/10;
						list.add(ind,i);
					}
					i=tmp;
				}
			}
			if(list.size()<n)
				list.add(i);
		}
		//System.out.println(list+" "+list.size());
		//for(int k=1;k<=n;k++)
		//	if(list.indexOf(k)==-1)
		//		System.out.print(k+" ");

		return list;
    }

}
