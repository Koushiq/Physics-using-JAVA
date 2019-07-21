import java.awt.Color;
import java.awt.Graphics;

public class GameManager
{
	private Player player,player2;
	private long tempTime;
	private long delay;
	private int health;
	public static long score;
        private boolean start;
        private int speed2;
        private int next;
	public GameManager()
	{}
	public void init()
	{
		player = new Player(50,GameSetup.gameHeight-30+50);
                player2=new Player(GameSetup.gameWidth/2-40,GameSetup.gameHeight-30+50);
		player.init();
		delay = 500 ;
                start=false;
                speed2=3;
	}
	public void tick() 
	{
		player.tick(); 
		player2.tick();
		
                
              
                
                if(player.getX()+30>player2.getX())
                {
                    start=true;
                    player.setX(player2.getX()-30);
                }
                if(start==true)
                {
                    long breaks = (System.nanoTime()-tempTime ) / 1000000;
                    
                    if(breaks<delay)
                    {
                        //System.out.println(breaks);
                        //System.out.println(delay);
                        player2.setX(player2.getX()+speed2);
                         
                    }
                    else
                    {
                        tempTime=System.nanoTime();
                        speed2--;
                    }
                    
                }
                if(speed2<=0)
                {
                    speed2=3;
                    start=false;
                }
                
		
	}
	public void render(Graphics graphics)
	{
		player.render(graphics,Color.red);
		player2.render(graphics,Color.blue);
		
	}
}
