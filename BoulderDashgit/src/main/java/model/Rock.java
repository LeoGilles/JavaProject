package model;

public class Rock 
{
    public int  axeXY[][] = new int[500][500] ;
    int x; 
    int y;
     
    public int getRockX(int x)
    {
        return x;
    }
    public int getRockY(int y)
    {
        return y;
    }

     public void setRockXY(int x,int y)
     {
         axeXY[x][y] = 3 ;

     }
    public void setFloorXY(int x,int y) {

           axeXY[x][y] = 0 ;
    }
    public void setWallXY(int x , int y)
    {
        axeXY[x][y] = 1;
    }
 public void setNothing(int x,int y) {
     axeXY[x][y] = 2;
   

     }
 public void setDiamonsXY(int x,int y) {
	 axeXY[x][y] = 4 ;
 }
    public int verif(int x,int y) {
    	
    	if (axeXY[x][y] == 0) {
            return 0 ;
        }
        else if (axeXY[x][y] == 1) {
            return 1;
        }
        else if (axeXY[x][y] == 2) {
            return 2;
        }
        else if (axeXY[x][y] == 3) {
            return 3;
        }
        else return 4;
       
    }
}