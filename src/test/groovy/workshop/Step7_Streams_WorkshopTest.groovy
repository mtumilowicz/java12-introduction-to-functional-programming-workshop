package workshop


import spock.lang.Specification 
/**
 * Created by mtumilowicz on 2019-06-19.
 */
class Step7_Streams_WorkshopTest extends Specification {

    def "test sumOfSquaresOfPositiveEvenNumbersUpTo < 0"() {
        given:
        int max = -1

        expect:
        Step7_Streams_Workshop.sumOfSquaresOfPositiveEvenNumbersUpTo(max) == 0
    }

    def "test sumOfSquaresOfPositiveEvenNumbersUpTo 0"() {
        given:
        int max = 0

        expect:
        Step7_Streams_Workshop.sumOfSquaresOfPositiveEvenNumbersUpTo(max) == 0
    }

    def "test sumOfSquaresOfPositiveEvenNumbersUpTo > 0"() {
        given:
        int max = 12

        expect:
        Step7_Streams_Workshop.sumOfSquaresOfPositiveEvenNumbersUpTo(max) == 364
    }
    
}
