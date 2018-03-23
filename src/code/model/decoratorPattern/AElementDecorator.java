package code.model.decoratorPattern;

import java.awt.Graphics2D;

public abstract class AElementDecorator implements IElement{

	protected IElement iElement;
	
	public AElementDecorator(IElement iDrawAction) {
		this.iElement = iDrawAction;
	}
	
	public void draw(Graphics2D graphics) {
		iElement.draw(graphics);
	}
	
//	public void move() {
//		iElement.move();
//	}
}
