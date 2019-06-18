import spock.lang.Specification

/**
 * Created by mtumilowicz on 2019-06-18.
 */
class Step1_LoopTest extends Specification {
    
    def "test sumOfSquaresOfPositiveEvenNumbersUpTo with negative max"() {
        given:
        int max = -1

        expect:
        Step1_Loop.sumOfSquaresOfPositiveEvenNumbersUpTo(max) == 0
    }

    def "test sumOfSquaresOfPositiveEvenNumbersUpTo with zero max"() {
        given:
        int max = -1

        expect:
        Step1_Loop.sumOfSquaresOfPositiveEvenNumbersUpTo(max) == 0
    }

    def "test sumOfSquaresOfPositiveEvenNumbersUpTo with positive max"() {
        given:
        int max = 12

        expect:
        Step1_Loop.sumOfSquaresOfPositiveEvenNumbersUpTo(max) == 364
    }
}
