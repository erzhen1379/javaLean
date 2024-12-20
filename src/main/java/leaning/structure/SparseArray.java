package leaning.structure;

public class SparseArray {
    public static void main(String[] args) {
        System.out.println("1111");
        //0表示没有棋子，1表示黑子 2表示蓝子
        //c创建一个原始二维数组11*11
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2]=1;
        chessArr1[2][3]=2;
        chessArr1[4][5]=2;
        //输出原始的二维数据
        System.out.println("输出原始的二维数组");
        for (int[] row :chessArr1){
            for(int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

  //将二维数组转为稀疏数组
        //1.先遍历二维数组，得到非0数据个数
        int sum=0;
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if(chessArr1[i][j]!=0){
                    sum++;
                }
            }
        }
        //创建对应的稀疏数组
        int sparseArr[][]=new int[sum+1][3];
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=sum;
        // 遍历二维数组，将非0的值存放到 sparseArr中
        int count=0; //count 用于记录是第几个非0数据
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if(chessArr1[i][j]!=0){
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=chessArr1[i][j];
                }
            }
        }

        //输出稀疏数组的形式
        System.out.println();
        System.out.println("输出稀疏数组");
        for (int i=0;i<sparseArr.length;i++){
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }

//j将稀疏数组恢复成二维数组
        /**
         * 1先读取稀疏数组的第一行，根据第一行构造二维数组
         * 2在读取稀疏数组后几行，并且赋值
         */
    int chessArr2[][]=new int[sparseArr[0][0]][sparseArr[0][1]];
    for(int i=1;i<sparseArr.length;i++){
        chessArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
    }
        // 输出恢复后的二维数组
        System.out.println();
        System.out.println("恢复后的二维数组");

        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

    }
}
