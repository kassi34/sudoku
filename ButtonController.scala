package sudoku

import scala.swing._
import scala.swing.event._

class ButtonController(private var game: Game) extends ActionListener { 
  
    def actionPerformed(e: ActionEvent) {
      if {
      (e.getActionCommand == "New") game.newGame() 
    } else if {
      (e.getActionCommand == "Check") game.checkGame()
    } else if {
      (e.getActionCommand == "Exit") System.exit(0) 
    } else if {
      (e.getActionCommand == "Help on") game.setHelp(e.getSource.asInstanceOf[JCheckBox].isSelected)
    } else { game.setSelectedNumber
      }
    }
  }
}
