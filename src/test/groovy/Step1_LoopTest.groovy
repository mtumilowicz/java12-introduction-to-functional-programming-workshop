import spock.lang.Specification

/**
 * Created by mtumilowicz on 2019-06-18.
 */
class Step1_LoopTest extends Specification {
    
    def "test sumOfSquaresOfPositiveEvenNumbersUpTo < 0"() {
        given:
        int max = -1

        expect:
        Step1_Loop.sumOfSquaresOfPositiveEvenNumbersUpTo(max) == 0
    }

    def "test sumOfSquaresOfPositiveEvenNumbersUpTo 0"() {
        given:
        int max = 0

        expect:
        Step1_Loop.sumOfSquaresOfPositiveEvenNumbersUpTo(max) == 0
    }

    def "test sumOfSquaresOfPositiveEvenNumbersUpTo > 0"() {
        given:
        int max = 12

        expect:
        Step1_Loop.sumOfSquaresOfPositiveEvenNumbersUpTo(max) == 364
    }
}
