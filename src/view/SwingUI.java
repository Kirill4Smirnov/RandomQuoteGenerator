package view;

import model.RegenObserver;
import model.QuoteEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SwingUI implements UI {
 private    JFrame frame;

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

        frame = new JFrame("Random quote generator");

        frame.setTitle("Motivational Quote App");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        // Dropdown menu for category selection
        categoryDropdown = new JComboBox<>(categories);
        panel.add(categoryDropdown);

        // Text area for displaying the quote
        quoteTextArea = new JTextArea(10, 30);
        quoteTextArea.setEditable(false);
        quoteTextArea.setWrapStyleWord(true);

        panel.add(quoteTextArea);

        // Button for regenerating the quote
        regenerateButton = new JButton("Regenerate Quote");
        regenerateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call backend method to fetch a new quote based on selected category and display it in the text area
                String selectedCategory = (String) categoryDropdown.getSelectedItem();
                QuoteEntity[] newQuotes = regenObserver.getRandomQuotes(selectedCategory, 1);
                showQuotes(newQuotes);
            }
        });
        panel.add(regenerateButton);

        frame.add(panel);
        frame.setVisible(true);
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

    @Override
    public void showCategories(ArrayList<String> categories) {

    }
}
