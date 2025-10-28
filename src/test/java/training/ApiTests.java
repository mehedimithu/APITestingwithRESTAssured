
package training;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import org.junit.jupiter.api.Test;
import org.hamcrest.MatcherAssert;
import models.Product;
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
        String endpointForAllProducts = "/product/read.php";

        // Test code for getting products
        var response = given().queryParam("id", 2).when().get(BASE_URL +
                endpoint).then().assertThat().statusCode(200);
        response.log().body();

        given().when().get(BASE_URL + endpointForAllProducts).then().log().body()
                .assertThat().statusCode(200)
                .body("records.size()", greaterThan(0))
                .body("records.id", everyItem(notNullValue()))
                .body("records.name", everyItem(notNullValue()));

    }

    @Test
    public void createProduct() {
        String endpoint = "/product/create.php";
        String requestBody = "{\n" +
                "  \"name\": \"Water Bottle\",\n" +
                "  \"price\": 99.99,\n" +
                "  \"description\": \"A large water bottle, holds 70 OZs\",\n" +
                "  \"category_id\": 3\n" +
                "}";

        // Test code for creating a product
        var response = given().body(requestBody).when().post(BASE_URL + endpoint).then().assertThat().statusCode(201);
        response.log().body();
    }

    @Test
    public void updateProduct() {
        String endpoint = "/product/update.php";
        String requestBody = "{\n" +
                "  \"id\": 1000,\n" +
                "  \"name\": \"Water Bottle 70 OZs\",\n" +
                "  \"price\": 1000.99,\n" +
                "  \"description\": \"A large water bottle, holds 70 OZs\",\n" +
                "  \"category_id\": 3\n" +
                "}";

        // Test code for updating a product
        var response = given().body(requestBody).when().put(BASE_URL + endpoint).then().assertThat().statusCode(200);
        response.log().body();
    }

    @Test
    public void deleteProduct() {
        String endpoint = "/product/delete.php";
        String requestBody = "{\n" +
                "  \"id\": 1000\n" +
                "}";

        // Test code for deleting a product
        var response = given().body(requestBody).when().delete(BASE_URL + endpoint).then().assertThat().statusCode(200);
        response.log().body();
    }

    @Test
    public void createSerializedProduct() {
        String endpoint = "/product/create.php";
        Product newProduct = new Product("Sports Watch", 199.99, "A waterproof sports watch", 3);

        // Test code for creating a product using serialized object
        var response = given().body(newProduct).when().post(BASE_URL + endpoint).then().assertThat().statusCode(201);
        response.log().body();
    }

    @Test
    public void deSerializeProduct() {
        String endpoint = "/product/read_one.php";

        Product expectedProduct = new Product(2, "Cross-Back Training Tank", 299.0, "The most awesome phone of 2013!",
                2, "Active Wear - Women");

        // Test code for deserializing a product
        Product product = given().queryParam("id", 2).when().get(BASE_URL + endpoint).then().assertThat()
                .statusCode(200).extract().as(Product.class);

        MatcherAssert.assertThat(product, samePropertyValuesAs(expectedProduct));
    }
}