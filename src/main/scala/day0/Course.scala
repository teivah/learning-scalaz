package day0

import scalaz.Scalaz._

trait Monoid[A] {
  def identity: A

  def append(a: A, b: A): A
}

object IntMonoid extends Monoid[Int] {
  def identity: Int = 0

  def append(a: Int, b: Int) = a + b
}

object StringMonoid extends Monoid[String] {
  def identity: String = ""

  def append(a: String, b: String) = a + b
}

object Course {
  def head[A](list: List[A]): A = list(0)

  // Start with an accumulator and goes from left to right by applying a function
  def sum(list: List[Int]): Int = list.foldLeft(0) {
    (acc, num) => acc + num
  }

  def sum2(list: List[Int]): Int = list.foldLeft(IntMonoid.identity) {
    IntMonoid.append
  }

  def sum3[A](list: List[A], monoid: Monoid[A]): A =
    list.foldLeft(monoid.identity)(monoid.append)

  def sum4[A](list: List[A])(implicit monoid: Monoid[A]): A =
    list.foldLeft(monoid.identity)(monoid.append)

  def sum5[A: Monoid](a: A, b: A): A = implicitly[Monoid[A]].append(a, b)

  def main(args: Array[String]): Unit = {
    val h = head[Int](1 :: 2 :: Nil)
    println(h)

    // Fold left
    val i = sum(1 :: 2 :: 3 :: Nil)
    println(i)

    // Fold left with monoid
    val j = sum2(1 :: 2 :: 3 :: Nil)
    println(j)

    // Generics
    val l = sum3(1 :: 2 :: 3 :: Nil, IntMonoid)
    println(l)

    // Implicit
    implicit val monoid = IntMonoid
    val m = sum4(1 :: 2 :: 3 :: Nil)
    println(m)

    // Implicitely
    val c = sum5(1, 2)
    println(c)

    val b: Int = 1 |+| 2 |+| 3
    println(b)
  }
}
