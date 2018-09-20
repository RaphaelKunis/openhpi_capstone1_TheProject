package de.openhpi.capstone1.game.builder;

import de.openhpi.capstone1.game.model.Ball;
import de.openhpi.capstone1.game.model.Event;
import de.openhpi.capstone1.game.view.AbstractView;
import de.openhpi.capstone1.game.view.BallView;
import processing.core.PApplet;

public class InteractiveBall  extends InteractiveComponent{

	Ball b;
	BallView bView;
	
	public InteractiveBall(PApplet applet) {
		super();
		init(applet);
	}
	
	private void init(PApplet applet) {
		b = new Ball();
		bView = new BallView(applet, b);
		views = new AbstractView[] {bView};
	}	
	
	@Override
	public void handleEvent() {
		// move the ball
		switch (b.getDir()) {
			case NORTHEAST: b.moveUp();   
							b.moveRight(); 
							break;
			case SOUTHEAST: b.moveDown(); 
							b.moveRight();
							break;
			case SOUTHWEST: b.moveDown(); 
							b.moveLeft();
							break;
			case NORTHWEST: b.moveUp();   
							b.moveLeft(); 
							break;		
		}
		// detect edge collision and switch direction
		boolean isOver = false;
		try { isOver = b.detectCollision(); } 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (isOver) { System.out.println("GAME OVER"); System.exit(-1); }
		// detect paddle collision and switch direction
		???
	}

	@Override
	public void handleEvent(Event e, Object o) {
		// DO NOTHING
	}	
}