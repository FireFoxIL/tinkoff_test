package ivan.lyagaev.tinkoff_test

import scala.concurrent.Future
import scala.util.Try

object Converters {

  implicit class TryToFuture[T](value: Try[T]) {
    def future: Future[T] = Future.fromTry(value)
  }
}
