package org.testTRBL;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.testTRBL.domain.Product;

import static org.hamcrest.CoreMatchers.is;
import static io.restassured.RestAssured.given;

@QuarkusTest
public class ProductResourceTest {

    @Test
    void getAllProducts(){
        given().
                when().get("/products").then().statusCode(200);
    }

    @Test
    public void testCreateProduct() {
        String inputProduct = """
                {
                    "name": "Coca Cola",
                    "price": 2.5,
                    "stock": 5
                }
                """;
        given()
                .header("Content-Type", "application/json")
                .body(inputProduct)
                .when().post("/products")
                .then()
                .statusCode(200)
                .body("name",is("Coca Cola"))
                .body("price",is(2.5F))
                .body("stock",is(5));
    }

}
