

package sudoku

class Game {
  
  private def generateSolution(game: Array[Array[Int]], index: Int): Unit = {
    if (index > 80) {
      return game;
      
    var y: Int = index % 9
    var x: Int = index / 9
    
    var numbers = Array[Int]()
    
    for (i <- 1 to 9) {
      number += i
      Collections.shuffle(numbers) ????
    }
    
    while(numbers.size > 0) {
      var number = getNextPossibleNumber(game, x, y, numbers)
      if (number == -1) {
        return null
      }
      game(x)(y) = number
      var tmpGame = generateSolution(game, index + 1)
      if (tmpGame != null) {
        return tempGame
      }
      game(x)(y) = 0
    }
    
    
    return null;
    
    }
  }
  
  private def getNextPossibleNumber(game: Array[Array[Int]], x: Int, y: Int, numbers: Array[Int]): Int = {
    while (numbers.size > 0) {
      var number -= numbers(0)
      if (isPossibleX(game, y, number) && isPossibleY(game, x, number) && isPossibleBlock(game, x, y, number)) {
        return number;
      }
    }
    return -1;
  }
  
  def generateGame(game: Array[Array[Int]]) = {
    var positions = Array[Int]()
    for (i <- 0 until 81) {
      positions += i
      Collections.shuffle(positions)
      generateGame(game, positions)
    }
  }
  
  private def generateGame(game: Array[Array[Int]], positions: Array[Int]): Array[Array[Int]] = {
    while (positions.size > 0) {
        val position: Int = positions.remove(0);
        val x: Int = position % 9;
        val y: Int = position / 9;
        val temp = game(y)(x);
        game(x)(y) = 0;

        if (!isValid(game))
            game(y)(x) = temp;
    }

    return game;
  }
  
  private def isValid(game: Array[Array[Int]]): Boolean = {
    return isValid(game, 0, new Array[int], 0 );
  }
  
  private def isValid(game: Array[Array[Int]], index: Int, numberOfSolutions: Array[Int]): Boolean = {
    
    if (index > 80)
        return numberOfSolutions(0) == 1;

    val x: Int = index % 9;
    val y: Int = index / 9;

    if (game(y)(x) == 0) {
        val numbers = Array[Int]()
        for (i <- 0 until 9)
            numbers += i;

        while (numbers.size > 0) {
            var number = getNextPossibleNumber(game, x, y, numbers);
            if (number == -1)
                break; ???
            game(y)(x) = number;

            if (!isValid(game, index + 1, numberOfSolutions)) {
                game(y)(x) = 0;
                return false;
            }
            game(y)(x) = 0;
        }
    } else if (!isValid(game, index + 1, numberOfSolutions))
        return false;

    return true;
  }
