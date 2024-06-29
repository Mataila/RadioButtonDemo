import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PetSelector extends JFrame {

    private JLabel petLabel;
    private JLabel petImageLabel;
    private JRadioButton birdButton, catButton, dogButton, rabbitButton, pigButton;
    private ButtonGroup petGroup;

    public PetSelector() {
        // Set up the frame
        setTitle("RadioButtonDemo");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the label to display the selected pet
        petLabel = new JLabel("Select a pet", JLabel.CENTER);
        petLabel.setFont(new Font("Serif", Font.BOLD, 20));
        add(petLabel, BorderLayout.NORTH);

        // Create the label to display the pet image
        petImageLabel = new JLabel("", JLabel.CENTER);
        add(petImageLabel, BorderLayout.CENTER);

        // Create the radio buttons
        birdButton = new JRadioButton("Bird");
        catButton = new JRadioButton("Cat");
        dogButton = new JRadioButton("Dog");
        rabbitButton = new JRadioButton("Rabbit");
        pigButton = new JRadioButton("pig");

        // Group the radio buttons
        petGroup = new ButtonGroup();
        petGroup.add(birdButton);
        petGroup.add(catButton);
        petGroup.add(dogButton);
        petGroup.add(rabbitButton);
        petGroup.add(pigButton);

        // Add action listeners to the radio buttons
        birdButton.addActionListener(new PetSelectionHandler());
        catButton.addActionListener(new PetSelectionHandler());
        dogButton.addActionListener(new PetSelectionHandler());
        rabbitButton.addActionListener(new PetSelectionHandler());
        pigButton.addActionListener(new PetSelectionHandler());

        // Create a panel to hold the radio buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1));
        buttonPanel.add(birdButton);
        buttonPanel.add(catButton);
        buttonPanel.add(dogButton);
        buttonPanel.add(rabbitButton);
        buttonPanel.add(pigButton);

        // Add the panel to the frame
        add(buttonPanel, BorderLayout.WEST);
    }

    // Inner class to handle the radio button selections
    private class PetSelectionHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (birdButton.isSelected()) {
                petLabel.setText("You selected: Bird");
                petImageLabel.setIcon(createImageIcon("images/bird.jpeg"));
            } else if (catButton.isSelected()) {
                petLabel.setText("You selected: Cat");
                petImageLabel.setIcon(createImageIcon("images/cat.png"));
            } else if (dogButton.isSelected()) {
                petLabel.setText("You selected: Dog");
                petImageLabel.setIcon(createImageIcon("images/dog.png"));
            } else if (rabbitButton.isSelected()) {
                petLabel.setText("You selected: Rabbit");
                petImageLabel.setIcon(createImageIcon("images/rabbit.jpeg"));
            } else if (pigButton.isSelected()) {
                petLabel.setText("You selected: Pig");
                petImageLabel.setIcon(createImageIcon("images/pig.jpeg"));
            }
        }
    }

    // Method to create an ImageIcon from a path
    protected ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = getClass().getClassLoader().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    public static void main(String[] args) {
        // Run the GUI construction on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PetSelector().setVisible(true);
            }
        });
    }
}

