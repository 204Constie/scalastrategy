

/**
  * Created by constie on 08.04.2017.
  */

object Main {
  type Strategy = (Int, Int) => Int

  val add: Strategy = _ + _
  val multiply: Strategy = _ * _

  def context(callback: Strategy, a: Int, b: Int): Int = { return callback(a, b) }

  def main(args: Array[String]): Unit ={
    println(context(add, 1, 2))
    println(context(multiply, 3, 3))

  }
}
