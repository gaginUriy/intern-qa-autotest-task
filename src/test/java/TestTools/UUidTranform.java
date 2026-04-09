package TestTools;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class UUidTranform {

    public static String extractGuidFromResponse(io.restassured.response.Response response) {


        String responseBody = response.asString();

        String uuidRegex = "[a-f0-9]{8}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{4}-[a-f0-9]{12}";

        Pattern pattern = Pattern.compile(uuidRegex);
        Matcher matcher = pattern.matcher(responseBody.toLowerCase());

        if (matcher.find()) {
            return matcher.group();
        } else {
            throw new RuntimeException("GUID не найден в ответе сервера: " + responseBody);
        }
    }
}
