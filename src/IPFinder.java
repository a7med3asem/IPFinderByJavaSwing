import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;


public class IPFinder{
    private JFrame frame;
    private JLabel enterLabel;
    private JTextField enterField;
    private JButton findButton;

    public IPFinder(){
        frame = new JFrame();
        frame.setLayout(null);
        frame.setBounds(50, 50, 500, 300);
        frame.setTitle("IP Finder tool");

        enterLabel = new JLabel("Enter URL");
        enterLabel.setBounds(100, 50, 60, 20);

        enterField = new JTextField();
        enterField.setBounds(160, 50, 200, 20);

        findButton = new JButton("Find IP");
        findButton.setBounds(200, 100, 100, 70);
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InetAddress ip = null;
                try {
                    //ip = InetAddress.getByName(new URL(enterField.getText()).getHost());
                    ip = InetAddress.getByName(enterField.getText().substring(enterField.getText().indexOf("www")));
                } catch (UnknownHostException unknownHostException) {
                    unknownHostException.printStackTrace();
                } //catch (MalformedURLException malformedURLException){malformedURLException.printStackTrace();}
                JOptionPane.showMessageDialog(frame,
                        "URL: \"" + enterField.getText() + "\"\nIP: " + ip.getHostAddress(), "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        frame.add(enterLabel);
        frame.add(enterField);
        frame.add(findButton);

        frame.setVisible(true);
    }

    public static void main(String... args){
        IPFinder ipFinder = new IPFinder();
    }
}
