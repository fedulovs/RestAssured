import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    private static String BASE_URI = "https://reqres.in/";

    @BeforeAll
    static void setup() {
        // Setting BaseURI once
        RestAssured.baseURI = BASE_URI;
    }
}
