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

public class BeginWindows extends JFrame {

    public GridBagConstraints c;
    public JButton begin;
    public JTextField status1;
    public JTextField status2;

    public void BeginWindows() {
        setSize(800, 420);
        setLayout(new GridBagLayout());
        c = new GridBagConstraints();

        status1 = new JTextField("This is a unwatermarking application for corresponing watermarked Graphics");
        status2 = new JTextField("Click the <Begin> button to start!");
        status1.setEditable(false);
        status2.setEditable(false);
        begin = new JButton("Begin");


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
        add(begin, c);
    }

    public static void main(String[] args) {
        final BeginWindows bw = new BeginWindows();
        bw.BeginWindows();
        bw.setVisible(true);
        final LoadImageWin liw = new LoadImageWin();
        liw.LoadImageWin();
        liw.setVisible(false);
        final SetBlowFishWin sbfw = new SetBlowFishWin();
        sbfw.SetBlowFishWin();
        sbfw.setVisible(false);
        final SetSecretKey ssk = new SetSecretKey();
        ssk.SetSecretKey();
        ssk.setVisible(false);
        final SaveWindows sw = new SaveWindows();
        sw.SaveWindows();
        sw.setVisible(false);
        final EndWindows ew = new EndWindows();
        ew.EndWindows();
        ew.setVisible(false);
        


        bw.begin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                bw.setVisible(false);
                liw.setVisible(true);
                if (liw.img_index == 1) {
                    liw.f.setVisible(true);
                }
            }
        });

        liw.back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (liw.img_index == 1) {
                    liw.f.setVisible(false);
                }
                bw.setVisible(true);
                liw.setVisible(false);
            }
        });
        liw.next.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (liw.img_index == 1) {
                    liw.setVisible(false);
                    sbfw.status1.setText("You have pick " + liw.imgname + " as your decording image");
                    sbfw.setVisible(true);
                }


            }
        });

        sbfw.back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                liw.setVisible(true);
                sbfw.setVisible(false);
            }
        });
        sbfw.next.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (sbfw.key_index == 1 && sbfw.key_save == 1) {

                    ssk.status1.setText("You have pick " + liw.imgname + " as your input image");
                    ssk.status2.setText("You enable blowfish, key will be load from " + sbfw.keyname);
                    sbfw.setVisible(true);
                    ssk.setVisible(true);
                    sbfw.setVisible(false);

                } else {
                    ssk.status1.setText("You have pick " + liw.imgname + " as your input image");
                    ssk.status2.setText("Blowfish is not enable");
                    ssk.setVisible(true);
                    sbfw.setVisible(false);
                }

            }
        });

        ssk.back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                sbfw.setVisible(true);
                ssk.setVisible(false);
            }
        });
        ssk.next.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                sw.status1.setText("You have pick " + liw.imgname + " as your input image");
                if (sbfw.key_index == 1 && sbfw.key_save == 1) {
                    sw.status2.setText("You enable blowfish, key is loaded from " + sbfw.keyname);
                } else {
                    sw.status2.setText("Blowfish is not enable");
                }
                if (ssk.key_length > 0 && ssk.secret_key_index == 1) {
                    sw.status3.setText("You enable secret key, length is " + ssk.key_length);
                } else {
                    sw.status3.setText("Secret key is not enable");
                }
                sw.setVisible(true);
                ssk.setVisible(false);


            }
        });

        sw.back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                sw.setVisible(false);
                ssk.setVisible(true);
            }
        });
        sw.next.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                if (sw.savefile_index == 1) {
                    ew.status1.setText("You have pick " + liw.imgname + " as your input image");
                    if (sbfw.key_index == 1 && sbfw.key_save == 1) {
                        ew.status2.setText("You enable blowfish, key is loaded from " + sbfw.keyname);
                    } else {
                        ew.status2.setText("Blowfish is not enable");
                    }
                    if (ssk.key_length > 0 && ssk.secret_key_index == 1) {
                        ew.status3.setText("You enable secret key, length is " + ssk.key_length);
                    } else {
                        ew.status3.setText("Secret key is not enable");
                    }
                    ew.status4.setText("You have pick " + sw.savefile + " as your output file");

                    ew.setVisible(true);
                    sw.setVisible(false);

                }
            }
        });

        ew.back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                ew.setVisible(false);
                sw.setVisible(true);
            }
        });
        ew.load.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                Uncrypitic_Graphic ug = new Uncrypitic_Graphic();

                if (sbfw.key_index == 1 && sbfw.key_save == 1) {
                    ug.set_up_ecrypt(sbfw.keyname);
                } else {
                    ug.set_off_ecrypt();
                }

                ug.secret_key_length = ssk.key_length;

                try {
                    ug.length = (int) Double.parseDouble(ew.length_input.getText());
                    if (ug.length > 0) {
                        try {
                            ug.process(liw.imgname, sw.savefile);
                            if (ug.diff_en == 1) {
                                ew.status.setText("Finished! ");
                                ew.setVisible(false);
                                bw.setVisible(true);

                                liw.img_index = 0;
                                liw.imgname = null;
                                liw.status1.setText("Please import your image by click the <Load image> button");

                                sbfw.key_index = 0;
                                sbfw.keyname = null;
                                sbfw.key_save = 0;
                                sbfw.status.setSelected(false);
                                sbfw.status.setText("Check it if you want to add blowfish ecrytion to your file!");

                                ssk.status.setSelected(false);
                                ssk.status.setText("Check it if you want to add"
                                        + " secret key to your file!");
                                ssk.Length_text.setText("0");
                                ssk.key_length = 0;
                                ssk.secret_key_index = 0;

                                sw.savefile = null;
                                sw.savefile_index = 0;
                                sw.status.setText("Select the position to save your watermarked image by clicking "
                                        + "<SaveAs>");
                                
                                ew.status.setText("Continue with clicking <Begin to Process!>");
                                ew.length_input.setText("0");

                            } else {
                                ew.status.setText("Error happen when executing unwatermarking ");
                            }

                        } catch (Exception ex) {
                            ew.status.setText("Error happen when executing unwatermarking");
                            // Logger.getLogger(BeginWindows.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        ew.status.setText("Illegel data field of input length");
                    }
                } catch (NumberFormatException e) {
                    ew.status.setText("Illegel data field of input length");
                }




            }
        });
    }
}
