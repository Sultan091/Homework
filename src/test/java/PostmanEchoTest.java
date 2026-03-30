import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostmanEchoTest {

    @Test
    public void testGet() {

        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")

                .when()
                .get("https://postman-echo.com/get")

                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
    }

    @Test
    public void testGetFullCheck() {

        given()
                .queryParam("foo", "bar")

                .when()
                .get("https://postman-echo.com/get")

                .then()
                .statusCode(200)
                .body("args.foo", equalTo("bar"))
                .body("url", containsString("foo=bar"));
    }

    @Test
    public void testPost() {

        String body = "{ \"name\": \"Sultan\", \"age\": 25 }";

        given()
                .contentType("application/json")
                .body(body)

                .when()
                .post("https://postman-echo.com/post")

                .then()
                .statusCode(200)
                .body("data.name", equalTo("Sultan"))
                .body("data.age", equalTo(25));
    }

    @Test
    public void testPut() {

        String body = "{ \"name\": \"Sultan\" }";

        given()
                .contentType("application/json")
                .body(body)

                .when()
                .put("https://postman-echo.com/put")

                .then()
                .statusCode(200)
                .body("data.name", equalTo("Sultan"));
    }

    @Test
    public void testPatch() {

        String body = "{ \"age\": 30 }";

        given()
                .contentType("application/json")
                .body(body)

                .when()
                .patch("https://postman-echo.com/patch")

                .then()
                .statusCode(200)
                .body("data.age", equalTo(30));
    }

    @Test
    public void testDelete() {

        given()

                .when()
                .delete("https://postman-echo.com/delete")

                .then()
                .statusCode(200);
    }
}