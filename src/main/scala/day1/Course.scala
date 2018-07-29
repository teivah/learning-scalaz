package day1

import scalaz.Cord
import scalaz.Scalaz._

import scala.collection.immutable.NumericRange

object Course {
  def main(args: Array[String]): Unit = {
    // Equals
    var a = 1 === 1
    println(a)

    a = "foo" === "foo"
    println(a)

    // Different
    a = 2 =/= 2
    println(a)

    // Order
    1 gt 2

    val ordering = 1 ?|? 2

    val b = 1 max 2
    println(b)

    // Shows
    val shows: String = 3.shows
    val show: Cord = 3.show
    println(s"$shows $show")

    // Enum

    // Standard
    val c1: NumericRange.Inclusive[Char] = 'a' to 'e'

    // Scalaz
    val c2: List[Char] = 'a' |-> 'e'
    println(c2)

    println('x'.succ)
  }

  def yesno[A, B, C](f: (A, B) => C)(a: A, b: B) = f(a, b)
}
