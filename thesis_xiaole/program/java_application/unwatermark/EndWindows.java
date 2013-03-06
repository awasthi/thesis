/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author xiaolefang
 */
import java.awt.*;
import javax.swing.*;

public class EndWindows extends JFrame {
    public GridBagConstraints c;
    public JButton load;
    public JTextField status1;
    public JTextField status2;
    public JTextField status3;
    public JTextField status4;
    public JTextField status;
    public JButton back;
    public int finish = 0;
    public JLabel length;
    public JTextField length_input;
    
    public void EndWindows()
    {
        setSize(900, 420);
        setLayout(new GridBagLayout());
        c = new GridBagConstraints();

        status1 = new JTextField(" ");
        status2 = new JTextField(" ");
        status3 = new JTextField(" ");
        status4 = new JTextField(" ");
        length_input = new JTextField(" ");
        back = new JButton("Back");
        length = new JLabel("Set your encrypted file length");
        status1.setEditable(false);
        status2.setEditable(false);
        status3.setEditable(false);
        status4.setEditable(false);
        
        status = new JTextField("Continue with clicking <Begin to Process!>");
        status.setEditable(false);
        load = new JButton("Begin to Process!");
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 10;
        c.gridy = 5;
        c.gridwidth = 10;
        add(status, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 10;
        add(load, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 20;
        add(status1, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 20;
        add(status2, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 20;
        add(status3, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 20;
        add(status4, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 10;
        add(length, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 10;
        c.gridy = 4;
        c.gridwidth = 10;
        add(length_input, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 10;
        add(back, c);
        
    }
}
