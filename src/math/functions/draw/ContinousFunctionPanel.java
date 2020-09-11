package math.functions.draw;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JPanel;

import math.functions.basic.DoubleFunction;

/**
 * A class for drawing continous functions in a <code>JPanel</code>.
 * @author tommy
 *
 */
@SuppressWarnings("serial")
public class ContinousFunctionPanel extends JPanel {

	private final static int   DEFAULT_PANEL_WIDTH  = 500;
	private final static int   DEFAULT_PANEL_HEIGHT = 500;
	private final static Color DEFAULT_LINE_COLOR   = Color.RED;
	
	private DoubleFunction function;
	private double         minimumXValue;
	private double         maximumXValue;
	private double		   minimumYValue;
	private double         maximumYValue;
	
	private int[]          yPosition;
	private int            panelWidth;
	private int            panelHeight;
	private Color          lineColor;
	
	/**
	 * Creates a new <code>ContinousFuncitonPanel</code>.
	 * @param function      the function to draw
	 * @param minimumXValue the lower bound for the function input
	 * @param maximumXValue the upper bound for the function input
	 */
	public ContinousFunctionPanel(DoubleFunction function, double minimumXValue, double maximumXValue) {
		this(function, minimumXValue, maximumXValue, DEFAULT_PANEL_WIDTH, DEFAULT_PANEL_HEIGHT);
	}
	/**
	 * Creates a new <code>ContinousFuncitonPanel</code>.
	 * @param function      the function to draw
	 * @param minimumXValue the lower bound for the function input
	 * @param maximumXValue the upper bound for the function input
	 * @param panelWidth    the width of the panel
	 * @param panelHeight   the height of the panel
	 */
	public ContinousFunctionPanel(DoubleFunction function, double minimumXValue, double maximumXValue, int panelWidth, int panelHeight) {
		this(function, minimumXValue, maximumXValue, panelWidth, panelHeight, DEFAULT_LINE_COLOR);
	}
	/**
	 * Creates a new <code>ContinousFuncitonPanel</code>.
	 * @param function      the function to draw
	 * @param minimumXValue the lower bound for the function input
	 * @param maximumXValue the upper bound for the function input
	 * @param panelWidth    the width of the panel
	 * @param panelHeight   the height of the panel
	 * @param lineColor		the drawing color of the function
	 */
	public ContinousFunctionPanel(DoubleFunction function, double minimumXValue, double maximumXValue, int panelWidth, int panelHeight, Color lineColor) {
		if (panelWidth < 10) {
			panelWidth = 10;
			System.err.println("The panel width is to small. It should be at least 10. Reseted it to 10.");
		}
		if (panelHeight < 10) {
			panelHeight = 10;
			System.err.println("The panel height is to small. It should be at least 10. Reseted it to 10.");
		}
		this.panelWidth  = panelWidth;
		this.panelHeight = panelHeight;
		this.lineColor   = lineColor;
		setFunction(function, minimumXValue, maximumXValue);
	}
	
	/**
	 * Returns the width of the drawing panel.
	 * @return width
	 */
	public int getPanelWidth() {
		return this.panelWidth;
	}
	/**
	 * Returns the height of the drawing panel.
	 * @return height
	 */
	public int getPanelHeight() {
		return this.panelHeight;
	}
	
	/**
	 * Returns the function.
	 * @return function
	 */
	public DoubleFunction getFunction() {
		return function;
	}
	/**
	 * Sets the function.
	 * @param function      the function to draw
	 * @param minimumXValue the lower bound for the function input
	 * @param maximumXValue the upper bound for the function input
	 */
	public void setFunction(DoubleFunction function, double minimumXValue, double maximumXValue) {
		if (minimumXValue >= maximumXValue) {
			throw new IllegalArgumentException("The minimum x-value must be smaller than the maximum x-value.");
		}
		this.function      = function;
		this.minimumXValue = minimumXValue;
		this.maximumXValue = maximumXValue;
		
		// calculate size of each step
		// the function is evaluated at each integer point of the <code>panelWidth</code>
		double stepSize    = (maximumXValue-minimumXValue) / panelWidth;
		
		// evaluate the function
		double[] yValues   = new double[panelWidth+1];
		this.minimumYValue = Double.POSITIVE_INFINITY;
		this.maximumYValue = Double.NEGATIVE_INFINITY;
		for (int i=0; i<=panelWidth; i++) {
			yValues[i] = function.getYValue(minimumXValue + i * stepSize);
			this.maximumYValue = yValues[i] > this.maximumYValue ? yValues[i] : this.maximumYValue;
			this.minimumYValue = yValues[i] < this.minimumYValue ? yValues[i] : this.minimumYValue;
		}
		
		
		// stretch the evaluated y-values to match the panelheight
		double yFactor = this.panelHeight / (this.maximumYValue - this.minimumYValue);
		int    minYPos = (int) (yFactor * this.minimumYValue);
		this.yPosition = new int[this.panelWidth+1];
		for (int i=0; i<=this.panelWidth; i++) {
			this.yPosition[i] = this.panelHeight - (int) (yValues[i] * yFactor) + minYPos;
		}
		
		Dimension dim = new Dimension(this.panelWidth, this.panelHeight);
		this.setPreferredSize(dim);
	}
	
	/**
	 * Returns the lower drawing bound for the function.
	 * @return lower bound
	 */
	public double getMinimumXValue() {
		return this.minimumXValue;
	}
	/**
	 * Returns the upper bound for the function.
	 * @return upper bound
	 */
	public double getMaximumXValue() {
		return this.maximumXValue;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// draw coordinate system
		NumberFormat formatter = new DecimalFormat("#0.00");
		Font         font      = new Font(Font.MONOSPACED, Font.PLAIN, 12);
		g.setFont(font);
		FontMetrics fontMetrics = getFontMetrics(getFont());
		String strMaxXValue     = formatter.format(this.maximumXValue);
		int    widthMaxX        = fontMetrics.stringWidth(strMaxXValue) + 5;
		if (this.maximumXValue < 0) {
			widthMaxX += 3;
		}
		
		g.setColor(Color.black);
		g.drawLine(0, this.panelHeight/2, this.panelWidth, this.panelHeight/2); // horizontal line
		g.drawLine(this.panelWidth/2, 0, this.panelWidth/2, this.panelHeight);  // vertical line
		g.drawString(formatter.format(this.minimumXValue), 0, this.panelHeight / 2 - 1);
		g.drawString(strMaxXValue, this.panelWidth - widthMaxX, this.panelHeight / 2 - 2);
		g.drawString(formatter.format(this.maximumYValue), this.panelWidth / 2 + 1, 10);
		g.drawString(formatter.format(this.minimumYValue), this.panelWidth / 2 + 1, this.panelHeight - 1);
		
		// draw function
		g.setColor(lineColor);
		for(int i=0; i<this.panelWidth; i++) {
			g.drawLine(i, this.yPosition[i], (i+1), this.yPosition[i+1]);
		}
		
		g.setColor(Color.black);
	}
}
