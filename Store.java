public class Store {
    private List couponList;
    HashMap<Integer, Coupon> map = new HashMap<>(Integer, Coupon);

    for (Coupon item : couponList) {
        if (map.containsKey(item.locationId)) {
            map.put(item.locationId, map.get(item.locationId).add(item));
        }else{
            map.put(item.locationId, new ArrayList<Coupon>(item));
        }
    }
    
    public ArrayList<Coupon> findBestCoupon(int locationId) {
        
        if (map.containsKey(locationId)) {
            return map.get(locationId);
        }else{
            Location location = new Location();
            int parenLocId = location.findLocation(locationId).parentLocationId;
            if (parenLocId == -1) {
                System.out.println("We have no coupon for this location. Sorry!");
            }else{
                return findBestCoupon(parenLocId);
            }
        }
    }
}