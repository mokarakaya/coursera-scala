package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if( c == 0 || c == r ) 1
      else pascal(c, r-1) + pascal(c-1, r-1)
    }

  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def balanceCheck(chars: List[Char], count: Int): Boolean ={
        if(chars.isEmpty || count < 0) count == 0
        else{
          val head = chars.head
          val tail = chars.tail
          if( head.equals('(')) balanceCheck(tail, count+1)
          else if(head.equals(')')) balanceCheck(tail, count-1)
          else balanceCheck(tail, count)
        }
      }
      balanceCheck(chars, 0)
    }

  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      def loop(money: Int, coins: List[Int]): Int = {
        if (money < 0 || coins.isEmpty ) 0
        else if (money == 0 ) 1
        else loop(money, coins.tail) + loop(money - coins.head, coins)
      }

      loop(money, coins)
    }
  }
