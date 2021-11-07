import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;

public class ReqresApi extends TestBase {

    @Test
    public void printRequisitesTest() {

        Response response = RestAssured.get("/api/users?page=2");

        System.out.println(response.statusCode());
        System.out.println(response.asString());
        System.out.println(response.getBody().asString());
        System.out.println(response.statusLine());

        int statusCode = response.getStatusCode();
        assertThat(statusCode).isEqualTo(200);
    }

    @Test
    public void statusCodeTest() {

        when()
                .get("/api/users?page=2")
                .then()
                .statusCode(200);
    }

    @Test
    public void bodyParameterTest() {

        when()
                .get("/api/users?page=2")
                .then()
                .body("total_pages", is(2));
    }

    @Test
    public void secondObjectTest() {

        when()
                .get("/api/users?page=2")
                .then()
                .body("data[0].id", is(7));
    }

    @Test
    public void singleUserTest() {

        when()
                .get("/api/users/2")
                .then()
                .body("data.email", is("janet.weaver@reqres.in"))
                .body("data.id", is(2))
                .body("data.first_name", is("Janet"))
                .body("data.last_name", is("Weaver"));
    }

    @Test
    public void extraInfoTest() {

        when()
                .get("/api/users/2")
                .then()
                .body("support.text", is("To keep ReqRes free, contributions towards server costs are appreciated!"));
    }
}
