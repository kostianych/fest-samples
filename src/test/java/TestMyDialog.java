import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.fixture.JLabelFixture;

public class TestMyDialog {    

    private FrameFixture myFrame;
    
    @Before
    public void setUp() {
        myFrame = new FrameFixture(new MyFrame());
        myFrame.show();
    }    

    @Test
    public void testModalDialog() {        
	JLabelFixture label = myFrame.label(MyFrame.LABEL_NAME);
	String labelText = label.text();
	assertEquals(labelText, MyFrame.LABEL_TEXT);    
    }

}