import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        final String regex = "[a-zA-Z]{2,}\\s[a-zA-Z]{2,}";
        final List<String> fullNames = List.of(
            "John Smith",
            "Jane Doe", 
            "Mary Jane",
            "Alexandra Al&ex",
            "Elizabeth Smith",
            "Igor Rhamon C do Nas"
        );
        final Matcher[] matchers = fullNames.stream()
                .map(name -> Pattern.compile(regex).matcher(name))
                .toArray(Matcher[]::new);
        
        
        
        for (Matcher matcher : matchers) {
            while (matcher.find()) {
                System.out.println("Full match: " + matcher.group(0));
                
                for (int i = 1; i <= matcher.groupCount(); i++) {
                    System.out.println("Group " + i + ": " + matcher.group(i));
                }
            }
        }
    }
}
