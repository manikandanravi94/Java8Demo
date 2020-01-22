package lambdaExpression;

/**
 * Created by gbs05347 on 20-01-2020.
 */
@FunctionalInterface
public interface Operation<T> {

    T perform(T a, T b);

}
