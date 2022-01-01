package Arrays;

import java.util.List;

public class Mod {

    public static int findMod(String A, int B) {
        int r = 1;
        int len = A.length();
        int ans = 0;

        for(int i= len-1; i>=0; i--){
           // int p = (((A.charAt(i) - '0') % B) * r % B) % B;
            ans = ans + ((A.charAt(i) - '0') * r);
            r = (r*10) % B;
            ans = ans % B;
        }
        return ans;
    }

    public static void main(String[] args) {
        //System.out.println(hcf(12,5));
        int[] arr = new int[]{1000727, 1000727, 1000641, 1000517, 1000212, 1000532, 1000727, 1001000, 1000254, 1000106, 1000405, 1000100, 1000736, 1000727, 1000727, 1000787, 1000105, 1000713, 1000727, 1000333, 1000069, 1000727, 1000877, 1000222, 1000727, 1000505, 1000641, 1000533, 1000727, 1000727, 1000727, 1000508, 1000475, 1000727, 1000573, 1000727, 1000618, 1000727, 1000309, 1000486, 1000792, 1000727, 1000727, 1000426, 1000547, 1000727, 1000972, 1000575, 1000303, 1000727, 1000533, 1000669, 1000489, 1000727, 1000329, 1000727, 1000050, 1000209, 1000109 };
       // int[] arr = new int[]{1,1,1,1,2,3,4,5,6,7};
        System.out.println(arr.length/3);
        System.out.println(repeatedNumber(arr));
    }

    static int hcf(int a, int b) {
        if(b == 0) return a;
        int c = a % b;
        a = b;
        return hcf(a,c);
    }

    public static int repeatedNumber(final int[] a) {
        int ele1 = -1;
        int ele2 = -1;
        int cnt1 = 0;
        int cnt2 = 0;

        for(int i : a) {
            if(i == ele1) cnt1++;
            else if(i == ele2) cnt2++;
            else if(cnt1 == 0) {
                cnt1 = 1;
                ele1 = i;
            }
            else if(cnt2 == 0) {
                cnt2 = 1;
                ele2 = i;
            }
            else {
                cnt1--;
                cnt2--;
            }
        }

        int c1 = 0, c2 = 0;
        for(int i : a){
            if(i == ele1) c1++;
            if(i == ele2) c2++;
        }

        if(c1 > a.length/3) return ele1;
        if(c2 > a.length/3) return ele2;
        return -1;
    }
}

