package week1

import scala.util.control.TailCalls.TailRec

object recursion {
  val v = 1 + 2                                   //> v  : Int = 3
  val loop: Boolean = false                       //> loop  : Boolean = false

  def abs(x: Double) = if (x > 0) x else -x       //> abs: (x: Double)Double

  // block scoping

  // sqaure root
  def sqrRoot(x: Double): Double = {
    def isGuessGoodEnough(guess: Double): Boolean =
      abs(guess * guess - x) / x < 1e-10
    def improveSqrRoot(guess: Double): Double =
      (guess + x / guess) / 2 // mean of x and guess

    // recursive function
    def sqrRootItr(guess: Double): Double = {
      if (isGuessGoodEnough(guess)) guess
      else sqrRootItr(improveSqrRoot(guess))
    }
    sqrRootItr(x)
  }                                               //> sqrRoot: (x: Double)Double

  sqrRoot(2)                                      //> res0: Double = 1.4142135623746899
  sqrRoot(4)                                      //> res1: Double = 2.000000000000002
  sqrRoot(1e-20)                                  //> res2: Double = 1.000000000002308E-10
  sqrRoot(1e60)                                   //> res3: Double = 1.0E30

  // GCD greatest common divisor, euclids algo
  // tail recursion as function reduces to itself
  def gcd(x: Double, y: Double): Double = {
    if (y == 0) x else gcd(y, x % y)
  }                                               //> gcd: (x: Double, y: Double)Double
  gcd(150, 125)                                   //> res4: Double = 25.0

  // factorial
  // simple recursion
  def factorial(n: Long): Long = {
    if (n == 0) 1 else n * factorial(n - 1)
  }                                               //> factorial: (n: Long)Long
  factorial(4)                                    //> res5: Long = 24

  // tail recursice factorial
  def factorialT(n: Long): Long = {
    def loop(accum: Long, n: Long): Long = {
      if (n == 0) accum else loop(accum * n, n - 1)
    }
    loop(1, n)
  }                                               //> factorialT: (n: Long)Long
  factorialT(5)                                   //> res6: Long = 120
}