class Step1_Loop {

    static int sumOfSquaresOfPositiveEvenNumbersUpTo(int max) {
        int sum = 0;

        for (int x = 1; x <= max; x++) {
            if (x % 2 == 0) {
                sum += x * x;
            }
        }

        return sum;
    }
}
