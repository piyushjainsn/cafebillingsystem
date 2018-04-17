package training

class InterestCalculator {

  def calculateYearlyInterestWithPrincipal(principal:Double, interest:Double):Double = {
     principal * (interest / 100) + principal
  }

  def calculateCompoundInterestQuarterly(principal:Double, interest:Double, noOfyears:Double):Double = {
    val principalwithInterest = ( Math.pow( (1 + (interest/100) ), 4 * noOfyears) * principal )
    principalwithInterest - principal
  }

}
