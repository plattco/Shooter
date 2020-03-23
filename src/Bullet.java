import java.awt.Color;
import java.awt.Point;

public class Bullet extends Rectangle{
	
	public Bullet(double length, double width, Point location, Color c) {

		this.setWidth(width);
		this.setLength(length);

		this.setColor(c);
		this.setLocation(location);
	}
	
	
	public boolean Location() {
		if(getLocation().getY() > 400)
			return false;
		return true;
	}
	
	
	
	@Override
	public void move() {
		
		Point newLocation = getLocation();
//		if(newLocation.x > 400)
			newLocation.y = newLocation.y - 6;
//		else
//			newLocation.x = 0;
			this.setLocation(newLocation);
		
	}
}