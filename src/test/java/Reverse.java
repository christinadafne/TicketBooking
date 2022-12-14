
public class Reverse {

	public static void main(String[] args) {
		String str="i love India";
		String[] str1=str.split(" ");
		int len=str1.length;
//System.out.println(len);
		for(int i=len-1;i>=0;i--)
		{
			System.out.println(str1[i]);
		}
	}

}
