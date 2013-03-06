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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class BeginWin extends JFrame {

    public GridBagConstraints c;
    public JButton begin;
    public JTextField status1;
    public JTextField status2;

    public void BeginWin() {
        setSize(480, 220);
        setLayout(new GridBagLayout());
        c = new GridBagConstraints();

        status1 = new JTextField("This is a watermarking using chaotic property application.");
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
        
        final BeginWin bw = new BeginWin();
        bw.BeginWin();
        bw.setVisible(true);
        final LoadFileWin lfw = new LoadFileWin();
        lfw.LoadFileWin();
        lfw.setVisible(false);
        final LoadImageWin liw = new LoadImageWin();
        liw.LoadImageWin();
        lfw.setVisible(false);
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
        final FinishWin fw = new FinishWin();
        fw.FinishWin();
        fw.setVisible(false);


        bw.begin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                bw.setVisible(false);
                lfw.setVisible(true);
            }
        });


        lfw.back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                bw.setVisible(true);
                lfw.setVisible(false);
            }
        });
        lfw.next.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (lfw.file_index == 1) {
                    liw.status1.setText("You have pick " + lfw.filename + " as your input file");
                    liw.setVisible(true);
                    lfw.setVisible(false);

                    if (liw.img_index == 1) {
                        liw.f.setVisible(true);
                    }

                }

            }
        });

        liw.back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (liw.img_index == 1) {
                    liw.f.setVisible(false);
                }
                liw.setVisible(false);
                lfw.setVisible(true);
            }
        });
        liw.next.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if (liw.img_index == 1) {
                    liw.setVisible(false);
                    sbfw.status1.setText("You have pick " + lfw.filename + " as your input file");
                    sbfw.status2.setText("You have pick " + liw.imgname + " as your input image");
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

                    ssk.status1.setText("You have pick " + lfw.filename + " as your input file");
                    ssk.status2.setText("You have pick " + liw.imgname + " as your input image");
                    ssk.status3.setText("You enable blowfish, key will be save as " + sbfw.keyname);
                    sbfw.setVisible(true);
                    ssk.setVisible(true);
                    sbfw.setVisible(false);

                } else {
                    ssk.status1.setText("You have pick " + lfw.filename + " as your input file");
                    ssk.status2.setText("You have pick " + liw.imgname + " as your input image");
                    ssk.status3.setText("Blowfish is not enable");
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

                sw.status1.setText("You have pick " + lfw.filename + " as your input file");
                sw.status2.setText("You have pick " + liw.imgname + " as your input image");
                if (sbfw.key_index == 1 && sbfw.key_save == 1) {
                    sw.status3.setText("You enable blowfish, key will be save as " + sbfw.keyname);
                } else {
                    sw.status3.setText("Blowfish is not enable");
                }
                if (ssk.key_length > 0 && ssk.secret_key_index == 1) {
                    sw.status4.setText("You enable secret key, length is " + ssk.key_length);
                } else {
                    sw.status4.setText("Secret key is not enable");
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

                    ew.status1.setText("You have pick " + lfw.filename + " as your input file");
                    ew.status2.setText("You have pick " + liw.imgname + " as your input image");
                    if (sbfw.key_index == 1 && sbfw.key_save == 1) {
                        ew.status3.setText("You enable blowfish, key will be save as " + sbfw.keyname);
                    } else {
                        ew.status3.setText("Blowfish is not enable");
                    }
                    if (ssk.key_length > 0 && ssk.secret_key_index == 1) {
                        ew.status4.setText("You enable secret key, length is " + ssk.key_length);
                    } else {
                        ew.status4.setText("Secret key is not enable");
                    }
                    ew.status5.setText("You have pick " + sw.savefile + " as your output image");

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


                Crypitic_Graphic cg = new Crypitic_Graphic();
                if (sbfw.key_index == 1 && sbfw.key_save == 1) {
                    cg.set_up_ecrypt(sbfw.keyname);
                } else {
                    cg.set_off_ecrypt();
                }

                cg.key_length = ssk.key_length;

                try {
                    cg.process(lfw.filename, liw.imgname, sw.savefile);
                    if (cg.diff_en == 1) {
                        ew.status.setText("Finished! Ecrypted file length is " + cg.length + "; and secret "
                                + "key length is " + cg.key_length);
                        ew.finish = 1;

                        BufferedImage image = ImageIO.read(new File(sw.savefile));
                        LoadAndShow test = new LoadAndShow(image);
                        JFrame f = new JFrame();
                        f.add(new JScrollPane(test));
                        f.setSize(400, 400);
                        f.setLocation(200, 200);
                        f.setVisible(true);
                        
                        cg.diff();

                        ew.setVisible(false);
                        fw.status1.setText("You have pick " + lfw.filename + " as your input file");
                        fw.status2.setText("You have pick " + liw.imgname + " as your input image");
                        if (sbfw.key_index == 1 && sbfw.key_save == 1) {
                            fw.status3.setText("You enable blowfish, key will be save as " + sbfw.keyname);
                        } else {
                            fw.status3.setText("Blowfish is not enable");
                        }
                        if (ssk.key_length > 0 && ssk.secret_key_index == 1) {
                            fw.status4.setText("You enable secret key, length is " + ssk.key_length);
                        } else {
                            fw.status4.setText("Secret key is not enable");
                        }
                        fw.status5.setText("You have pick " + sw.savefile + " as your output image");
                        fw.status6.setText("Encrypted file length is " + cg.length + ", secret key length is " + cg.key_length);
                        fw.setVisible(true);
                    } else {
                        fw.status.setText("Only support <png> and <bmp> format image! Please modify! ");
                    }

                } catch (Exception ex) {
                    ew.status.setText("Error happen when executing watermarking");
                    Logger.getLogger(BeginWin.class.getName()).log(Level.SEVERE, null, ex);
                }


            }
        });

        fw.end.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                fw.setVisible(false);
                bw.setVisible(true);

                lfw.file_index = 0;
                lfw.filename = null;
                lfw.status.setText("Please import your file by click the <Load file> button");

                liw.img_index = 0;
                liw.imgname = null;
                liw.status2.setText("Please import your image by click the <Load image> button");

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
            }
        });

    }
}
