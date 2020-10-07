package ru.mirea.naz.pr11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener {
    private JTextField text=new JTextField(10);
    private JButton button= new JButton("Угадать");
    private FlowLayout layout=new FlowLayout();
    private JLabel label=new JLabel("--");
    private JLabel label1=new JLabel();
    private int life=3;
    public Window(){
        super("Окно");
        this.setBounds(400,200,220,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container=this.getContentPane();
        button.addActionListener(this);
        setLayout(layout);
        label1.setText("Life: "+life);
        container.add(label1);
        container.add(text);
        container.add(button);
        container.add(label);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s=text.getText();
        System.out.println(s);
        if(life>0){
            JOptionPane.showMessageDialog(null,"Вы ошиблись");
            life--;
            label1.setText("Life: "+life);
            label.setText(s);
            text.setText("");
        }
        else{
            JOptionPane.showMessageDialog(null,"У вас закончились жизни");
            s=label1.getText();
            if(!s.contains("Life: 0 (Game Over)")){
                label1.setText("Life: 0 (Game Over)");
                label.setText("--");
            }
            text.setText("");
        }

    }
}
