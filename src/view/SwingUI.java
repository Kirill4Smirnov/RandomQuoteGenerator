package view;

import model.QuoteEntity;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SwingUI implements UI{
    public SwingUI(){
        JFrame frame = new JFrame("Random quote generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);


        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter Text");
        JTextField tf = new JTextField(10); // accepts upto 10 characters
        JButton send = new JButton("Send");
        JButton reset = new JButton("Reset");
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(BorderLayout.WEST, send);
        panel.add(BorderLayout.EAST, reset);


        JTextField textField = new JTextField(10);
        textField.setText("baobab");
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.CENTER);

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.CENTER, textField);
        frame.setVisible(true);
    }

    @Override
    public void showQuotes(QuoteEntity[] quotes) {

    }

    @Override
    public void showCategories(ArrayList<String> categories) {

    }
}
