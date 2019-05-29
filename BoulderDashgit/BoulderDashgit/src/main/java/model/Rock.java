package model;

import View.Map;

public class Rock 
{
     Map m = new Map();
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

    public int verif(int x,int y) {
    	
    	if (m.tab[x][y] == '0') {
            return 0 ;
        }
        else if (m.tab[x][y] == '1') {
            return 1;
        }
        else if (m.tab[x][y] == '2') {
            return 2;
        }
        else if (m.tab[x][y] == '3') {
            return 3;
        }
        else return 4;
       
    }
}