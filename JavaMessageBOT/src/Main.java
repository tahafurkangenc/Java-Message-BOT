import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Main {
    public static void main(String[] args) throws AWTException, InterruptedException {
        int repeatnumber = 100;
        Robot robot = new Robot();
        String text = JOptionPane.showInputDialog("Spamlancak cümleyi girin (Standart olarak 100 kere atılacaktır)");
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection,null);
        repeatnumber = Integer.parseInt(JOptionPane.showInputDialog("Kaç kere tekrarlanacak?"));
        JOptionPane.showMessageDialog(null, "Spam 5 saniye içerisinde başlayacaktır", "Uyarı", JOptionPane.WARNING_MESSAGE);
        Thread.sleep(5000);
        for (int i = 0; i < repeatnumber; i++) {
            Thread.sleep(100);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

        }

    }
}