package com.SpySoftware;

import javax.swing.*;
import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;


public class Main {
    String logedinfile = "src/com/SpySoftware/Filer/KeepLogin.txt";
    public JFrame loginframe;
    public JFrame frame;
    public void CheckGames() throws Exception
    {
        if(new File("src/com/SpySoftware/Filer/allgames.txt").delete())
        {
            System.out.println("del");
        }
        if(new File("src/com/SpySoftware/Filer/origingames.txt").delete())
        {
            System.out.println("del");
        }
        if(new File("src/com/SpySoftware/Filer/steamgames.txt").delete())
        {
            System.out.println("del");
        }
        if(new File("src/com/SpySoftware/Filer/othergames.txt").delete())
        {
            System.out.println("del");
        }
        if(new File("src/com/SpySoftware/Filer/allgames.txt").delete())
        {
            System.out.println("del");
        }
        for(int i =0;i<=3;i++) {
            String[] pathnames;

            if(i==0)
            {
                FileWriter fw1 = new FileWriter("src/com/SpySoftware/Filer/allgames.txt",false);
                fw1.write("");
                fw1.close();
                FileWriter fw = new FileWriter("src/com/SpySoftware/Filer/allgames.txt",true);
                File steam = new File("src/com/SpySoftware/Filer/Games/steam");
                String path = "src/com/SpySoftware/Filer/steamgames.txt";
                pathnames = steam.list();
                BufferedWriter bw = new BufferedWriter(new FileWriter(path, false));
                // For each pathname in the pathnames array
                for (String pathname : pathnames) {
                    // Print the names of files and directories
                    System.out.println(pathname);
                    bw.write(pathname);
                    bw.write("\n");
                    fw.write(pathname+"\n");
                }
                bw.close();
                fw.close();
            }
            else if(i==1)
            {
                FileWriter fw = new FileWriter("src/com/SpySoftware/Filer/allgames.txt",true);
                File steam = new File("src/com/SpySoftware/Filer/Games/origin");
                String path = "src/com/SpySoftware/Filer/origingames.txt";
                pathnames = steam.list();
                BufferedWriter bw = new BufferedWriter(new FileWriter(path, false));
                // For each pathname in the pathnames array
                for (String pathname : pathnames) {
                    // Print the names of files and directories
                    System.out.println(pathname);
                    bw.write(pathname);
                    bw.write("\n");
                    fw.write(pathname+"\n");
                }
                bw.close();
                fw.close();
            }
            else if(i==2)
            {
                FileWriter fw = new FileWriter("src/com/SpySoftware/Filer/allgames.txt",true);
                File steam = new File("src/com/SpySoftware/Filer/Games/other");
                String path = "src/com/SpySoftware/Filer/othergames.txt";
                pathnames = steam.list();
                BufferedWriter bw = new BufferedWriter(new FileWriter(path, false));
                // For each pathname in the pathnames array
                for (String pathname : pathnames) {
                    // Print the names of files and directories
                    System.out.println(pathname);
                    bw.write(pathname);
                    bw.write("\n");
                    fw.write(pathname+"\n");
                }
                bw.close();
                fw.close();
            }
            else if(i==3)
            {
                FileWriter fw = new FileWriter("src/com/SpySoftware/Filer/allgames.txt",true);
                File steam = new File("src/com/SpySoftware/Filer/Games/epicgames");
                String path = "src/com/SpySoftware/Filer/epicgames.txt";
                pathnames = steam.list();
                BufferedWriter bw = new BufferedWriter(new FileWriter(path, false));
                // For each pathname in the pathnames array
                for (String pathname : pathnames) {
                    // Print the names of files and directories
                    System.out.println(pathname);
                    bw.write(pathname);
                    bw.write("\n");
                    fw.write(pathname+"\n");
                }
                bw.close();
                fw.close();
            }
        }
    }

    public void CheckLogedin() throws Exception
    {
        BufferedReader br = new BufferedReader(new FileReader(logedinfile));
        if(br.readLine().equals("1"))
        {
            MainApp();
        }
        else
        {
            Login();
        }

    }
    public void MainApp()
    {
        MainApp main = new MainApp();
        frame = new JFrame("Gamelaunch");
        frame.setContentPane(main.panel1);
        frame.setSize(1050,650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public void Login()
    {
        gui login = new gui();
        loginframe = new JFrame("Log in");
        loginframe.setContentPane(login.panel1);
        loginframe.setSize(500,500);
        loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginframe.setVisible(true);

    }


    public static void main(String[] args) {

        NewGame login = new NewGame();
        JFrame frame1 = new JFrame("Log in");
        frame1.setContentPane(login.panel1);
        frame1.setSize(1090,600);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);

        try {
            new Main().CheckGames();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            //new Main().CheckLogedin();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
