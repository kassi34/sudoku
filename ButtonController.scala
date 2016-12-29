1  package nl.elridge.sudoku.controller;
  2  
  3  import java.awt.event.ActionEvent;
  4  import java.awt.event.ActionListener;
  5  import javax.swing.JCheckBox;
  6  import nl.elridge.sudoku.model.Game;
  7  
  8  /**
  9   * This class controls all user actions from ButtonPanel.
 10   *
 11   * @author Eric Beijer
 12   */
 13  public class ButtonController implements ActionListener {
 14      private Game game;
 15  
 16      /**
 17       * Constructor, sets game.
 18       *
 19       * @param game  Game to be set.
 20       */
 21      public ButtonController(Game game) {
 22          this.game = game;
 23      }
 24  
 25      /**
 26       * Performs action after user pressed button.
 27       *
 28       * @param e ActionEvent.
 29       */
 30      public void actionPerformed(ActionEvent e) {
 31          if (e.getActionCommand().equals("New"))
 32              game.newGame();
 33          else if (e.getActionCommand().equals("Check"))
 34              game.checkGame();
 35          else if (e.getActionCommand().equals("Exit"))
 36              System.exit(0);
 37          else if (e.getActionCommand().equals("Help on"))
 38              game.setHelp(((JCheckBox)e.getSource()).isSelected());
 39          else
 40              game.setSelectedNumber(Integer.parseInt(e.getActionCommand()));
 41      }
 42  }
