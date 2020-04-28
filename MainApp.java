package com.SpySoftware;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.image.BufferedImage;
import java.util.EventListener;
import java.util.TimerTask;
import javax.swing.JPanel;
import javax.swing.filechooser.FileSystemView;

public class MainApp {
    public JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JButton addGameButton;
    public DefaultListModel<String> allmodel = new DefaultListModel<>();
    public DefaultListModel<String> steammodel = new DefaultListModel<>();
    public DefaultListModel<String> originmodel = new DefaultListModel<>();
    public DefaultListModel<String> epicgamesmodel = new DefaultListModel<>();
    public DefaultListModel<String> othermodel = new DefaultListModel<>();
    private JList list1;
    private JList list2;
    private JList list3;
    private JPanel panelRight;
    private JLabel iconlabel;
    private JButton RUNButton;
    private JButton removeGameButton;
    private JButton refreshButton;
    private JList list4;
    private JList list5;
    private JButton logoutButton;
    String steamGames = "src/com/SpySoftware/Filer/steamgames.txt";
    String originGames = "src/com/SpySoftware/Filer/origingames.txt";
    String epicGames = "src/com/SpySoftware/Filer/epicgames.txt";
    String allGames = "src/com/SpySoftware/Filer/allgames.txt";
    String otherGames = "src/com/SpySoftware/Filer/othergames.txt";
    boolean runIble=true;
    private BufferedImage image;

