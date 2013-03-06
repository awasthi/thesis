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
public class FinishWin extends Frame{
    public GridBagConstraints c;
    public JTextField status1;
    public JTextField status2;
    public JTextField status3;
    public JTextField status4;
    public JTextField status5;
    public JTextField status6;
    public JTextField status;
    public JButton end;
    
    public void FinishWin()
    {
        
        setSize(900, 420);
        setLayout(new GridBagLayout());
        c = new GridBagConstraints();

        status1 = new JTextField(" ");
        status2 = new JTextField(" ");
        status3 = new JTextField(" ");
        status4 = new JTextField(" ");
        status5 = new JTextField(" ");
        status6 = new JTextField(" ");
        end = new JButton("Back to Start");
        status1.setEditable(false);
        status2.setEditable(false);
        status3.setEditable(false);
        status4.setEditable(false);
        status5.setEditable(false);
        status6.setEditable(false);
        
        status = new JTextField("Click <Show the differences> to show the differences");
        status.setEditable(false);

        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 10;
        c.gridy = 5;
        c.gridwidth = 10;
        add(status, c);

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
        c.gridwidth = 20;
        add(status5, c);
        
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 7;
        c.gridwidth = 20;
        add(status6, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 10;
        add(end, c);
        

    }

}
