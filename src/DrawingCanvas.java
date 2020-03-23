import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class DrawingCanvas extends JFrame {

	final int FRAME_WIDTH = 400;
	final int FRAME_HEIGHT = 400;
	Color color = Color.YELLOW;

	ArrayList<Drawable> rectangles = new ArrayList<Drawable>();
	ArrayList<Drawable> rectanglesLeft = new ArrayList<Drawable>();

	ArrayList<Drawable> bullets = new ArrayList<Drawable>();

	Rectangle fighter = new Rectangle(30, 30, new Point(200, 325), Color.BLACK);

	public DrawingCanvas() {
		setTitle("Game");
		setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));

		Canvas c = new Canvas(FRAME_WIDTH, FRAME_HEIGHT);
		panel.add(c);

		this.add(panel);
		setVisible(true);

		rectanglesLeft.add(new Rectangle(20, 30, new Point(350, 50), Color.ORANGE));
		rectangles.add(new Rectangle(20, 30, new Point(50, 75), color));
		rectanglesLeft.add(new Rectangle(20, 30, new Point(350, 100), Color.ORANGE));
		rectangles.add(new Rectangle(20, 30, new Point(50, 125), color));
		rectanglesLeft.add(new Rectangle(20, 30, new Point(350, 150), Color.ORANGE));

		rectangles.add(new Rectangle(20, 30, new Point(50, 175), color));
		rectanglesLeft.add(new Rectangle(20, 30, new Point(350, 200), Color.ORANGE));
		rectangles.add(new Rectangle(20, 30, new Point(50, 225), color));
		rectangles.add(new Rectangle(20, 30, new Point(50, 250), color));
		rectangles.add(new Rectangle(20, 30, new Point(90, 175), color));


		Timer tmr = new Timer(20, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(Drawable d: rectangles) {
					d.move();
				}
				for(Drawable d: rectanglesLeft) {
					d.moveLeft();
				}
				for(Drawable d: bullets) {
					d.move();
				}

				repaint();
			}

		});
		tmr.start();

		//panel.setFocusable(true);
		addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				bullets.add(new Bullet(10, 10, fighter.getLocation(), Color.RED));
			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});

		this.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				fighter.move(e.getX());

			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	class Canvas extends JComponent {
		public Canvas(int width, int height) {
			setPreferredSize(new Dimension(width, height));
		}

		protected void paintComponent(Graphics g) {
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, getWidth(), getHeight());
			fighter.draw(g);

			for(Drawable d: bullets) {
				d.draw(g);
			}

			for(Drawable d:rectangles) {
				d.draw(g);
			}
			for(Drawable d: rectanglesLeft) {
				d.draw(g);
			}
		}
	}

	public static void main(String args[]) {
		DrawingCanvas d = new DrawingCanvas();
	}
}
