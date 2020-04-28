package com.SpySoftware;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class gui {
    public JPanel panel1;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JCheckBox keepMeLogedInCheckBox;
    private JButton forgorPasswordButton;
    private JButton signup;
    String passwordfile = "src/com/SpySoftware/Filer/password.txt";


    public gui() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Login();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        forgorPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame signup = new JFrame("Sign up");
                signup.setSize(400,150);
                JPanel p = new JPanel();
                JLabel lab = new JLabel("Want town was the first you lived in?");
                JTextField ans = new JTextField();
                JLabel lab1 = new JLabel();
                JButton test = new JButton("Done");
                p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

                test.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            CheckAns(ans.getText(),lab1);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }

                    private void CheckAns(String ans,JLabel lab)throws Exception{
                        BufferedReader br = new BufferedReader(new FileReader("src/com/SpySoftware/Filer/ans.txt"));
                        if(ans.equals(br.readLine()))
                        {
                            BufferedReader br1 = new BufferedReader(new FileReader("src/com/SpySoftware/Filer/password.txt"));
                            lab.setText("Your password is "+br1.readLine());
                        }
                    }
                });

                signup.add(p);
                p.add(lab);
                p.add(ans);
                p.add(lab1);
                p.add(test);

                signup.setVisible(true);
            }
        });
        signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame signup = new JFrame("Sign up");
                signup.setSize(400,150);
                JPanel p = new JPanel();
                JLabel lab = new JLabel("Write the first town you lived in");
                JLabel lab1 = new JLabel("Password");
                JTextField ans=new JTextField();
                JTextField pas = new JTextField();
                JButton signUpBut = new JButton("Sign up");
                p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

                signUpBut.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            NewAcount(ans.getText(),pas.getText());
                            ans.getText().equals("");
                            pas.getText().equals("");
                            signup.dispose();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });




                p.add(lab);
                p.add(ans);
                p.add(lab1);
                p.add(pas);
                p.add(signUpBut);
                signup.add(p);


                signup.setVisible(true);
            }
        });
    }
    void NewAcount(String ans,String pass)throws Exception
    {
        FileWriter fw = new FileWriter("src/com/SpySoftware/Filer/ans.txt");
        fw.write(ans);
        fw.close();
        FileWriter fww = new FileWriter("src/com/SpySoftware/Filer/password.txt");
        fww.write(pass);
        fww.close();


    }

    void Login()throws Exception

    {
        BufferedReader br = new BufferedReader(new FileReader(passwordfile));
        String currentline;
        while((currentline=br.readLine())!=null)
        {
            if(currentline.equals(passwordField1.getText()))
            {
                FileWriter fw = new FileWriter("src/com/SpySoftware/Filer/KeepLogin.txt");
                if(keepMeLogedInCheckBox.isSelected())
                {
                    fw.write("1");
                }
                else
                {
                    fw.write("0");
                }
                fw.close();
                Main m = new Main();
                m.MainApp();
            }
            else
            {

            }
        }

    }

}
