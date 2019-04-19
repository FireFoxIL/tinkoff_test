package ivan.lyagaev.tinkoff_test

import java.util.concurrent.atomic.AtomicReference

object AtomicOption {

  def apply[T](t: T) = new AtomicOption(Some(t))

  def apply[T] = new AtomicOption[T](None)
}

class AtomicOption[T](value: Option[T]) {

  private val atomicOption: AtomicReference[Option[T]] = new AtomicReference(value)

  def setIfAbsent(t: T): Option[T] =
    atomicOption.getAndUpdate(_.orElse(Some(t)))

  def set(t: T): Unit =
    atomicOption.set(Some(t))

  def getAndSet(t: T): Option[T] =
    atomicOption.getAndSet(Some(t))
}
