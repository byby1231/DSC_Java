import java.util.Scanner;


class DAPJavaPractice_01810_1
{
/**
 * 練習題一 -  20201209
 * @author 張柏宏
 */
	public static void main(String[] args) 
	{
		//System.out.println("Hello World!");
		//在 main 方法中定義下列原始數據: 
		int datas[] = new int[] { 2, 6, 3, 5, 1, 4 };
		System.out.println("***** DAP Java 練習題一 *****");
		System.out.println("* 來源資料: [2, 6, 3, 5, 1, 4]");
		System.out.println("* 開始排序...輸入範圍 1 到 4，退出程序使用 0");

		System.out.println("1 表示升冪排序");
		System.out.println("2 表示降冪排序");
		System.out.println("3 表示反轉");
		System.out.println("0 表示退出程序。");
		System.out.println("=========================");
		System.out.print(">>> 請輸入執行類型>");
		Scanner scanner = new Scanner(System.in);
		int i = 1;
        while(i == 1){

			while (!scanner.hasNextInt()) {
			  System.out.println("請輸入數字啦!!!");
			  scanner.nextLine();
			}
			int mOrdertype = scanner.nextInt();
            switch(mOrdertype) {  
				case 1: 
					System.out.println("1.順序類型=升冪-1"); 
					sort(mOrdertype,datas);
					System.out.println("--------------------");
					System.out.print(">>> 請輸入執行類型>"); 
					break; 
				case 2: 
					System.out.println("2.順序類型=降冪-2"); 
					sort(mOrdertype,datas);
					System.out.println("--------------------");
					System.out.print(">>> 請輸入執行類型>"); 
					break; 
				case 3: 
					System.out.println("3.順序類型=反轉-3");
				    sort(mOrdertype,datas);
					System.out.println("--------------------");
					System.out.print(">>> 請輸入執行類型>"); 
					break; 
				case 0: 					
					break;
				default: 
					System.out.println("4.順序類型=未知-4"); 
					System.out.println("目前不支持此順序類型的排序!");  
					System.out.println("--------------------");
					System.out.print(">>> 請輸入執行類型>"); 
			}
			if (mOrdertype == 0)   //退出
			{
				System.out.println("..退出循環");
				System.out.println("=========================");
				System.out.println("* 結束排序...");
				System.out.println("* 來源資料: [2, 6, 3, 5, 1, 4]");
				System.out.println("***** DAP Java 練習題一 *****");

				break;
			} 
		}

	}
/**
 * 排序方式
 * @param orderType 順序類型
 * @param datas 數據

 執行的方式為 int 類型，有四種:
	1 表示升冪排序、2 表示降冪排序、3 表示反轉 和 0 表示退出程序。

 */


	private static void sort(int orderType, int[] datas)
	{
		int number[] = new int[] { 1, 2, 3};
		if(contains(number, orderType))
		{
			System.out.print("排序前:[");  
			for(int i=0; i < datas.length; i++){  
					System.out.print(datas[i] + " ");  
			}  
			System.out.println("]");  

		}
		int mResult[] = new int[datas.length];   //宣告一個暫存
		for(int i = 0; i < datas.length; i++) {
		 mResult[i] = datas[i];
		}

		if (orderType == 1 )//升冪
		{			
			int n = mResult.length;  
			int temp = 0;  
            for(int i=0; i < n; i++)
			{  
				 for(int j=1; j < (n-i); j++)
				 {  
					 if(mResult[j-1] > mResult[j])
					 {	  
						temp = mResult[j-1];  
						mResult[j-1] = mResult[j];  
						mResult[j] = temp;  
					 }  					  
				 } 				 
		     } 	 

		}

		if (orderType == 2 )//降冪
		{			
			int n = mResult.length;  
			int temp = 0;  
            for(int i=0; i < n; i++)
			{  
				 for(int j=1; j < (n-i); j++)
				 {  
					 if(mResult[j-1] < mResult[j])
					 {	  
						temp = mResult[j-1];  
						mResult[j-1] = mResult[j];  
						mResult[j] = temp;  
					 }  					  
				 } 				 
		     } 	 

		}

		if (orderType == 3 )//反轉
		{			
			int n = mResult.length;  
			int temp = 0;  
			int j = n; 
            for (int i = 0; i < n; i++) { 
              mResult[j - 1] = datas[i]; 
              j = j - 1; 
			} 	 

		}


		System.out.print("排序後:[");  
			for(int i=0; i < mResult.length; i++){  
					System.out.print(mResult[i] + " ");  
			}  
			System.out.println("]"); 

	
  }
  public static boolean contains(final int[] array, final int v) {

        boolean result = false;

        for(int i : array){
            if(i == v){
                result = true;
                break;
            }
        }

        return result;
    }
}
