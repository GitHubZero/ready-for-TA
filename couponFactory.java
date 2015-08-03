import java.util.*;

public class couponFactory {
    private List<Coupon> couponList;
    private HashMap<Integer, Coupon> map = new HashMap<Integer, Coupon>();
    public couponFactory(List<Coupon> couponList) {
        this.couponList = couponList;
        for (Coupon item : couponList) {
            map.put(item.locationId, item);
        }
    }
    public Coupon findBestCoupon(int locationId) {
        if (map.containsKey(locationId)) {
            return map.get(locationId);
        }else{
            while(!map.containsKey(locationId)) {
                Location temp = findLocation(locationId);
                locationId = temp.parentLocationId;
                if (locationId == -1) {
                    System.out.println("there is no coupon");
                }
            }
            return map.get(locationId);
        }
    }
}