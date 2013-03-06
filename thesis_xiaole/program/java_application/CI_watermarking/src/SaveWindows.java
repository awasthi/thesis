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

public class SaveWindows extends JFrame {

    public GridBagConstraints c;
    public JButton load;
    public JTextField status1;
    public JTextField status2;
    public JTextField status3;
    public JTextField status4;
    public JTextField status;
    public JButton next;
    public JButton back;
    public String savefile = null;
    public int savefile_index = 0;

    public void SaveWindows() {
        setSize(600, 220);
        setLayout(new GridBagLayout());
        c = new GridBagConstraints();

        status1 = new JTextField(" ");
        status2 = new JTextField(" ");
        status3 = new JTextField(" ");
        status4 = new JTextField(" ");
        back = new JButton("Back");
        next = new JButton("Next");
        status1.setEditable(false);
        status2.setEditable(false);
        status3.setEditable(false);
        status4.setEditable(false);

        status = new JTextField("Select the position to save your watermarked image by clicking "
                + "<SaveAs>");
        status.setEditable(false);
        load = new JButton("SaveAs");

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 10;
        add(status, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 6;
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
        c.gridy = 7;
        c.gridwidth = 10;
        add(back, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 10;
        c.gridy = 7;
        c.gridwidth = 10;
        add(next, c);


        load.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                JFileChooser chooser = new JFileChooser();

                int option = chooser.showSaveDialog(SaveWindows.this);

                if (option == JFileChooser.APPROVE_OPTION) {
                    File sf = chooser.getSelectedFile();
                    if (sf.getName().length() > 0) {
                        savefile = (sf.getPath());
                        status.setText(savefile + " will be the save as file!");
                        savefile_index = 1;
                    } else {
                        savefile = null;
                        status.setText("Select the position to save your watermarked image by clicking "
                                + "<SaveAs>");
                        savefile_index = 0;
                    }

                }


            }
        });

    }
}
