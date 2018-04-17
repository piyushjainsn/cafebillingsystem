package training

import org.scalatest.{FunSpec, Matchers}


class InterestCalculatorTest extends FunSpec with Matchers {

  val calculator = new InterestCalculator

  describe("simple interest") {
    it("should return simple interest") {
      calculator.calculateYearlyInterestWithPrincipal(1000, 5) should be(1050)
    }

    it("should return 0 simple interest when principal is 0") {
      calculator.calculateYearlyInterestWithPrincipal(0, 5) should be(0)
    }

    it("should return 0 simple interest when interest is 0") {
      calculator.calculateYearlyInterestWithPrincipal(100, 0) should be(100)
    }
  }

  describe("simple interest") {
    it("should return compound interest") {
      calculator.calculateCompoundInterestQuarterly(100, 10, 0.5) should be(21.000000000000014)
    }
  }

}
