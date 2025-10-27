
package training;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class ApiTests {
    String BASE_URL = "http://localhost:8888/api_testing";

    @Test
    public void getCategories() {
        String endpoint = "/category/read.php";

        // Test code for getting categories
        var response = given().when().get(BASE_URL + endpoint).then();
        response.log().body();

    }

    @Test
    public void getProducts() {
        String endpoint = "/product/read_one.php";

        // Test code for getting products
        var response = given().queryParam("id", 2).when().get(BASE_URL + endpoint).then();
        response.log().body();

    }

}