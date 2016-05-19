import java.awt.Rectangle;

public class Projectile 
{

	private int x, y, speedX;
	private boolean visible;
	
	private Rectangle r;
	
	public Projectile(int startX, int startY)
	{
		x = startX;
		y = startY;
		speedX = 7;
		visible = true;
		
		r = new Rectangle(0, 0, 0, 0);
	}
	
	public void update()
	{
		x += speedX;
		r.setBounds(x, y, 10, 5);
	
		if (x > 450+StartingClass.getRobot().getCenterX())
		{
			visible = false;
			r = null;
		}
		
		if (x < 450+StartingClass.getRobot().getCenterX())
		{
			checkCollision();
		}
	}

	private void checkCollision() 
	{
		for(int i=0;i<StartingClass.hb.length-1;i++)
		{
			if(r.intersects(StartingClass.hb[i].r))
			{
				visible = false;
		
				if (StartingClass.hb[i].health > 0) 
				{
					StartingClass.hb[i].health -= 1;
				}
				
				if (StartingClass.hb[i].health == 0) 
				{
					StartingClass.hb[i].setCenterX(-100);
					StartingClass.score += 5;
					
				}
			}
		}
	}


	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getSpeedX() {
		return speedX;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	
}
