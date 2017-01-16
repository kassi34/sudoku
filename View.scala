package sudoku

import scala.swing._
import scala.swing.event._
import java.awt.Color

object View extends SimpleSwingApplication {
  
  val fieldSize = 50
  val smallGrid = 3
  val grid: Int = 9 //amount or index???
  var selectedX: Int = 0
  var selectedY: Int = 0
  var difficulty: Int = 1
  var help = false
  val gameState: Array[Array[Field]] = Array.fill[Field](grid, grid)(new Field)
  
  //val game = new Game

  val sudoku = new GridPanel(grid, cols0 = grid) {
    
    preferredSize = new Dimension(grid * fieldSize, grid * fieldSize) 
    border = new javax.swing.border.LineBorder(Color.BLACK)
    
    override def paintComponent(g: Graphics2D) {
      for (m <- 0 until grid; n <- 0 until grid) {
        if (gameState(m)(n).text == "") {
          g.setColor(Color.WHITE)
        } else {
          g.drawString(gameState(m)(n).text, m + fieldSize / 2, n + fieldSize / 2)
        }
      }
    }
    focusable = true //?
  }
  
  def top = new MainFrame {
    title = "Sudoku"
    preferredSize = new Dimension(grid * fieldSize, grid * fieldSize) 

    menuBar = new MenuBar {
      contents += new Menu("Game") {
        //contents += new MenuItem(newGame)
        contents += new MenuItem(Action("End game") { dispose()})
      }
      contents += new Menu("Difficulty") {
        contents += new MenuItem(Action("Easy") { difficulty = 1})
        contents += new MenuItem(Action("Mediocore") { difficulty = 2})
        contents += new MenuItem(Action("Hard") {difficulty = 3})    
      }
      contents += new Menu("Help") {
        contents += new MenuItem(Action("On") { help = true})
        contents += new MenuItem(Action("Off") { help = false})
      }
      
    }
    
    contents = sudoku
    
    listenTo(sudoku.mouse.clicks)
    listenTo(sudoku.keys)
    reactions += {
      case MouseClicked(sudoku, d, _, _, _) => {
        if (d.x <= fieldSize * grid && d.y <= fieldSize * grid) {
          selectedX = d.x / fieldSize
          selectedY = d.y / fieldSize
        } 
      }
      case KeyTyped(sudoku, char, _, _) => {
        if ('1' <= char && char <= '9') {
          if (gameState(selectedX)(selectedY).writable == true) {
            gameState(selectedX)(selectedY).setNumber(char.toInt)
            repaint()
          }
        }
      }
    }
    
    /** hakee peliltä uuden pelin tiedot 
     *  gameState palauttaa fields
     *  erillinen array joka palauttaa int?
     *  */
    
  }
  
}