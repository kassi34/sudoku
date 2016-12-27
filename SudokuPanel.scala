package sudoku

import scala.swing._
import scala.swing.event._

class SudokuPanel extends Panel{
  
  val sizeOfABox = 30
  val amount: Int = 9
  val gridNum: Int = 3
  
  val gameState = Array.fill[Field](amount, amount)(new Field)
  
  def drawGrid()= { 
    val panel1 = new BoxPanel(Orientation.Vertical)
    val panel2 = new BoxPanel(Orientation.Vertical)
    val panel3 = new BoxPanel(Orientation.Vertical)
    for (xcurrent <- 0 to 2; ycurrent <- 0 to 8) {
      panel1.contents += gameState(xcurrent)(ycurrent)
    }
    for (xcurrent <- 3 to 5; ycurrent <- 0 to 8) {
      panel2.contents += gameState(xcurrent)(ycurrent)
    }
    for (xcurrent <- 6 to 8; ycurrent <- 0 to 8){
      panel3.contents += gameState(xcurrent)(ycurrent)
    }
    val mainGrid = new BoxPanel(Orientation.Horizontal)
    mainGrid.contents += panel1
    mainGrid.contents += panel2
    mainGrid.contents += panel3
    mainGrid
  }
    
  override def contents = Seq[Component](this.drawGrid())
  
  
  /**
   * metodi, joka päivittää modelin tietojen mukaan
   * 
   */
  
  /**
   * metodi, joka asettaa fields pelin mukaan
   */
  def setFields(game: Game) = {
    for (xcurrent <- 0 to 8; ycurrent <- 0 to 8) {
      gameState(xcurrent)(ycurrent).setNumber(game.getNumber(xcurrent, ycurrent))
      update
    }
  }
  
  def update = drawGrid()
  
  
  /**
   * asettaa controllerin ie sudokuController 
   * Listen to???
   * for (xcurrent <- 0 to 8; ycurrent <- 0 to 8) {
   * 	sudokuController.listenTo(gameState(xcurrent)(ycurrent)
   * }
   * 
   * 
   */
}