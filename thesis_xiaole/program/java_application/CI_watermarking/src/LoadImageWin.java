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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class LoadImageWin extends JFrame {

    public GridBagConstraints c;
    public JButton load;
    public JTextField status1;
    public JTextField status2;
    public JButton back;
    public JButton next;
    public String imgname;
    public int img_index = 0;
    public JFrame f;

    public void LoadImageWin() {
        setSize(480, 220);
        setLayout(new GridBagLayout());
        c = new GridBagConstraints();

        status1 = new JTextField(" ");
        status2 = new JTextField("Please import your image by click the <Load image> button");
        load = new JButton("Load image");
        next = new JButton("Next");
        back = new JButton("Back");
        status1.setEditable(false);
        status2.setEditable(false);

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
        add(load, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 10;
        c.gridy = 3;
        c.gridwidth = 10;
        add(next, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 10;
        add(back, c);


        load.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                JFileChooser chooser = new JFileChooser();
                chooser.setMultiSelectionEnabled(true);
                int option = chooser.showOpenDialog(LoadImageWin.this);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File[] sf = chooser.getSelectedFiles();
                    if (sf.length > 0) {
                        if(img_index == 1)
                        {
                            f.setVisible(false);
                        }
                        imgname = (sf[0].getPath());
                        status2.setText(imgname + " is chosen!");
                        img_index = 1;
                        try {

                            BufferedImage image = ImageIO.read(new File(imgname));
                            LoadAndShow test = new LoadAndShow(image);
                            f = new JFrame();
                            //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            f.add(new JScrollPane(test));
                            f.setSize(400, 400);
                            f.setLocation(200, 200);
                            f.setVisible(true);


                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            status2.setText("can not display your image!");
                        }
                    } else {
                        imgname = null;
                        status2.setText("Please choose your image!");
                    }
                }

            }
        });
    }
}
