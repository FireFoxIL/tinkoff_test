package ivan.lyagaev.tinkoff_test

sealed abstract class ComputationError(val message: String)

case object WrongNode extends ComputationError("Trying to execute computation on not assigned node")

class ComputationTimeSlot[T](computation: => T)(implicit val assignedNode: ComputationNode[T]) {
  def compute(implicit executor: ComputationNode[T]): Either[ComputationError, T] =
    if (executor == assignedNode) {
      Right(computation)
    } else {
      Left(WrongNode)
    }
}

abstract class ComputationNode[T] {
  implicit val self: ComputationNode[T] = this

  def reserveTimeSlot(computation: => T): ComputationTimeSlot[T] = new ComputationTimeSlot[T](computation)

  def performComputation(slot: ComputationTimeSlot[T]): Either[ComputationError, T] = slot.compute
}

class MathComputationNode extends ComputationNode[BigDecimal]

class StringComputationNode extends ComputationNode[String]
