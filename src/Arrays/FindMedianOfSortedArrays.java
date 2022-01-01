package Arrays;

public class FindMedianOfSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] A = nums1;
        int[] B = nums2;

        if(A.length > B.length) {
            int temp[] = A;
            A = B;
            B = temp;
        }

        int total = A.length + B.length;
        int half = total / 2;

        int l = 0, r = A.length -1;
        int Aleft=0, Bleft = 0, Aright = 0, Bright = 0;
        while(true){
            int s = l+r;
            int i = (l+r)/2;
            if(l+r < 0) i = Math.floorDiv(s,2);
            //int i = (l+r)/2;
            int j = half - i - 2;

            if(i >= 0)
                Aleft = A[i];
            else Aleft = Integer.MIN_VALUE;

            if((i + 1) < A.length ) Aright = A[i + 1];
            else Aright = Integer.MAX_VALUE;

            if(j >= 0) Bleft = B[j];
            else Bleft = Integer.MIN_VALUE;

            if(j + 1 < B.length) Bright = B[j + 1];
            else Bright = Integer.MAX_VALUE;

            if(Aleft <= Bright && Bleft <= Aright){
                if(total%2 == 1){
                    return Math.min(Aright,Bright);
                } else {
                    return ((double)Math.max(Aleft,Bleft) + Math.min(Aright,Bright)) / (double)2;
                }
            }
            else if (Aleft > Bright){
                r = i - 1;
            }
            else l = i + 1;
        }

    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
    }
}
