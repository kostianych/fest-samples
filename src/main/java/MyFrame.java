import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MyFrame extends JFrame {

    public static final String LABEL_NAME = "frameLabel";

    public static final String LABEL_TEXT = "This is frame label";

	public static final String BUTTON_NAME = "dialogButton";

	public static final String BUTTON_TEXT = "Ok";    

    JLabel label;

	private JButton jButton;

	private JDialog dialog;

    private JMenuBar menuBar;   

    public MyFrame() {
    	add(getLabel());
    	setName("myFrame");
    	dialog = new JDialog();
    	dialog.setSize(300, 200);
    	dialog.add(getJButton());
    	dialog.setModal(true);
    	dialog.setVisible(true);
    	setVisible(true);
	setJMenuBar(getMyMenuBar());
    }

    private JLabel getLabel() {
	if (label == null) {
	    label = new JLabel();
	    label.setName(LABEL_NAME);
	    label.setText(LABEL_TEXT);
	}
	return label;
    }

    private JButton getJButton() {
    	if (jButton == null) {
    		jButton = new JButton();
    		jButton.setName(BUTTON_NAME);
    		jButton.setText(BUTTON_TEXT);
    		jButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {					
					dialog.dispose();
				}
			});
		}
		return jButton;
    }

    private JMenuBar getMyMenuBar() {
	if (menuBar == null) {
	    menuBar = new JMenuBar();
	    JMenu menu = new JMenu();
	    menu.setName("frameMenu");
	    menu.setText("Menu");
	    menuBar.add(menu);
	}
	return menuBar;
    }
    
    public static void main(String[] args) {
    	MyFrame myFrame = new MyFrame();
    	myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	myFrame.setSize(400, 300);
    	myFrame.setVisible(true);
	}
}