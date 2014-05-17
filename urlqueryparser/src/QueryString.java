import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class QueryString {

    private final Map<String, String> keyValues;
    
    public QueryString(String query) {
        keyValues = new HashMap<>();
        List<String> pairs = Arrays.asList(query.split("&"));
        pairs.stream().filter(onlyValidPairs()).forEach(pair -> keyValues.put(pair.split("=")[0], pair.split("=")[1]));
    }

    private Predicate<? super String> onlyValidPairs() {
        return s -> s.split("=").length > 1;
    }

    public int count() {
        return keyValues.size();
    }

    public String value(String key) {
        return keyValues.get(key);
    }
}
