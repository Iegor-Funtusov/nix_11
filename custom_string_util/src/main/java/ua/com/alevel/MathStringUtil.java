package ua.com.alevel;

public final class MathStringUtil {

    private MathStringUtil() { }

    public static String sum(Object left, Object right) {
        if (left instanceof Number && right instanceof Number) {
            Double l = (Double) left;
            Double r = (Double) right;
            Double sum = l + r;
            return sum.toString();
        }
        String l = String.valueOf(left);
        String r = String.valueOf(right);
        if (l.matches("^[0-9]*") && r.matches("^[0-9]*")) {
            Double dl = Double.parseDouble(l);
            Double dr = Double.parseDouble(r);
            Double sum = dl + dr;
            return sum.toString();
        }
        return l.concat(r);
    }

    public static boolean isNumber(String val) {
        char[] chars = val.toCharArray();
        for (char aChar : chars) {
            if(aChar < 48 || aChar > 57) {
                return false;
            }
        }
        return true;
    }
}
