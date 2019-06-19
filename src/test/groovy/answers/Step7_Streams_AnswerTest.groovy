package answers

import answers.Step7_Streams_Answer
import spock.lang.Specification

/**
 * Created by mtumilowicz on 2019-06-19.
 */
class Step7_Streams_AnswerTest extends Specification {

    def "test sumOfSquaresOfPositiveEvenNumbersUpTo < 0"() {
        given:
        int max = -1

        expect:
        Step7_Streams_Answer.sumOfSquaresOfPositiveEvenNumbersUpTo(max) == 0
    }

    def "test sumOfSquaresOfPositiveEvenNumbersUpTo 0"() {
        given:
        int max = 0

        expect:
        Step7_Streams_Answer.sumOfSquaresOfPositiveEvenNumbersUpTo(max) == 0
    }

    def "test sumOfSquaresOfPositiveEvenNumbersUpTo > 0"() {
        given:
        int max = 12

        expect:
        Step7_Streams_Answer.sumOfSquaresOfPositiveEvenNumbersUpTo(max) == 364
    }
    
}