    public MainApp() {


        list1.setModel(allmodel);
        list2.setModel(steammodel);
        list3.setModel(originmodel);
        list4.setModel(epicgamesmodel);
        list5.setModel(othermodel);
        try {
            LoadAllGames(allGames);

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
         LoadSteamGames(steamGames);

    } catch (Exception e) {
        e.printStackTrace();
    }try {
        LoadOriginGames(originGames);

    } catch (Exception e) {
        e.printStackTrace();
    }try {
            LoadEpicGamesGames(epicGames);

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            LoadOtherGames(otherGames);

        } catch (Exception e) {
            e.printStackTrace();
        }

        list1.setSelectedIndex(0);
        try {
            Icon("steam/"+list1.getSelectedValue().toString());
        }
        catch (Exception ee)
        {

        }
        try {
            Icon("origin/"+list1.getSelectedValue().toString());
        }
        catch (Exception eee)
        {

        }
        try {
            Icon("epicgames/"+list1.getSelectedValue().toString());
        }
        catch (Exception eee)
        {

        }
        try {
            Icon("other/"+list1.getSelectedValue().toString());
        }
        catch (Exception eee)
        {

        }

        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                super.mouseClicked(evt);
                try {
                    Icon("steam/"+list1.getSelectedValue().toString());
                    Click(evt,list1);
                }
                catch (Exception e)
                {

                }
                try {
                    Icon("origin/"+list1.getSelectedValue().toString());
                    Click(evt,list1);
                }
                catch (Exception e)
                {

                }
                try {
                    Icon("epicgames/"+list1.getSelectedValue().toString());
                    Click(evt,list1);
                }
                catch (Exception e)
                {

                }
                try {
                    Icon("other/"+list1.getSelectedValue().toString());
                    Click(evt,list1);
                }
                catch (Exception e)
                {

                }
            }
        });
        addGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileWindow();
            }
        });
        RUNButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(tabbedPane1.getSelectedIndex()==0)
                    {
                        OpenGame(list1.getSelectedValue().toString());
                    }
                    else if(tabbedPane1.getSelectedIndex()==1)
                    {
                        OpenGame(list2.getSelectedValue().toString());

                    }
                    else if(tabbedPane1.getSelectedIndex()==2)
                    {
                        OpenGame(list3.getSelectedValue().toString());

                    }
                    else if(tabbedPane1.getSelectedIndex()==3)
                    {
                        OpenGame(list4.getSelectedValue().toString());

                    }
                    else if(tabbedPane1.getSelectedIndex()==4)
                    {
                        OpenGame(list5.getSelectedValue().toString());

                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        list1.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
                super.componentMoved(e);
                System.out.println("moved");
            }
        });

        list2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Icon("steam/"+list2.getSelectedValue().toString());
                Click(e,list2);
            }
        });

        list3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Icon("origin/"+list3.getSelectedValue().toString());
                Click(e,list3);
            }
        });
        removeGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allmodel.clear();
                try {
                    LoadAllGames(allGames);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        list4.addComponentListener(new ComponentAdapter() {
        });
        list4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Icon("epicgames/"+list4.getSelectedValue().toString());
                Click(e,list4);
            }
        });
        list5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Click(e,list5);

            }
        });
        list5.addComponentListener(new ComponentAdapter() {
        });
        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    Icon("steam/"+list1.getSelectedValue().toString());
                }
                catch (Exception ee)
                {

                }
                try {
                    Icon("origin/"+list1.getSelectedValue().toString());
                }
                catch (Exception eee)
                {

                }
                try {
                    Icon("epicgames/"+list1.getSelectedValue().toString());
                }
                catch (Exception eee)
                {

                }
                try {
                    Icon("other/"+list1.getSelectedValue().toString());
                }
                catch (Exception eee)
                {

                }
            }
        });
        list2.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Icon("steam/"+list2.getSelectedValue().toString());
            }
        });
        list3.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Icon("origin/"+list3.getSelectedValue().toString());
            }
        });
        list4.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Icon("epicgames/"+list4.getSelectedValue().toString());
            }
        });
        list5.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Icon("other/"+list5.getSelectedValue().toString());
            }
        });
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Logout();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            private void Logout()throws Exception {
                FileWriter fw = new FileWriter("src/com/SpySoftware/Filer/KeepLogin.txt");
                fw.write("0");
                fw.close();
                new Main().Login();

            }

        });
    }

    private void LoadOtherGames(String path)throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String currentline;

        while((currentline=br.readLine())!=null)
        {
            othermodel.addElement(currentline);
        }
    }

    void Click(MouseEvent evt,JList list1)
    {
        JList list = (JList)evt.getSource();
        if (evt.getClickCount() == 2) {
            // Double-click detected
            int index = list.locationToIndex(evt.getPoint());
        } else if (evt.getClickCount() == 3) {
            try {
                OpenGame(list1.getSelectedValue().toString());
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Triple-click detected
            int index = list.locationToIndex(evt.getPoint());
        }

    }

    void Icon(String fileName)
    {
        File File = new File("src/com/SpySoftware/Filer/Games/"+fileName);
        ImageIcon icon = (ImageIcon) FileSystemView.getFileSystemView().getSystemIcon(File);

        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(300, 310,  Image.SCALE_REPLICATE);
        ImageIcon newIcon = new ImageIcon(newimg);

        iconlabel.setSize(300,300);
        iconlabel.setIcon(newIcon);

    }

    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

    void FileWindow()
    {
        String selectedFileName = null;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(new Main().frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile= fileChooser.getSelectedFile();
            Path from = Paths.get(String.valueOf(selectedFile));
            selectedFileName = selectedFile.getName();
            Main m = new Main();
            JDialog d = new JDialog(m.frame, "dialog Box");

            // create a label
            JRadioButton steam = new JRadioButton("Steam");
            JRadioButton origin = new JRadioButton("Origin");
            JRadioButton EpicGames = new JRadioButton("EpicGames");
            JRadioButton other = new JRadioButton("other");
            JButton done = new JButton("done");
            JPanel p = new JPanel();
            p.add(steam);
            p.add(origin);
            p.add(EpicGames);
            p.add(other);
            p.add(done);
            d.add(p);

            // setsize of dialog
            d.setSize(200, 200);

            // set visibility of dialog
            d.setVisible(true);
            String finalSelectedFileName = selectedFileName;
            String finalSelectedFileName1 = selectedFileName;
            done.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(steam.isSelected())
                    {
                        try {
                            Path to = Paths.get("src/com/SpySoftware/Filer/Games/steam/"+ finalSelectedFileName1);

                            Files.copy(from, to);
                        } catch (IOException ee) {
                            ee.printStackTrace();
                        }

                    }
                    if(origin.isSelected())
                    {
                        try {
                            Path to = Paths.get("src/com/SpySoftware/Filer/Games/origin/"+ finalSelectedFileName1);

                            Files.copy(from, to);
                        } catch (IOException ee) {
                            ee.printStackTrace();
                        }
                    }
                    if(EpicGames.isSelected())
                    {
                        try {
                            Path to = Paths.get("src/com/SpySoftware/Filer/Games/epicgames/"+ finalSelectedFileName1);

                            Files.copy(from, to);
                        } catch (IOException ee) {
                            ee.printStackTrace();
                        }
                    }
                    if(other.isSelected())
                    {
                        try {
                            Path to = Paths.get("src/com/SpySoftware/Filer/Games/other/"+ finalSelectedFileName1);

                            Files.copy(from, to);
                        } catch (IOException ee) {
                            ee.printStackTrace();
                        }
                    }
                    d.setVisible(false);
                    allmodel.clear();
                    try {
                        new Main().CheckGames();
                        LoadAllGames(allGames);
                        LoadSteamGames(steamGames);
                        LoadOriginGames(originGames);
                        LoadEpicGamesGames(epicGames);

                    } catch (Exception ee) {
                        ee.printStackTrace();
                    }

                }
            });

        }



    }

    private void Write(String path,String name) throws Exception {
        FileWriter fw = new FileWriter(path,true);
        fw.write(name);
        fw.write("\n");
        fw.close();

    }

    void OpenGame(String name) throws Exception
    {
        if(runIble) {
            runIble = false;
            RUNButton.setEnabled(false);



            try {
                File file = new File("src/com/SpySoftware/Filer/Games/steam/" + name);

                Desktop.getDesktop().open(file);
            } catch (Exception ex) {
                try {
                    File file = new File("src/com/SpySoftware/Filer/Games/origin/" + name);

                    Desktop.getDesktop().open(file);
                } catch (Exception edx) {
                    try {
                        File file = new File("src/com/SpySoftware/Filer/Games/epicgames/" + name);

                        Desktop.getDesktop().open(file);
                    } catch (Exception eddx) {
                    } try {
                        File file = new File("src/com/SpySoftware/Filer/Games/other/" + name);

                        Desktop.getDesktop().open(file);
                    } catch (Exception edddx) {
                    }
                }
            }


            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            RUNButton.setEnabled(true);
                            runIble=true;
                        }
                    },
                    5000
            );
        }
    }




    public void LoadAllGames(String path1) throws Exception
    {
        BufferedReader br = new BufferedReader(new FileReader(path1));
        String currentline;
        int currentlistline=0;

        while((currentline=br.readLine())!=null) {
            allmodel.addElement(currentline);
            File File = new File("src/com/SpySoftware/Filer/Games/" + currentline);
            Icon icon = FileSystemView.getFileSystemView().getSystemIcon(File);

        }

    }

    public void LoadSteamGames(String path) throws Exception
    {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String currentline;

        while((currentline=br.readLine())!=null)
        {
            steammodel.addElement(currentline);
        }
    }
    public void LoadOriginGames(String path) throws Exception
    {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String currentline;

        while((currentline=br.readLine())!=null)
        {
            originmodel.addElement(currentline);
        }
    }
    public void LoadEpicGamesGames(String path) throws Exception
    {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String currentline;

        while((currentline=br.readLine())!=null)
        {
            epicgamesmodel.addElement(currentline);
        }
    }


}
