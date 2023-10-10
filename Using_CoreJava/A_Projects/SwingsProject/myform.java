package com.Amar.A_Projects.SwingsProject;
import java.awt.*;
import java.awt.event.*;

public class myform extends Frame implements ActionListener {
    Label l;
    Button b;
    myform() {
        l = new Label("Click to Close");
        b = new Button("Close");
        setLayout(null);
        l.setBounds(200, 100, 400, 30);
        b.setBounds(220, 150, 250, 30);
        add(l);
        add(b);
        b.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }

    public static void main(String[] args) {
        myform ob=new myform();
        ob.setSize(400,300);
        ob.setTitle("MY FRAME PROGRAM");
        ob.setVisible(true);
        ob.setBackground(Color.CYAN);
    }

}
