package com.Amar.A_Projects.SwingsProject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class RGB_Frame extends Frame implements ActionListener {
    Button b1, b2, b3, b4;

    RGB_Frame() {
        b1 = new Button("Red");
        b2 = new Button("Green");
        b3 = new Button("Blue");
        b4 = new Button("Exit");
        setLayout(null);
        b1.setBounds(200, 150, 40, 30);
        b2.setBounds(250, 150, 40, 30);
        b3.setBounds(300, 150, 40, 30);
        b4.setBounds(250, 190, 30, 20);

        add(b1);
        add(b2);
        add(b3);
        add(b4);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae){
        String s=ae.getActionCommand();
        if(s.equals("Red")){
            setBackground(Color.red);
        }else if(s.equals("Green")){
            setBackground(Color.green);
        }else if(s.equals("Blue")){
            setBackground(Color.BLUE);
        }else if(s.equals("Exit")){
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        RGB_Frame ob=new RGB_Frame();
        ob.setSize(800,800);
        ob.setVisible(true);
        ob.setBackground(Color.WHITE);
    }

}
