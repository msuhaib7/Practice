package BitManipulation;

public class BitSet {

    public static boolean checkBitSet(int n ,int k){
        int t = n >> (k-1);

        if((t & 1) > 0 ) return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkBitSet(3,1));
    }
}
