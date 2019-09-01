/*
八皇后的意思：某处放完皇后后，其对角线和行、列都不能再继续放了
一个比较好的解释见网友：https://www.jianshu.com/p/65c8c60b83b8
*/

import java.io.*;



class test  
{
    public static int[][] arr=new int[8][8];//棋盘，放皇后
public static int map=0;//存储方案结果数量
	public static void main (String[] args) throws java.lang.Exception
	{
	  System.out.println("八皇后问题");
    findQueue(0);
    System.out.println("八皇后问题共有："+map+"种可能");
	}
	
	
	public static void findQueue(int row){
	    if(row>7){
	        map++;
	        printQueue();
	        return ;
	    }
	    for(int col =0;col<8;col++){
	        if(check(row,col)){
	            arr[row][col] = 1;
	            findQueue(row+1);
              //注意这里，表示皇后没有位置可以放了，那么我们需要进行回溯，之前的那个位置需要进行清空
	            arr[row][col] = 0;
	        }
	    }
	}
	
	public static boolean check(int k ,int j){
	    for(int i = 0;i<k;i++){
	        if(arr[i][j]==1){
	            return false;
	        }
	    }
	    
	    for(int i = k-1,m=j-1;i>=0&&m>=0;i--,m--){
	        if(arr[i][m]==1){
	            return false;
	        }
	    }
	     for(int i=k-1,m=j+1; i>=0 && m<=7; i--,m++){//检查右对角线
        if(arr[i][m]==1){
                return false;
        }
    }
    return true;
	    
	}
	
	public static void printQueue(){//打印结果
    System.out.print("方案"+map+":"+"\n");
    for(int i=0;i<8;i++){
        for(int m=0;m<8;m++){
            if(arr[i][m]==1){  
                System.out.print("皇后"+(i+1)+"在第"+i+"行，第"+m+"列\t");
               // System.out.print("o ");
            }
            else{
                    System.out.print("+ ");
            }
        }
        System.out.println();
    }
    System.out.println();
}
}
