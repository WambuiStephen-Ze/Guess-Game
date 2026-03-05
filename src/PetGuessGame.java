import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class PetGuessGame extends JFrame implements ActionListener {
  private JLabel imageLabel;
  private JRadioButton birdButton;
  private JRadioButton catButton;
  private JRadioButton dogButton;
  private JRadioButton rabbitButton;
  private JRadioButton pigButton;
  private ButtonGroup group;
  private String correctAnswer;
  private int attempts = 0;
  private final int MAX_ATTEMPTS = 3;
  private String[] pets = {"Bird", "cat", "dog", "rabbit", "pig"};

  public PetGuessGame() {
    setTitle("Pet Guess Game");
    setSize(600, 400);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    //  IMAGE LABEL
    imageLabel = new JLabel("", JLabel.CENTER);
    add(imageLabel, BorderLayout.CENTER);

    // BUTTON PANEL
    JPanel buttonPanel = new JPanel(new GridLayout(5,1));

    birdButton = new JRadioButton("Bird");
    catButton = new JRadioButton("cat");
    dogButton = new JRadioButton("dog");
    rabbitButton = new JRadioButton("rabbit");
    pigButton = new JRadioButton("pig");

    group = new ButtonGroup();
    group.add(birdButton);
    group.add(catButton);
    group.add(dogButton);
    group.add(rabbitButton);
    group.add(pigButton);

    buttonPanel.add(birdButton);
    buttonPanel.add(catButton);
    buttonPanel.add(dogButton);
    buttonPanel.add(rabbitButton);
    buttonPanel.add(pigButton);
    add(buttonPanel, BorderLayout.WEST);

    // Add listeners
    birdButton.addActionListener(this);
    catButton.addActionListener(this);
    dogButton.addActionListener(this);
    rabbitButton.addActionListener(this);
    pigButton.addActionListener(this);

    startNewGame();
    setVisible(true);
  }

  //START NEW GAME
  private void startNewGame() {
    attempts = 0;
    group.clearSelection();
    enableButtons(true);

    // Randomly choose correct answer
    Random random = new Random();
    correctAnswer = pets[random.nextInt(pets.length)];

    // Load image
    ImageIcon icon = new ImageIcon(correctAnswer.toLowerCase() + ".jpeg");
    Image img = icon.getImage().getScaledInstance(300,300,Image.SCALE_SMOOTH);
    imageLabel.setIcon(new ImageIcon(img));
  }

  //  BUTTON CLICK EVENT
  @Override
  public void actionPerformed(ActionEvent e) {
    JRadioButton selected = (JRadioButton) e.getSource();
    String answer = selected.getText();

    if(answer.equals(correctAnswer)) {
      JOptionPane.showMessageDialog(this,
              "Correct! Well done.");

      startNewGame();
    }
    else {
      attempts++;
      if(attempts < MAX_ATTEMPTS) {
        JOptionPane.showMessageDialog(this,
                "Wrong! Attempts left: " + (MAX_ATTEMPTS - attempts)
        );
      }
      else {
        lockGame();
      }
    }
  }

  // LOCK GAME
  private void lockGame() {

    JOptionPane.showMessageDialog(this,
            "You failed 3 times! Game locked for 30 seconds."
    );
    enableButtons(false);
    Timer timer = new Timer(30000, e -> startNewGame());
    timer.setRepeats(false);
    timer.start();
  }

  // ENABLE/DISABLE BUTTONS
  private void enableButtons(boolean enable) {
    birdButton.setEnabled(enable);
    catButton.setEnabled(enable);
    dogButton.setEnabled(enable);
    rabbitButton.setEnabled(enable);
    pigButton.setEnabled(enable);
  }

  public static void main(String[] args) {

    new PetGuessGame();
  }
}