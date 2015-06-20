import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.KeyStroke;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.omg.CORBA.PUBLIC_MEMBER;

public class testSwings {

	static JPanel jp = new JPanel();
	static JFrame jf = new JFrame();
	static JTextField jt = new JTextField(10);
	static JTextField jt1 = new JTextField(10);
	static ArrayList<String> words = new ArrayList<>();
	static String rightNow = null;
	public static void main(String[] args) { 
		words.add("hello");
	    words.add("heritage");
	    words.add("happiness");
	    words.add("goodbye");
	    words.add("cruel");
	    words.add("car");
	    words.add("war");
	    words.add("will");
	    words.add("world");
	    words.add("wall");
		DocumentListener documentListener = new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				rightNow = jt.getText();
				showPopUP(rightNow);
			}
			
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				rightNow = jt.getText();
				showPopUP(rightNow);
			}
			
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				rightNow = jt.getText();
				showPopUP(rightNow);
			}
		};
		jt.getDocument().addDocumentListener(documentListener );
		jp.add(jt);
		jp.add(jt1);
		jf.add(jp);
		jf.pack();
		jf.setVisible(true);		
	}
	
	static void showPopUP(String textBoxString){
		JWindow suggestorWindow = new JWindow();
		ArrayList<String> suggestedWords = new ArrayList<String>();
		suggestorWindow.setVisible(false);
		for (String string : words) {
			if(string.substring(0, textBoxString.length()).equalsIgnoreCase(textBoxString)){
				System.out.println("tarun-------------------"+string);
				suggestedWords.add(string);
			}
			suggestorWindow.pack();
			suggestorWindow.setVisible(true);
			System.out.println();
		}
		suggestorWindow.setVisible(false);
	}
}
