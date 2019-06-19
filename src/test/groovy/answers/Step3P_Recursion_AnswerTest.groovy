package answers

import answers.Step3P_Recursion_Answer
import io.vavr.collection.List
import spock.lang.Specification

/**
 * Created by mtumilowicz on 2019-06-18.
 */
class Step3P_Recursion_AnswerTest extends Specification {

    def "test square < 0"() {
        given:
        def negatives = List.of(-4, -3, -2, -1)
        
        expect:
        Step3P_Recursion_Answer.square(negatives) == List.of(16, 9, 4, 1)
    }    
    
    def "test square 0"() {
        given:
        def negatives = List.of(0)

        expect:
        Step3P_Recursion_Answer.square(negatives) == List.of(0)
    }    
    
    def "test square > 0"() {
        given:
        def negatives = List.of(4, 3, 2, 1)

        expect:
        Step3P_Recursion_Answer.square(negatives) == List.of(16, 9, 4, 1)
    }

    def "test square mixed"() {
        given:
        def negatives = List.of(-1, 2)

        expect:
        Step3P_Recursion_Answer.square(negatives) == List.of(1, 4)
    }

    def "test sum"() {
        expect:
        Step3P_Recursion_Answer.sum(List.of(-1, 1, 2, 3, -4, 5)) == 6
    }
}
