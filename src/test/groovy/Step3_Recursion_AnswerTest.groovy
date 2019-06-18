import io.vavr.collection.List
import spock.lang.Specification

/**
 * Created by mtumilowicz on 2019-06-18.
 */
class Step3_Recursion_AnswerTest extends Specification {
    
    def "test iteratePositiveUpTo < 0"() {
        given:
        int max = -1

        expect:
        Step3_Recursion_Answer.iteratePositiveUpTo(max) == List.empty()
    }

    def "test iteratePositiveUpTo 0"() {
        given:
        int max = 0

        expect:
        Step3_Recursion_Answer.iteratePositiveUpTo(max) == List.empty()
    }    
    
    def "test iteratePositiveUpTo > 0"() {
        given:
        int max = 5

        expect:
        Step3_Recursion_Answer.iteratePositiveUpTo(max) == List.of(1, 2, 3, 4, 5)
    }

    def "test filterEven all even"() {
        given:
        def evens = List.of(-2, 2, 4, 6)
        
        expect:
        Step3_Recursion_Answer.filterEven(evens) == List.of(-2, 2, 4, 6)
    }

    def "test filterEven all odd"() {
        given:
        def evens = List.of(-1, 1, 3, 5)

        expect:
        Step3_Recursion_Answer.filterEven(evens) == List.empty()
    }

    def "test filterEven mixed"() {
        given:
        def evens = List.of(-2, 2, 4, 6, -1, 1, 3, 5)

        expect:
        Step3_Recursion_Answer.filterEven(evens) == List.of(-2, 2, 4, 6)
    }

    def "test square < 0"() {
        given:
        def negatives = List.of(-4, -3, -2, -1)
        
        expect:
        Step3_Recursion_Answer.square(negatives) == List.of(16, 9, 4, 1)
    }    
    
    def "test square 0"() {
        given:
        def negatives = List.of(0)

        expect:
        Step3_Recursion_Answer.square(negatives) == List.of(0)
    }    
    
    def "test square > 0"() {
        given:
        def negatives = List.of(4, 3, 2, 1)

        expect:
        Step3_Recursion_Answer.square(negatives) == List.of(16, 9, 4, 1)
    }

    def "test square mixed"() {
        given:
        def negatives = List.of(-1, 2)

        expect:
        Step3_Recursion_Answer.square(negatives) == List.of(1, 4)
    }

    def "test sum"() {
        expect:
        Step3_Recursion_Answer.sum(List.of(-1, 1, 2, 3, -4, 5)) == 6
    }
    def "test sumOfSquaresOfPositiveEvenNumbersUpTo < 0"() {
        given:
        int max = -1

        expect:
        Step3_Recursion_Answer.sumOfSquaresOfPositiveEvenNumbersUpTo(max) == 0
    }

    def "test sumOfSquaresOfPositiveEvenNumbersUpTo 0"() {
        given:
        int max = 0

        expect:
        Step3_Recursion_Answer.sumOfSquaresOfPositiveEvenNumbersUpTo(max) == 0
    }

    def "test sumOfSquaresOfPositiveEvenNumbersUpTo > 0"() {
        given:
        int max = 12

        expect:
        Step3_Recursion_Answer.sumOfSquaresOfPositiveEvenNumbersUpTo(max) == 364
    }
}
