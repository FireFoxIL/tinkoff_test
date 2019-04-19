package ivan.lyagaev.tinkoff_test

import org.scalatest.{AsyncFlatSpec, Matchers}

import scala.concurrent.Future
import scala.util.Try
import ivan.lyagaev.tinkoff_test.Converters._

class ConvertersSpec extends AsyncFlatSpec with Matchers {

  "Try to Future Converter" should "convert success value" in {
    val f: Future[Int] = Try { 1 + 1 }.future

    f.map(x => assert(x == 2))
  }

  it should "convert failure value" in {
    val f: Future[Int] = Try { 1 / 0}.future

    f.failed.map(x => assertThrows[ArithmeticException](throw x))
  }
}
