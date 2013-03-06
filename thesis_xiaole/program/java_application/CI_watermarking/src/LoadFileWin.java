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

public class LoadFileWin extends JFrame {

    public GridBagConstraints c;
    public JButton load;
    public JTextField status;
    public JButton back;
    public JButton next;
    public String filename;
    public int file_index = 0;

    public void LoadFileWin() {


        setSize(480, 220);
        setLayout(new GridBagLayout());
        c = new GridBagConstraints();


        status = new JTextField("Please import your file by click the <Load file> button");
        load = new JButton("Load file");
        next = new JButton("Next");
        back = new JButton("Back");
        status.setEditable(false);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 20;
        add(status, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 20;
        add(load, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 10;
        c.gridy = 2;
        c.gridwidth = 10;
        add(next, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 10;
        add(back, c);

        load.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                JFileChooser chooser = new JFileChooser();
                chooser.setMultiSelectionEnabled(true);
                int option = chooser.showOpenDialog(LoadFileWin.this);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File[] sf = chooser.getSelectedFiles();
                    if (sf.length > 0) {
                        filename = (sf[0].getPath());
                        file_index = 1;
                        status.setText(filename + " is chosen!");
                    } else {
                        filename = null;
                        file_index = 0;
                        status.setText("Please choose your file!");
                    }
                }
            }
        });


    }

}
