package sudoku

import scala.swing._
import scala.swing.event._


class Field extends Label {
  
  this.text = ""
  this.background = ???
  this.border = ???
  this.font = new Font("Arial", 0, 12)
  preferredSize = new Dimension(30, 30)
    
  def setNumber(number: Int/**, isTrue: Boolean*/) = {
      this.text = number.toString
      //v�rin vaihto?
  }
  
    
  def getX: Int = this.location.getX.toInt
    
    
  def getY: Int = this.location.getY.toInt
  
  
  
  
}