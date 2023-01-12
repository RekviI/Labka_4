package org.example.ServiceLayer;

import org.mariuszgromada.math.mxparser.Expression;
import org.mariuszgromada.math.mxparser.Argument;
import java.math.BigDecimal;
import java.math.RoundingMode;
public class MathModel
{
    private final double a;
    private final double b;
    private final double c;
    private final String func;
    public MathModel(double a, double b, double c, String func)
    {
        this.a = a;
        this.b = b;
        this.c = c;
        this.func = func;
    }
    public double Integration()
    {
        double h = (b - a) / c ;
        Argument a1 = new Argument("x = " + a);
        Expression f1 = new Expression(func, a1);
        Argument b1 = new Argument("x = " + b);
        Expression f2 = new Expression(func, b1);
        double sum1 = 0;
        double sum2 = 0;
        for (int i = 1; i < c; i += 2)
        {
            double x = a + h * i;
            Argument x1 = new Argument("x = " + x);
            Expression f = new Expression(func, x1);
            sum1 += f.calculate();
        }
        for (int i = 2; i < c-1; i += 2)
        {
            double x = a + h * i;
            Argument x1 = new Argument("x = " + x);
            Expression f = new Expression(func, x1);
            sum2 += f.calculate();
        }
        double res = f1.calculate() + f2.calculate();
        double result = (h/3) * (res + 4 * sum1 + 2 * sum2);
        return result;
        /*
        BigDecimal bd = new BigDecimal(result);
        BigDecimal roundRes = bd.setScale(3, RoundingMode.FLOOR);
        return roundRes.doubleValue();

         */
    }
}
