
package Utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Format {

    public static String format(BigDecimal number) {
        DecimalFormat currencyFormatter = new DecimalFormat("###,###,###,##0");
        return currencyFormatter.format(number) + " VNĐ ";
    }

    public static String format1(BigDecimal number) {
        DecimalFormat currencyFormatter = new DecimalFormat("###,###,###,##0");
        return currencyFormatter.format(number);
    }
}
