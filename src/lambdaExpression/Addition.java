package lambdaExpression;

/**
 * Created by gbs05347 on 20-01-2020.
 */
public class Addition implements Operation<Integer> {


    @Override
    public Integer perform(Integer a, Integer b) {
        return a+b;
    }
}
