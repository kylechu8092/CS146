package HW.HW2;

public class isBad {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left <= right)
        {
            int mid = (right - left)/2 + left;
            if (isBadVersion(mid) && !isBadVersion(mid-1))
            {
                return mid;
            }
            else if (isBadVersion(mid))
            {
                //Left
                right = mid;
            }
            else
            {
                //Right
                left = mid+1;
            }
        }
        return left;
    }
    
    boolean isBadVersion(int version){
        return true;
    }

}
