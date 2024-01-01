package view;

import model.RegenObserver;
import model.QuoteEntity;

import javax.swing.*;
import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class SwingUI implements UI {
    private static final String defaultText =
            "Click 'Regenerate quote' to get a quote for your motivation. You can also select a category using the menu above";
    private JFrame frame;

    private JComboBox<String> categoryDropdown;
    private JTextArea quoteTextArea;
    private JButton regenerateButton;

    private RegenObserver regenObserver;
    String[] categories;

    public void subscribeForRegenEvent(RegenObserver observer) {
        regenObserver = observer;
    }

    public SwingUI(RegenObserver observer) {
        regenObserver = observer;
        categories = observer.getCategories().toArray(new String[0]);

        createAndSetupFrame();

    }

    private void createAndSetupFrame(){
        frame = new JFrame("Random quote generator");

        frame.setTitle("Motivational Quote App");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Dropdown menu for category selection
        categoryDropdown = new JComboBox<>(categories);
        DefaultListCellRenderer listRenderer = new DefaultListCellRenderer();
        listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER); // center-aligned items
        categoryDropdown.setRenderer(listRenderer);

        frame.add(categoryDropdown, BorderLayout.NORTH);


        createTextArea();
        createRegenBtn();
        createExitShortcut();

        frame.setVisible(true);

    }
    private void createTextArea(){
        // Text area for displaying the quote
        quoteTextArea = new JTextArea(10, 20);
        quoteTextArea.setEditable(false);
        quoteTextArea.setFont(new Font("Serif", Font.PLAIN, 16));
        quoteTextArea.setLineWrap(true);
        quoteTextArea.setWrapStyleWord(true);
        quoteTextArea.setText(defaultText);

        frame.add(quoteTextArea, BorderLayout.CENTER);
    }
    private void createRegenBtn(){
        // Button for regenerating the quote
        regenerateButton = new JButton("Generate quote");
        regenerateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call backend method to fetch a new quote based on selected category and display it in the text area
                String selectedCategory = (String) categoryDropdown.getSelectedItem();
                QuoteEntity[] newQuotes = regenObserver.getRandomQuotes(selectedCategory, 1);
                showQuotes(newQuotes);
            }
        });
        frame.add(regenerateButton, BorderLayout.SOUTH);
    }

    private void createExitShortcut(){
        //exit on Ctrl+Q
        JRootPane rootPane = frame.getRootPane();
        KeyStroke stroke = KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK);
        rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(stroke, "exit");
        rootPane.getActionMap().put("exit", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }


    @Override
    public void showQuotes(QuoteEntity[] quotes) {
        String result = "";
        for (QuoteEntity quote :
                quotes) {
            result += quote.text() + " | " + quote.author() + "  |  " + quote.category() + '\n';
        }
        quoteTextArea.setText(result);
        //frame.setVisible(true);
    }

}
