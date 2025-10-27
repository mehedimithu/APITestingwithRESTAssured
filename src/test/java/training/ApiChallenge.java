package training;

import static io.restassured.RestAssured.given;
import org.junit.jupiter.api.Test;
import models.Product;

/*
 * Challenge:
 * Create a product called "Sweatband" in Category 3 for $5
 * Update the sweatband price to be $6
 * Retrieve information (ID, name, description, price, category_id, category_name) about sweatband
 * Delete the sweatband product
 */

public class ApiChallenge {
    // Implement the API calls and assertions for the challenge here
    String BASE_URL = "http://localhost:8888/api_testing";
    String endpoints = "/product/create.php";

    @Test
    public void createSweatbandProduct() {
        Product newProduct = new Product("Sweatband", 5.0, "High absorbency sweatband", 3);

        var response = given().body(newProduct).when().post(BASE_URL + endpoints).then().statusCode(201);
        response.log().body();
    }

    @Test
    public void updateSweatbandProduct() {
        Product updatedProduct = new Product(1002,"Sweatband", 6.0, "High absorbency sweatband", 3);

        var response = given().body(updatedProduct).when().put(BASE_URL + "/product/update.php").then().statusCode(200);
        response.log().body();
    }

    @Test
    public void getSweatbandProduct() {
        String endpoint = "/product/read_one.php?id=1002";
        var response = given().when().get(BASE_URL + endpoint).then().statusCode(200);
        response.log().body();
    }

    @Test
    public void deleteSweatbandProduct() {
        String endpoint = "/product/delete.php?id=1002";
        var response = given().when().delete(BASE_URL + endpoint).then().statusCode(200);
        response.log().body();
    }
}
