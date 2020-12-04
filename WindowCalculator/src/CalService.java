import java.math.BigDecimal;

/**
 * 计算机逻辑类
 */
public class CalService {
     static final int DEFAULT_SCALE = 20;
     BigDecimal first ;
     BigDecimal second ;


    /**
     * 包装double类型为BigDecimal
     * @param number
     * @return
     */
    private static BigDecimal getBigDecimal (double number){

         return new BigDecimal(number);
     }

    /**
     * 加法运算
     * @param num1
     * @param num2
     * @return
     */
     public static double add(double num1 ,double num2){
         BigDecimal first = getBigDecimal(num1);
         BigDecimal second = getBigDecimal(num1);
         return first.add(second).doubleValue();
    }

    /**
     * 减法
     * @param num1
     * @param num2
     * @return
     */
    public static double subtract(double num1 , double num2){
         BigDecimal first = getBigDecimal(num1);
         BigDecimal second = getBigDecimal(num1);

         return first.subtract(second).doubleValue();
     }

    /**
     * 乘法
     * @param num1
     * @param num2
     * @return
     */
     public static double multiply(double num1, double num2){
         BigDecimal first = getBigDecimal(num1);
         BigDecimal second = getBigDecimal(num1);

         return first.multiply(second).doubleValue();
     }

     public static double divide(double num1,double num2){
         BigDecimal first = getBigDecimal(num1);
         BigDecimal second = getBigDecimal(num1);

         return  first.divide(second,DEFAULT_SCALE,BigDecimal.ROUND_HALF_UP).doubleValue();
     }

}
