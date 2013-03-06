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
import javax.swing.*;

public class SetSecretKey extends JFrame {

    public GridBagConstraints c;
    public JButton load;
    public JTextField status1;
    public JTextField status2;
    public JTextField Length_text;
    public JCheckBox status;
    public JButton back;
    public JButton next;
    public int key_length = 0;
    public int secret_key_index = 0;

    public void SetSecretKey() {
        setSize(600, 220);
        setLayout(new GridBagLayout());
        c = new GridBagConstraints();

        status1 = new JTextField(" ");
        status2 = new JTextField(" ");
        next = new JButton("Next");
        back = new JButton("Back");
        status1.setEditable(false);
        status2.setEditable(false);
        status = new JCheckBox("Check it if your image has added"
                + " secret key to your file!");
        load = new JButton("Set your key length");
        Length_text = new JTextField("0");
        load.setEnabled(false);
        Length_text.setEditable(false);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 10;
        add(status, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 10;
        add(load, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 10;
        c.gridy = 4;
        c.gridwidth = 10;
        add(Length_text, c);

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
        c.gridx = 10;
        c.gridy = 5;
        c.gridwidth = 10;
        add(next, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 10;
        add(back, c);


        event e = new event();
        status.addItemListener(e);

        load.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    key_length = (int) Double.parseDouble(Length_text.getText());
                    if (key_length > 0) {
                        status.setText("You add secret key, "
                            + "length is " + key_length);
                    } else {
                        status.setText("Illegel data field");
                    }
                } catch (NumberFormatException e) {
                    status.setText("Illegel data field");
                }
            }
        });
    }

    public class event implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            if (status.isSelected()) {
                load.setEnabled(true);
                Length_text.setEditable(true);
                secret_key_index = 1;
                if (key_length != 0) {
                    status.setText("You have load secret key, "
                            + "length is " + key_length);
                }

            } else {
                load.setEnabled(false);
                Length_text.setEditable(false);
                secret_key_index = 0;
                status.setText("Check it if your image has added"
                        + " secret key to your file!");

            }
        }
    }
}
