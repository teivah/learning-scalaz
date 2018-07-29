package day2

import scalaz.Functor
import scalaz.Scalaz._

object Course {
  def map[A, B](a: A, f: A => B) = f(a)

  def main(args: Array[String]): Unit = {
    // Functor
    val b = map[Int, Int](1, _ * 2)
    println(b)

    // Map is only applied on the last element
    val tuple: (Int, Int, Int) = (1, 2, 3) map {
      _ + 1
    }
    println(tuple)

    // Function for functions
    // Combine functions
    val f: Int => Int = ((x: Int) => x + 1) map {
      _ * 7
    } map {
      _ - 14
    }
    val i = f(1)
    println(i)


    // Liftin a function
    val functor: List[Int] => List[Int] = Functor[List].lift {
      (_: Int) * 2
    }
    val ints: List[Int] = functor(1 :: 2 :: Nil)
    println(ints)


  }
}
