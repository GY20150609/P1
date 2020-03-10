public class WaterBucket {

    public static int getMaxVolume_v0(int[] array){
        int tmpMax = 0;
        int shortSide = 0;
        int tmpVal;
        for(int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++){
                shortSide = Math.min(array[i],array[j]);
                tmpVal = (j - i) * shortSide;
                if (tmpMax < tmpVal){
                    tmpMax = tmpVal;
                }
            }
        }
        return tmpMax;
    }

    public static int getMaxVolume_v1(int left,int right,int[] array){
        int i = left;
        int j = right;
        int length = array.length;
        int shortSide = Math.min(array[left],array[right]);
        int tmpVal = (right - left) * shortSide;
        if (j - i > 1) {
            //左递归
            while (j > 0 && tmpVal < getMaxVolume_v1(i,j-1,array)){
                j--;
            }
            //右递归
            while (i < length - 1 && tmpVal < getMaxVolume_v1(i+1,j,array)){
                i++;
            }
        }
        return (j - i) * Math.min(array[i],array[j]);
    }

    public static void main(String[] args) {
        int[] array = {2,3,4,8,9,4,5};
        System.out.println(getMaxVolume_v1(0,3,array));
    }


}
