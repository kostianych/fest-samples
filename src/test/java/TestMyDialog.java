import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.fest.swing.annotation.RunsInEDT;
import org.fest.swing.core.BasicRobot;
import org.fest.swing.core.Robot;
import org.fest.swing.edt.GuiActionRunner;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.finder.WindowFinder;
import org.fest.swing.fixture.DialogFixture;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.fixture.JLabelFixture;
import org.fest.swing.fixture.JMenuItemFixture;
import java.util.concurrent.TimeUnit;

public class TestMyDialog {    

    private FrameFixture myFrame;
    Robot robot;
    
    @Before
    public void setUp() {
    	robot = BasicRobot.robotWithNewAwtHierarchy();
    	createAndShowNew();
    	//MyFrame frame = createNew();
    	//robot.showWindow(frame);
        //myFrame = new FrameFixture(robot, frame);myFrame = WindowFinder.findFrame("myFrame").using(robot);    	

        //myFrame.show();
    }    
    
    @RunsInEDT
    static MyFrame createNew() {
      return GuiActionRunner.execute(new GuiQuery<MyFrame>() {
        protected MyFrame executeInEDT() {
          return new MyFrame();
        }
      });
    }
    
    @RunsInEDT
    static void createAndShowNew() {
    	SwingUtilities.invokeLater(new Runnable() {
    		public void run() {
    			new MyFrame();
    		}
    	});	
    }



    @Test
    public void testModalDialog() {    	
    	DialogFixture dialog = WindowFinder.findDialog(JDialog.class).withTimeout(1, TimeUnit.SECONDS).using(robot);
    	assertNotNull(dialog);
    	dialog.button(MyFrame.BUTTON_NAME).click();
    	myFrame = WindowFinder.findFrame("myFrame").using(robot);
    	JLabelFixture label = myFrame.label(MyFrame.LABEL_NAME);
    	String labelText = label.text();
    	assertEquals(labelText, MyFrame.LABEL_TEXT);
	JMenuItemFixture menu = myFrame.menuItem("frameMenu");
	assertNotNull(menu);
	menu.click();
    }

}