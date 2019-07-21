import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class GameSetup implements Runnable
{
	private String title;
	private int width;
	private int height;
	private Thread thread;
	private boolean running;
	private Display display;
	private BufferStrategy buffer;
	private Graphics graphics;
	private GameManager manager;
	public  int index=0;
	public static final int gameWidth=400;
	public static final int gameHeight=400;
	public static int health;
	public boolean check1;
	public boolean check2;
	public boolean check3;
	public int ImageIndex;
	public GameSetup(String title,int width, int height)
	{
		this.title=title;
		this.width=width;
		this.height=height;
	}
	
	public void init()
	{
		
		display = new Display(title,width,height);
		
		manager = new GameManager();
		manager.init();
		health=3;
	}
	
	public void tick()
	{
		manager.tick();
		
	}
	public void render()
	{
		
		
		buffer = display.getCanvas().getBufferStrategy();
		
		if(buffer == null)
		{
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		graphics =  buffer.getDrawGraphics();
		graphics.clearRect(0, 0, width, height);
		
		
		//graphics.setColor(Color.darkGray);
		//graphics.fillRect(50, 50, gameWidth, gameHeight);
		if(GameManager.score>150 && GameManager.score<250)
		{
			ImageIndex=1;
		}
		else if(GameManager.score>=250 && GameManager.score<400)
		{
			ImageIndex=2;
		}
		
		//graphics.drawImage(LoadImages.image[ImageIndex],50,50,gameWidth,gameHeight,null);
                graphics.drawRect(0, 0, width, height);
		manager.render(graphics);
		buffer.show();
		graphics.dispose();
			
	}
	
	public synchronized void start()
	{
		if(running)
		{
			return ;
		}
		running = true;
		if(thread == null)
		{
		   thread = new Thread(this);
		   thread.start();
		}
		
	}
	public synchronized void stop()
	{
		if(!running)
		{
			return;
		}
		running = false;
		try
		{
			thread.join();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	public void run()
	{
		init();
		int fps = 60;
		
		double timePertick = 1000000000/fps;
		
		double delta = 0;
		
		long tempTime = System.nanoTime();
		
		while(running)
		{
			delta = delta + (System.nanoTime()-tempTime)/timePertick;
			tempTime = System.nanoTime();
			if(delta>=1)
			{
		          tick();
		          render() ;
		           delta--;
		       
			}
		}
	}
	
}
