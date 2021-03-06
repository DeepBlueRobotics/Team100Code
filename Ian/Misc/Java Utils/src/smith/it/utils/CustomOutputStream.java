package smith.it.utils;

import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JTextArea;

/**
 * A class that redirects the console output to a JTextArea.
 * 
 * @author Ian Smith
 */
public class CustomOutputStream extends OutputStream {
	private JTextArea textArea;

	public CustomOutputStream(JTextArea textArea) {
		
		this.textArea = textArea;
	}

	@Override
	public void write(int b) throws IOException {
		// Redirects data to the text area
		textArea.append(String.valueOf((char) b));
		// Scrolls the text area to the end of data
		textArea.setCaretPosition(textArea.getDocument().getLength());
	}
}