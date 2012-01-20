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
}