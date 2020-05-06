package Interview.highFre;

public class SlidingWindowAverage {

    private float[] _array;

    private int _size;

    private int _id;

    private float[] _res;

    public SlidingWindowAverage (int size) {
        _size = size;
        _array = new float[size + 1];
        _id = 0;
        _res = new float[2];
    }

    public int mod (int indx) {
        return indx % (_size + 1);
    }

    public float next (int val) {
        _id++;
        _array[mod(_id)] = _array[mod(_id - 1)] + val;
        if (_id - _size >= 0) {
            return (_array[mod(_id)] - _array[mod(_id - _size)]) / _size;
        }
        else {
            return _array[mod(_id)] / _id;
        }
    }

    public static void main(String[] args) {
        SlidingWindowAverage s = new SlidingWindowAverage(3);
        int[] test = new int[]{1,2,3,4,5,6,7,8,9};
        for (int i = 0; i < test.length; i++) {
            System.out.println(s.next(test[i]));
        }
    }
}
