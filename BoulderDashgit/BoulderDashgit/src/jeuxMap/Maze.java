package jeuxMap;

import javax.swing.*;

public class Maze 
{
	public static void main(String[] args) 
	{
		new Maze();
	}
	
	public Maze() 
	{
		JFrame f = new JFrame();
		f.setTitle("Boulder Dash");
		f.add(new Board());
		f.setSize(490, 512);
		f.setLocationRelativeTo(null);
		f.setResizable(false);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
