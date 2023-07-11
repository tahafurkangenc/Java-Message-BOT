import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Main {
    public static void main(String[] args) throws AWTException, InterruptedException {
        Frame frame = new Frame();
        frame.setSize(300, 200);
        JButton button = new JButton("SPAM BAŞLAT");
        button.setBounds(50,75,200,50);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int repeatnumber = 100;
                Robot robot = null;
                try {
                    robot = new Robot();
                } catch (AWTException ex) {
                    throw new RuntimeException(ex);
                }
                String text = JOptionPane.showInputDialog(frame,"Spamlancak cümleyi girin (Standart olarak 100 kere atılacaktır)");
                StringSelection stringSelection = new StringSelection(text);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection,null);
                repeatnumber = Integer.parseInt(JOptionPane.showInputDialog(frame,"Kaç kere tekrarlanacak?"));
                JOptionPane.showMessageDialog(frame, "Spam 5 saniye içerisinde başlayacaktır", "Uyarı", JOptionPane.WARNING_MESSAGE);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                for (int i = 0; i < repeatnumber; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    robot.keyPress(KeyEvent.VK_CONTROL);
                    robot.keyPress(KeyEvent.VK_V);
                    robot.keyRelease(KeyEvent.VK_CONTROL);
                    robot.keyRelease(KeyEvent.VK_V);
                    robot.keyPress(KeyEvent.VK_ENTER);
                    robot.keyRelease(KeyEvent.VK_ENTER);
                }
                JOptionPane.showMessageDialog(frame, "Spam Bitmiştir", "Uyarı", JOptionPane.WARNING_MESSAGE);
            }
        });
        frame.add(button);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }
}