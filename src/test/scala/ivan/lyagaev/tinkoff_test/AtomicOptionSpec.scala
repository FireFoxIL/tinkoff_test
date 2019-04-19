package ivan.lyagaev.tinkoff_test

import org.scalatest.{FlatSpec, Matchers}

class AtomicOptionSpec extends FlatSpec with Matchers {

  "Atomic Option" should "set if is value is absent" in {
    val atomicOption = AtomicOption[Int]

    atomicOption.setIfAbsent(10) shouldBe None
    atomicOption.setIfAbsent(11) shouldBe Some(10)
  }

  it should "get and set the value" in {
    val atomicOption = AtomicOption[Int]

    atomicOption.getAndSet(10) shouldBe None
    atomicOption.getAndSet(11) shouldBe Some(10)
    atomicOption.getAndSet(12) shouldBe Some(11)
  }
}
