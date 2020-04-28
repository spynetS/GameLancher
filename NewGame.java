package com.SpySoftware;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

public class NewGame {
    public JPanel panel1;
    private JButton ALLButton;
    private JList list1;
    private JButton RUNButton;
    private JButton steambut;
    private JButton originbut;
    private JButton epicgamesbut;
    private JButton otherbut;
    private JButton RUNButton1;
    public DefaultListModel<String> Listmodel = new DefaultListModel<>();

    public NewGame() {
        try {
            LoadAllList("allgames");
        } catch (Exception e) {
            e.printStackTrace();
        }
        list1.setModel(Listmodel);


        ALLButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ALLButton.setContentAreaFilled(true);
                steambut.setContentAreaFilled(false);
                originbut.setContentAreaFilled(false);
                epicgamesbut.setContentAreaFilled(false);
                otherbut.setContentAreaFilled(false);
                try {
                    Listmodel.clear();
                    LoadAllList("allgames");
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        steambut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ALLButton.setContentAreaFilled(false);
                steambut.setContentAreaFilled(true);
                originbut.setContentAreaFilled(false);
                epicgamesbut.setContentAreaFilled(false);
                otherbut.setContentAreaFilled(false);
                try {
                    Listmodel.clear();
                    LoadAllList("steamgames");
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        originbut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ALLButton.setContentAreaFilled(false);
                steambut.setContentAreaFilled(false);
                originbut.setContentAreaFilled(true);
                epicgamesbut.setContentAreaFilled(false);
                otherbut.setContentAreaFilled(false);
                try {
                    Listmodel.clear();
                    LoadAllList("origingames");
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        epicgamesbut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ALLButton.setContentAreaFilled(false);
                steambut.setContentAreaFilled(false);
                originbut.setContentAreaFilled(false);
                epicgamesbut.setContentAreaFilled(true);
                otherbut.setContentAreaFilled(false);
                try {
                    Listmodel.clear();
                    LoadAllList("epicgames");
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        otherbut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ALLButton.setContentAreaFilled(false);
                steambut.setContentAreaFilled(false);
                originbut.setContentAreaFilled(false);
                epicgamesbut.setContentAreaFilled(false);
                otherbut.setContentAreaFilled(true);
                try {
                    Listmodel.clear();
                    LoadAllList("othergames");
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }

    private void LoadAllList(String pathname)throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("src/com/SpySoftware/Filer/"+pathname+".txt"));
        String currentline;
        while((currentline=br.readLine())!=null)
        {
            Listmodel.addElement(currentline);
        }
    }
}
