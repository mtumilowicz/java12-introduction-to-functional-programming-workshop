package workshop


import io.vavr.collection.List
import spock.lang.Specification

import java.util.function.Function 
/**
 * Created by mtumilowicz on 2019-06-19.
 */
class Step4_FlatMap_WorkshopTest extends Specification {

    def "test flatMap empty list"() {
        given:
        def empty = List.<Integer> empty()
        Function<Integer, List<Integer>> triple = { List.of(it, it, it) }

        expect:
        Step4_FlatMap_Workshop.flatMap(empty, triple) == List.empty()
    }

    def "test flatMap single element list"() {
        given:
        def list = List.of(1)
        Function<Integer, List<Integer>> triple = { List.of(it, it, it) }

        expect:
        Step4_FlatMap_Workshop.flatMap(list, triple) == List.of(1, 1, 1)
    }

    def "test flatMap multiple element list"() {
        given:
        def list = List.of(1, 2, 3)
        Function<Integer, List<Integer>> triple = { List.of(it, it, it) }

        expect:
        Step4_FlatMap_Workshop.flatMap(list, triple) == List.of(1, 1, 1, 2, 2, 2, 3, 3, 3)
    }

    def "test generatePositivesUpTo < 0"() {
        given:
        int max = -1

        expect:
        Step4_FlatMap_Workshop.generatePositivesUpTo(max) == List.empty()
    }

    def "test generatePositivesUpTo 0"() {
        given:
        int max = 0

        expect:
        Step4_FlatMap_Workshop.generatePositivesUpTo(max) == List.empty()
    }

    def "test generatePositivesUpTo > 0"() {
        given:
        int max = 5

        expect:
        Step4_FlatMap_Workshop.generatePositivesUpTo(max) == List.of(1, 2, 3, 4, 5)
    }

    def "test filterEven all even"() {
        given:
        def evens = List.of(-2, 2, 4, 6)

        expect:
        Step4_FlatMap_Workshop.filterEven(evens) == List.of(-2, 2, 4, 6)
    }

    def "test filterEven all odd"() {
        given:
        def evens = List.of(-1, 1, 3, 5)

        expect:
        Step4_FlatMap_Workshop.filterEven(evens) == List.empty()
    }

    def "test filterEven mixed"() {
        given:
        def evens = List.of(-2, 2, 4, 6, -1, 1, 3, 5)

        expect:
        Step4_FlatMap_Workshop.filterEven(evens) == List.of(-2, 2, 4, 6)
    }

    def "test square < 0"() {
        given:
        def negatives = List.of(-4, -3, -2, -1)

        expect:
        Step4_FlatMap_Workshop.square(negatives) == List.of(16, 9, 4, 1)
    }

    def "test square 0"() {
        given:
        def negatives = List.of(0)

        expect:
        Step4_FlatMap_Workshop.square(negatives) == List.of(0)
    }

    def "test square > 0"() {
        given:
        def negatives = List.of(4, 3, 2, 1)

        expect:
        Step4_FlatMap_Workshop.square(negatives) == List.of(16, 9, 4, 1)
    }

    def "test square mixed"() {
        given:
        def negatives = List.of(-1, 2)

        expect:
        Step4_FlatMap_Workshop.square(negatives) == List.of(1, 4)
    }

    def "test sum"() {
        expect:
        Step4_FlatMap_Workshop.sum(List.of(-1, 1, 2, 3, -4, 5)) == 6
    }

    def "test sumOfSquaresOfPositiveEvenNumbersUpTo < 0"() {
        given:
        int max = -1

        expect:
        Step4_FlatMap_Workshop.sumOfSquaresOfPositiveEvenNumbersUpTo(max) == 0
    }

    def "test sumOfSquaresOfPositiveEvenNumbersUpTo 0"() {
        given:
        int max = 0

        expect:
        Step4_FlatMap_Workshop.sumOfSquaresOfPositiveEvenNumbersUpTo(max) == 0
    }

    def "test sumOfSquaresOfPositiveEvenNumbersUpTo > 0"() {
        given:
        int max = 12

        expect:
        Step4_FlatMap_Workshop.sumOfSquaresOfPositiveEvenNumbersUpTo(max) == 364
    }

}
