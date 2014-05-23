package urlqueryparser;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class QueryString {

    private final Map<String, String> keyValues;
    
    public QueryString(String q) {
        keyValues = Arrays.stream(q.split("&"))
                .map(s -> s.split("="))
                .filter(pair -> pair.length == 2)
                .collect(Collectors.toMap(pair -> pair[0], pair -> pair[1]));
    }

    public int count() {
        return keyValues.size();
    }

    public String value(String key) {
        return keyValues.get(key);
    }
}
