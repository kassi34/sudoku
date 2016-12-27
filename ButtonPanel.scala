package sudoku

import scala.swing._
import scala.swing.event._

class ButtonPanel extends Panel {
  
  val title = new Label("Options")
  val newGame = new Button("New game")
  val check = new Button("Check")
  val exit = new Button("Exit")
  
  val options = new BoxPanel(Orientation.Horizontal)
  options.contents += newGame
  options.contents += check
  options.contents += exit
    
  val one = new Button("1")
  val two = new Button("2")
  val three = new Button("3")
  val four = new Button("4")
  val five = new Button("5")
  val six = new Button("6")
  val seven = new Button("7")
  val eight = new Button("8")
  val nine = new Button("9")
  
  val numbers = new BoxPanel(Orientation.Horizontal)
  numbers.contents += one
  numbers.contents += two
  numbers.contents += three
  numbers.contents += four
  numbers.contents += five
  numbers.contents += six
  numbers.contents += seven
  numbers.contents += eight
  numbers.contents += nine
  
  val wholePanel = new BoxPanel(Orientation.Vertical)
  wholePanel.contents += numbers
  wholePanel.contents += options
  
  override def contents = Seq[Component](this.wholePanel)
  
  /**
   * Updating?
   */
  
  
  /**
   * M��ritell��n ehk� controllerissa?
   * buttonController.listenTo(options)
   * buttonController.listenTo(newGame)
   * buttonController.listenTo(check)
   * buttonController.listenTo(exit)
   * 
   * buttonController.listenTo(numbers)
   * buttonController.listenTo(one)
   * buttonController.listenTo(two)
   * buttonController.listenTo(three)
   * buttonController.listenTo(four)
   * buttonController.listenTo(five)
   * buttonController.listenTo(six)
   * buttonController.listenTo(seven)
   * buttonController.listenTo(eight)
   * buttonController.listenTo(nine)
   * 
   */
}