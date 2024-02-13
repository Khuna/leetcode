package todo;

class MedianFinder {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();

        medianFinder.addNum(6);
        medianFinder.addNum(10);
        medianFinder.addNum(2);
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian());
    }

    private int count;
    private int sum;

    public MedianFinder() {
        count = 0;
        sum = 0;

    }

    public void addNum(int num) {
        sum = sum + num;
        count++;

    }

    public double findMedian() {
        if (count == 0)
            return 0;
        else
            return (double) sum / count;
    }
}
