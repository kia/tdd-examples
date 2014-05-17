import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class QueryString {

    private final Map<String, String> keyValues;
    
    public QueryString(String query) {
        keyValues = new HashMap<>();
        Arrays.asList(query.split("&")).stream().filter(s -> s.split("=").length > 1).forEach(s -> {
            String[] split = s.split("=");
            keyValues.put(split[0], split[1]);
        });
    }

    public int count() {
        return keyValues.size();
    }

    public String value(String key) {
        return keyValues.get(key);
    }
}
