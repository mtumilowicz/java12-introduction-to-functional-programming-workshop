public class A_Loop_Answer {

    static int sumOfSquaresOfEvenNumbersUpTo(int max) {
        int sum = 0;

        for (int x = 1; x <= max; x++) {
            if (x % 2 == 0) {
                sum += x * x;
            }
        }

        return sum;
    }
}
