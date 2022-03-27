package format;

/**
 * This class takes care of formatting story output within double-border
 * rectangular boxes before printing.
 * 
 * @author Dr Russell Campbell
 *
 */
public class Billboard {
	private final static int MAX_WIDTH = 70; // actual width depends on message
	private final static int MAX_HEIGHT = 70; // actual height depends on message
	private final static int BORDER_WIDTH = 4;
	// A temporary array to arrange text and its formatting before sending to userIO.
	private static Chars2D buffer = new Chars2D(MAX_WIDTH, MAX_HEIGHT);
	private int width;
	private int height;
	
	/**
	 * This method centres the given strings inside a rectangular design
	 * for output. The user can then read its output within a double-bordered box.
	 * 
	 * @param message
	 *   An array of strings that will be printed, 
	 *   one string on each line.
	 * 
	 * @throws IllegalArgumentException
	 *   If any string in the message array is longer than 
	 *   (MAX_WIDTH - 2*BORDER_WIDTH)
	 *   chars, or (MAX_HEIGHT - 2*BORDER_WIDTH) lines, then this exception will be
	 *   thrown. This obviously isn't the best way to deal with output
	 *   messages, but it gives you an example of one strict (and simple)
	 *   way you could deal with this issue. You can read *much* more about
	 *   line breaking at <a href="https://xxyxyz.org/line-breaking/">XXYXYZ</a>
	 *   site.
	 *
	 * @return
	 *   The message that is formatted to be output with a fancy border box around it.
	 */
	public String getFormattedMessage(String... message) throws IllegalArgumentException {
		width = setWidth(message);
		height = setHeight(message);
		
		// This is so old data is removed for a fresh update.
		// This is because we are using a *static* Chars2D, one instance shared.
		buffer.clear();
		
		placeBorderAndFill();  // draw a double-border around the message
		placeMessage(message); // put the characters of the message in buffer
		
		// for printing the formatted message to output later
		return buffer.getFormattedString(width, height);
	}
	
	/**
	 * To get the maximum allowed number of characters in a string meant
	 * to be placed within a billboard instance.
	 *
	 * @return
	 *   The maximum number of characters that can be placed inside a row
	 *   of a billboard.
	 */
	public static int getMaxLineWidth() {
		return MAX_WIDTH - 2*BORDER_WIDTH;
	}
	
	/**
	 * To get the maximum allowed number of lines to be placed within
	 * a billboard instance.
	 *
	 * @return
	 *   The maximum number of lines that can be placed inside a billboard.
	 */
	public static int getMaxLines() {
		return MAX_HEIGHT - 2*BORDER_WIDTH;
	}
	
	// An example of parameter validation: is the value passed in good?
	// Our definition of "good" could be whatever we decide it needs to be.
	private int setWidth(String[] message) throws IllegalArgumentException {
		int max = 0;
		for (int i = 0; i < (message.length); i++ ){
			int strLength = 0;
			
			if (message[i] == null)
				strLength = 0;
			else 
				strLength = (message[i].length());
			
			if ((strLength + 2*BORDER_WIDTH) >= MAX_WIDTH) { // includes padding and border
				throw new IllegalArgumentException(
				// Since "good" is arbitrary, you also should describe what is "bad."
					"Part of the message is too wide for the Billboard"
					+ " (more than " + getMaxLineWidth() + " chars):\n\""
					+ message[i] + "\""
				);} 
			else if (strLength + 2*BORDER_WIDTH > max){
				max = strLength + 2*BORDER_WIDTH;
			}
		}
		
		if (max > getMaxLineWidth())
			return MAX_WIDTH;
		else
			return max; // default WIDTH
	}
	
	// An example of parameter validation: is the value passed in good?
	// Our definition of "good" could be whatever we decide it needs to be.
	private int setHeight(String[] message) throws IllegalArgumentException {
		if (message.length + 2*BORDER_WIDTH > MAX_HEIGHT) { // includes padding and border
			throw new IllegalArgumentException(
				// Since "good" is arbitrary, you also should describe what is "bad."
				"Too many lines in the message for the Billboard"
				+ " (more than " + getMaxLineWidth() + " lines)."
			);
		}
		return message.length + 2*BORDER_WIDTH;
	}
	
	// Set up the characters design surrounding the message.
	private void placeBorderAndFill() {
		FillBox blank = new FillBox(2, height-3, width-3, 2, ' ');
		blank.setBuffer(buffer);
		blank.draw();
		BorderBox border = new BorderBox(0, height-1, width-1, 0, '*');
		border.setBuffer(buffer); // uses the same 2D char array as FillBox blank
		border.draw(); // outer box design
		border.shiftCorners(2, -2, -2, 2);
		border.draw(); // inner box design
	}
	
	private void placeMessage(String[] message) {
		// The y value in a 2D plane decreases in the direction humans read through text...
		int y = height - 5;
		for (String str : message) {
			centrePlace(str, y--);
		}
	}
	
	
	// Correctly places each line to be centred within the border.
	private void centrePlace(String str, int y) {
		int n;
		if (str == null)
			n = 0;
		else
			n = str.length();
		
		int x = (width - n) / 2;
		for (int i = 0; i < n; i++) {
			buffer.set(x + i, y, str.charAt(i));
		}
	}
}
