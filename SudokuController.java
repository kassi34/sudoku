 1  package nl.elridge.sudoku.controller;
  2  
  3  import java.awt.Color;
  4  import java.awt.Component;
  5  import java.awt.event.MouseEvent;
  6  import java.awt.event.MouseListener;
  7  import javax.swing.JPanel;
  8  import nl.elridge.sudoku.model.Game;
  9  import nl.elridge.sudoku.model.UpdateAction;
 10  import nl.elridge.sudoku.view.Field;
 11  import nl.elridge.sudoku.view.SudokuPanel;
 12  
 13  /**
 14   * This class controls all user actions from SudokuPanel.
 15   *
 16   * @author Eric Beijer
 17   */
 18  public class SudokuController implements MouseListener {
 19      private SudokuPanel sudokuPanel;    // Panel to control.
 20      private Game game;                  // Current Sudoku game.
 21  
 22      /**
 23       * Constructor, sets game.
 24       *
 25       * @param game  Game to be set.
 26       */
 27      public SudokuController(SudokuPanel sudokuPanel, Game game) {
 28          this.sudokuPanel = sudokuPanel;
 29          this.game = game;
 30      }
 31  
 32      /**
 33       * Recovers if user clicked field in game. If so it sets the selected number
 34       * at clicked position in game and updates clicked field. If user clicked a
 35       * field and used left mouse button, number at clicked position will be
 36       * cleared in game and clicked field will be updated.
 37       *
 38       * @param e MouseEvent.
 39       */
 40      public void mousePressed(MouseEvent e) {
 41          JPanel panel = (JPanel)e.getSource();
 42          Component component = panel.getComponentAt(e.getPoint());
 43          if (component instanceof Field) {
 44              Field field = (Field)component;
 45              int x = field.getFieldX();
 46              int y = field.getFieldY();
 47  
 48              if (e.getButton() == MouseEvent.BUTTON1 && (game.getNumber(x, y) == 0 || field.getForeground().equals(Color.BLUE))) {
 49                  int number = game.getSelectedNumber();
 50                  if (number == -1)
 51                      return;
 52                  game.setNumber(x, y, number);
 53                  field.setNumber(number, true);
 54              } else if (e.getButton() == MouseEvent.BUTTON3 && !field.getForeground().equals(Color.BLACK)) {
 55                  game.setNumber(x, y, 0);
 56                  field.setNumber(0, false);
 57              }
 58              sudokuPanel.update(game, UpdateAction.CANDIDATES);
 59          }
 60      }
 61  
 62      public void mouseClicked(MouseEvent e) { }
 63      public void mouseEntered(MouseEvent e) { }
 64      public void mouseExited(MouseEvent e) { }
 65      public void mouseReleased(MouseEvent e) { }
 66  }
