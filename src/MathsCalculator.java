/**
 * Created by gbs05347 on 20-01-2020.
 */
public class MathsCalculator {

    public void calculate(Operation op){
        String s= "calculated value:"+op.perform(3,4);
        Printer p = s1 -> {
            System.out.println(s1);
        };
        p.print(s);
    }

    public static void main(String[] args) {
        MathsCalculator calc = new MathsCalculator();
        Operation op = new Addition();
        calc.calculate(op);
        Operation<Integer> op1 = ( a,  b)->{return a+b;};
        calc.calculate(op1);
    }
}

interface Printer{
    public void print(String s);
}
