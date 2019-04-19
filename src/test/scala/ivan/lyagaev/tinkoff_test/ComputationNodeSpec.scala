package ivan.lyagaev.tinkoff_test

import org.scalatest.{FlatSpec, Matchers}

class ComputationNodeSpec extends FlatSpec with Matchers {

  "Computation Node" should "produce slots that can be executed only on it" in {
    val mathNode = new MathComputationNode
    val otherMathNode = new MathComputationNode

    val computationSlot = mathNode.reserveTimeSlot(1 + 1)

    val failedComputation = otherMathNode.performComputation(computationSlot)

    failedComputation shouldBe Left(WrongNode)

    val successfulComputation = mathNode.performComputation(computationSlot)

    successfulComputation shouldBe Right(2)
  }
}
