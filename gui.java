import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.io.IOException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;

public class gui extends JFrame {
    // Global vars
    public static int width_final = 75;
    public static int height_final = 125;

    // Methods
    public gui() {
        initUI();
    }

    private void initUI() {
        setTitle("Code Buddy");
        setSize(width_final, height_final);
        setUndecorated(true);
        setAlwaysOnTop(true);
        setBackground(new Color(0, 0, 0));
        setForeground(new Color(0, 0, 0));
    }

    public static void main(String[] args) throws IOException {

        EventQueue.invokeLater(() -> {
            // initalize gui
            var gui = new gui();
            // onscreen location
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
            Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
            int x = (int) rect.getMaxX() - (gui.getWidth());
            int y = (int) rect.getMaxY() - (gui.getHeight() + 45);
            gui.setLocation(x, y);
            // buttons
            JButton GitButton = new JButton();
            JButton SearchButton = new JButton();
            // JButton ToDoButton = new JButton();
            // set color of buttons
            GitButton.setBackground(new Color(81, 139, 214));
            SearchButton.setBackground(new Color(81, 139, 214));
            // ToDoButton.setBackground(new Color(81, 139, 214));
            GitButton.setForeground(new Color(81, 139, 214));
            SearchButton.setForeground(new Color(81, 139, 214));
            // ToDoButton.setForeground(new Color(81, 139, 214));
            // create icons
            Icon gI = new ImageIcon("./gitIcons/gitAddIcon.png");
            Icon sI = new ImageIcon("./searchIcons/searchIcon.png");
            // Icon tI = new ImageIcon("./todoIcons/todoIcon.png");
            // set icons
            GitButton.setIcon(gI);
            SearchButton.setIcon(sI);
            // ToDoButton.setIcon(tI);
            // set size of button
            GitButton.setSize(width_final, height_final / 3);
            SearchButton.setSize(width_final, height_final / 3);
            // ToDoButton.setSize(width_final, height_final / 3);
            // set points for button locations
            Point GB = new Point(0, 0);
            Point SB = new Point(0, height_final / 3);
            // Point TB = new Point(0, height_final / 3);
            // add button to frame and set location
            gui.add(GitButton).setLocation(GB);
            gui.add(SearchButton).setLocation(SB);
            // gui.add(ToDoButton).setLocation(TB);
            // add function to buttons
            SearchButton.addActionListener(e -> {
                try {
                    searchTab();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            });
            // Make the Gui show
            gui.setVisible(true);
        });
    }

    public static void searchTab() throws IOException {
        try {
            Robot robot = new Robot();
            // Simulate a key press
            robot.delay(3000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_C );
            robot.delay(500);
            robot.keyRelease(KeyEvent.VK_C);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.delay(500);
            String data = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor); 
            System.out.println(data);
    } catch (Exception e) {
            e.printStackTrace();
    }
    }

    public static void todoTab() {

    }

    public static void gitTab() {

    }
}