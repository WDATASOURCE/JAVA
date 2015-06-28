package frame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

@SuppressWarnings("serial")
public class Column extends Drawing {
	protected void paintComponent(Graphics g1) {
		  if (numberGroup == null) return; 
		  Graphics2D g = (Graphics2D) g1;
		  super.paintComponent(g);
		  int width = getWidth();
		  int height = getHeight();
		  int interval=(width-40)/numberGroup.length;
		  int individualWidth = (int)(((width-40)/numberGroup.length)*0.9);
		  
		  int maxCount = numberGroup.length;
		  
		  int x = 20;

		  for (int i = 0; i < numberGroup.length; i++) {
			  int barHeight =(int)(((double)numberGroup[i]/(double)maxCount)*(height-55)) - 4;
			
			  g.setColor(new Color((redEnd-redStart)*(numberGroup[i]-1)/divideColor+redStart,(greenEnd-greenStart)*(numberGroup[i]-1)/divideColor+greenStart,(blueEnd-blueStart)*(numberGroup[i]-1)/divideColor+blueStart));
			  
			  int y = height - 45 - barHeight;
			  int xpoint[] = {x, x, x + individualWidth - 1, x + individualWidth - 1};
			  int ypoint[] = {y, y + barHeight - 1, y + barHeight - 1, y}; 
			  Polygon pol = new Polygon(xpoint, ypoint, 4);
			  
			  g.fill(pol);
			  
			  if(i==highlight1||i==highlight2||highlight3==i){
				  g.setColor(colorHighlight);
				  BasicStroke basi = new BasicStroke ((float) ((double)individualWidth / 8.0));
				  g.setStroke(basi);
				  g.drawPolygon(pol);
			  }
		    	
			  g.drawString("" + (i+1), x, height - 30);
			  g.drawString(""+numberGroup[i] +"", x, height - 50 - barHeight);
		    	
			  x+=interval;
		    }
	  }
	  @Override 
	  public Dimension getPreferredSize() {
		  return new Dimension(300, 300);
	  }
}
