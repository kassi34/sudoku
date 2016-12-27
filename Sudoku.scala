package sudoku

import scala.swing._
import scala.swing.event._

class Sudoku extends SwingApplication {
  
  
  
  
 
  //this.listenTo(mouse.clicks)
  val buttonPanel = new ButtonPanel
  val sudokuPanel = new SudokuPanel
  val wholePanel = new BoxPanel(Orientation.Horizontal)
  val game = new Game 
  wholePanel.contents += buttonPanel
  wholePanel.contents += sudokuPanel
  sudokuPanel.setFields(game)
//  buttonController = new ButtonController(game)
//  sudokuController = new SudokuController(game)
  
  
  val frame = new MainFrame
  frame.title = "Sudoku"
  frame.contents = wholePanel
  
  
  def top = this.frame
  
  
  
  /**def Sudoku()
   * Pelin piirtämismetodi
   */
  
  /**
   * main()
   * try ja sudoku()
   * 
   * Listener vs handler onko sama kuin observer vs controller
   */
  
  
}