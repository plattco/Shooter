import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Rectangle extends Shape implements Drawable{
	private double length, width;
	
	public Rectangle(double length, double width, Point location, Color c) {
		
		this.setWidth(width);
		this.setLength(length);
		
		this.setColor(c);
		this.setLocation(location);
	}
	
	public Rectangle() {
		this(0,0, new Point(0,0), Color.BLACK);
	}
	
	public double getLength() {
		return length;
	}


	public void setLength(double length) {
		if(length >= 0)
			this.length = length;
		else
			this.length = 0;
		calArea();
		calPerimeter();
	}


	public double getWidth() {
		return width;
	}


	public void setWidth(double width) {
		if(width >= 0)
			this.width = width;
		else
			this.width = 0;
		calArea();
		calPerimeter();
	}


	@Override
	public void calArea() {
		this.setArea(length * width); 
	}

	@Override
	public void calPerimeter() {
		this.setPerimeter(2 * length + 2 * width);
	}
	
	public boolean equals(Object o) {
		if(o == null) return false;
		if(o.getClass() == this.getClass()) {
			Rectangle b = (Rectangle) o;
			if(this.length == b.length && this.width == b.width)
				return true;	
		}
		return false;
	}

	@Override
	public String toString() {
		return "Rectangle [length=" + length + ", width=" + width + ", area=" + getArea() + ", perimeter()="
				+ getPerimeter() + "]";
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.fillRect((int)getLocation().x, (int)getLocation().y, (int)width, (int)length);
		
	}

	@Override
	public void move() {
		
		Point newLocation = getLocation();
//		if(newLocation.x > 400)
			newLocation.x = newLocation.x + 1;
//		else
//			newLocation.x = 0;
			this.setLocation(newLocation);
		
	}
	public void move(int x) {

		Point newLocation = getLocation();
		newLocation.x = x;

		this.setLocation(newLocation);

	}
	@Override
	public void moveLeft() {
		
		Point newLocation = getLocation();

			newLocation.x = newLocation.x -1;
			this.setLocation(newLocation);
		
	}
}
