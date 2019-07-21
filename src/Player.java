import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class Player implements KeyListener
{
	private int x;
	private int y;
	private boolean left,right,up,down;
	private long tempTime;
	private long delay;
	private int health;
	public static int count;
	private int speed;
	public Player(int x,int y) 
	{
		this.x=x;
		this.y=y;
	}
	public void init()
	{
            speed=3;
		Display.frame.addKeyListener(this);
		tempTime= System.nanoTime();
		delay = 100;
		
	}
	public void tick()
	{
		
		   if(left)
	   	   {
			  if(x>=51)
			  {
			    	x-=speed;
				   if(x<51)
				   {
				    	x=50;
				   }
			  }
		}
		if(right)
		{
			if(x<=450-31)
			{
			   x+=speed;
			   if(x>=450-31)
			   {
				   x=450-30;
			   }
			}
		}
		if(up)
		{
			if(y>=51)
			{
				y-=speed;
				if(y<51)
				{
					y=51;
				}
			}
			
		}
		if(down)
		{
			if(y<=450-31)
			{
				y+=speed;
			}
		
	        }
	}
	public void render(Graphics graphics,Color c)
	{
		
	        graphics.setColor(c);
		    graphics.fillRect(x, y, 30, 30);
		
	}
	public void keyPressed(KeyEvent e)
	{
		int source = e.getKeyCode();
		if(source == KeyEvent.VK_LEFT)
		{
			left = true; 
		}
		if(source==KeyEvent.VK_RIGHT)
		{
			right=true;
		}
		if(source==KeyEvent.VK_UP)
		{
			up=true;
		}
		if(source==KeyEvent.VK_DOWN)
		{
			down=true;
		}
		
	}
	public void keyReleased(KeyEvent e)
	{
		int source = e.getKeyCode();
		if(source == KeyEvent.VK_LEFT)
		{
			left = false; 
		}
		if(source==KeyEvent.VK_RIGHT)
		{
			right=false;
		}
		if(source==KeyEvent.VK_UP)
		{
			up=false;
		}
		if(source==KeyEvent.VK_DOWN)
		{
			down=false;
		}
		
	}
	public void keyTyped(KeyEvent e)
	{
		
	}
	public int getX()
	{
		return this.x;
	}
	public int getY()
	{
		return this.y;
	}
	public void setX(int x)
        {
            this.x=x;
        }
	
	
}
