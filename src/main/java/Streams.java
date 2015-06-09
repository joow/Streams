import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class Streams {
    public static <T, R> List<R> map(List<T> ts, Function<T, R> mapper) {
        if (ts == null) {
            return null;
        }

        return ts.stream().map(mapper).collect(Collectors.toList());
    }

    public static <T> List<T> reverse(List<T> ts) {
        if (ts == null) {
            return null;
        }

        return ts.stream().collect(ArrayList::new, (ts1, t) -> ts1.add(0, t), ArrayList::addAll);
    }

    public static <T> T last(List<T> ts) {
        if (ts == null || ts.isEmpty()) {
            return null;
        }

        return ts.stream().reduce((acc, t) -> t).get();
    }
}
