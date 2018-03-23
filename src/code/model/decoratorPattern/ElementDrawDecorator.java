package code.model.decoratorPattern;

import java.awt.Graphics2D;

public class ElementDrawDecorator extends AElementDecorator {

	public ElementDrawDecorator(IElement iDrawAction) {
		super(iDrawAction);
	}
	
	 @Override
	   public void draw(Graphics2D graphics) {
		 iElement.draw(graphics);	       
	   }
}
