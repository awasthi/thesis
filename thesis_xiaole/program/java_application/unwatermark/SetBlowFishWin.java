/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author xiaolefang
 */
import java.awt.event.*;
import java.awt.*;
import java.io.File;
import javax.swing.*;

public class SetBlowFishWin extends JFrame {

    public GridBagConstraints c;
    public JButton load;
    public JTextField status1;
    public JCheckBox status;
    public JButton back;
    public JButton next;
    public String keyname = null;
    public int key_index = 0;
    public int key_save = 0;

    public void SetBlowFishWin() {
        setSize(600, 220);
        setLayout(new GridBagLayout());
        c = new GridBagConstraints();

        status1 = new JTextField(" ");
        next = new JButton("Next");
        back = new JButton("Back");
        status1.setEditable(false);
        status = new JCheckBox("Check it if your file add blowfish ecryption");
        load = new JButton("Load your key to ...");
        load.setEnabled(false);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 20;
        add(load, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 20;
        add(status1, c);


        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 20;
        add(status, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 10;
        c.gridy = 4;
        c.gridwidth = 10;
        add(next, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 10;
        add(back, c);

        event e = new event();
        status.addItemListener(e);


        load.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                JFileChooser chooser = new JFileChooser();
                int option = chooser.showOpenDialog(SetBlowFishWin.this);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File sf = chooser.getSelectedFile();
                    if (sf.getName().length() > 0) {
                        keyname = (sf.getPath());
                        key_save = 1;
                        status.setText("Blowfish ecryption tool is chosen! Load " + keyname);

                    } else {
                        key_save = 0;
                    }
                }
            }
        });
    }

    public class event implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            if (status.isSelected()) {
                load.setEnabled(true);
                key_index = 1;
                status.setText("Blowfish ecryption tool is chosen! Load " + keyname);

            } else {
                load.setEnabled(false);
                key_index = 0;
                status.setText("Check it if your file add blowfish ecryption");
            }
        }
    }
}
