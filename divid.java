public class divid {
    public int[] divide(int dividend, int divisor) {
        int res[] = new int[2];
        if(divisor == 0)
        {
            res[0] = Integer.MAX_VALUE;
            return res;
        }
        //how to check a integer is negtive
        boolean isNeg = (dividend ^ divisor) < 0;

        if(dividend == Integer.MIN_VALUE)
        {
            dividend += Math.abs(divisor);
            if(divisor == -1)
            {
                res[0] = Integer.MAX_VALUE;
                return res;
            }
            res[0]++;
        }
        if(divisor == Integer.MIN_VALUE)
        {
            return res;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int digit = 0;
        while(divisor <= (dividend>>1))
        {
            divisor <<= 1;
            digit++;
        }
        while(digit>=0)
        {
            if(dividend >= divisor)
            {
                res[0] += 1<<digit;
                dividend -= divisor;
            }
            divisor >>= 1;
            digit--;
        }
        res[1] = dividend;

        res[0] = isNeg? -res[0] : res[0];
        return res;
    }
    
    public static void main(String[] args) {
        int dividend = 4;
        int divisor = 2;
        divid test = new divid();
        System.out.println(test.divide(dividend, divisor)[1]);
    }
}