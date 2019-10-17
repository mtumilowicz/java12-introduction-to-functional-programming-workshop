package answers

import answers.Step5_Reduce_Answer
import io.vavr.collection.List
import spock.lang.Specification

import java.util.function.BiFunction
import java.util.function.Function

/**
 * Created by mtumilowicz on 2019-06-19.
 */
class Step5_Reduce_AnswerTest extends Specification {
    
    def "test reduce empty list"() {
        given:
        def empty = List.<Integer> empty()
        BiFunction<Integer, Integer, Integer> sum = { first, second -> first + second }

        expect:
        Step5_Reduce_Answer.reduce(empty, 0, sum) == 0
    }

    def "test reduce single element list"() {
        given:
        def list = List.of(1)
        BiFunction<Integer, Integer, Integer> sum = { first, second -> first + second }

        expect:
        Step5_Reduce_Answer.reduce(list, 0, sum) == 1
    }

    def "test reduce multiple element list"() {
        given:
        def list = List.of(1, 2, 3)
        BiFunction<Integer, Integer, Integer> sum = { first, second -> first + second }

        expect:
        Step5_Reduce_Answer.reduce(list, 0, sum) == 6
    }
    
    def "test flatMap empty list"() {
        given:
        def empty = List.<Integer> empty()
        Function<Integer, List<Integer>> triple = { List.of(it, it, it) }

        expect:
        Step5_Reduce_Answer.flatMap(empty, triple) == List.empty()
    }

    def "test flatMap single element list"() {
        given:
        def list = List.of(1)
        Function<Integer, List<Integer>> triple = { List.of(it, it, it) }

        expect:
        Step5_Reduce_Answer.flatMap(list, triple) == List.of(1, 1, 1)
    }

    def "test flatMap multiple element list"() {
        given:
        def list = List.of(1, 2, 3)
        Function<Integer, List<Integer>> triple = { List.of(it, it, it) }

        expect:
        Step5_Reduce_Answer.flatMap(list, triple) == List.of(1, 1, 1, 2, 2, 2, 3, 3, 3)
    }

    def "test generatePositivesUpTo < 0"() {
        given:
        int max = -1

        expect:
        Step5_Reduce_Answer.generatePositivesUpTo(max) == List.empty()
    }

    def "test generatePositivesUpTo 0"() {
        given:
        int max = 0

        expect:
        Step5_Reduce_Answer.generatePositivesUpTo(max) == List.empty()
    }

    def "test generatePositivesUpTo > 0"() {
        given:
        int max = 5

        expect:
        Step5_Reduce_Answer.generatePositivesUpTo(max) == List.of(1, 2, 3, 4, 5)
    }

    def "test filterEven all even"() {
        given:
        def evens = List.of(-2, 2, 4, 6)

        expect:
        Step5_Reduce_Answer.filterEven(evens) == List.of(-2, 2, 4, 6)
    }

    def "test filterEven all odd"() {
        given:
        def evens = List.of(-1, 1, 3, 5)

        expect:
        Step5_Reduce_Answer.filterEven(evens) == List.empty()
    }

    def "test filterEven mixed"() {
        given:
        def evens = List.of(-2, 2, 4, 6, -1, 1, 3, 5)

        expect:
        Step5_Reduce_Answer.filterEven(evens) == List.of(-2, 2, 4, 6)
    }

    def "test square < 0"() {
        given:
        def negatives = List.of(-4, -3, -2, -1)

        expect:
        Step5_Reduce_Answer.square(negatives) == List.of(16, 9, 4, 1)
    }

    def "test square 0"() {
        given:
        def negatives = List.of(0)

        expect:
        Step5_Reduce_Answer.square(negatives) == List.of(0)
    }

    def "test square > 0"() {
        given:
        def negatives = List.of(4, 3, 2, 1)

        expect:
        Step5_Reduce_Answer.square(negatives) == List.of(16, 9, 4, 1)
    }

    def "test square mixed"() {
        given:
        def negatives = List.of(-1, 2)

        expect:
        Step5_Reduce_Answer.square(negatives) == List.of(1, 4)
    }

    def "test sum"() {
        expect:
        Step5_Reduce_Answer.sum(List.of(-1, 1, 2, 3, -4, 5)) == 6
    }

    def "test sumOfSquaresOfPositiveEvenNumbersUpTo < 0"() {
        given:
        int max = -1

        expect:
        Step5_Reduce_Answer.sumOfSquaresOfPositiveEvenNumbersUpTo(max) == 0
    }

    def "test sumOfSquaresOfPositiveEvenNumbersUpTo 0"() {
        given:
        int max = 0

        expect:
        Step5_Reduce_Answer.sumOfSquaresOfPositiveEvenNumbersUpTo(max) == 0
    }

    def "test sumOfSquaresOfPositiveEvenNumbersUpTo > 0"() {
        given:
        int max = 12

        expect:
        Step5_Reduce_Answer.sumOfSquaresOfPositiveEvenNumbersUpTo(max) == 364
    }
    
}
