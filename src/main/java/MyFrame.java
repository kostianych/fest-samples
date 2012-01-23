import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame {

    public static final String LABEL_NAME = "frameLabel";

    public static final String LABEL_TEXT = "This is frame label";

    JLabel label;

    public MyFrame() {
	add(getLabel());
    }

    private JLabel getLabel() {
	if (label == null) {
	    label = new JLabel();
	    label.setName(LABEL_NAME);
	    label.setText(LABEL_TEXT);
	}
	return label;
    }

    public static void main(String [] args) {
	MyFrame frame = new MyFrame();
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.setSize(400, 300);
	frame.show();
    }
    
}