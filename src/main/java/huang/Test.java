package huang;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][]=new int[10000][10000];
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[0].length;j++){
				a[i][j] = i+j;
			}
		}
		long time1 = System.currentTimeMillis();
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[0].length;j++){
				int io = a[j][i];
			}
		}
		
		long time2 = System.currentTimeMillis();
		System.out.println((time2-time1));
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[0].length;j++){
				int io = a[i][j];
			}
		}
		long time3 = System.currentTimeMillis();
		System.out.println((time3-time2));
	}

}
