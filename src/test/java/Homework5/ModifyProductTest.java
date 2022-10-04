package Homework5;

import com.github.javafaker.Faker;
import Homework5.api.ProductService;
import Homework5.dto.Product;
import Homework5.utils.RetrofitUtils;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class ModifyProductTest {

    static ProductService productService;
    Product product = null;
    Faker faker = new Faker();
    int id;
    @BeforeAll
    static void beforeAll() {
        productService = RetrofitUtils.getRetrofit()
                .create(ProductService.class);
    }

    @SneakyThrows
    @Test
    void getProductByIdTestTwo() {
        Response<Product> response = productService.getProductById(2).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.body().getId(), equalTo(2));
        assertThat(response.body().getTitle(), equalTo("Bread"));
        assertThat(response.body().getPrice(), equalTo(25));
        assertThat(response.body().getCategoryTitle(), equalTo("Food"));
    }
    @SneakyThrows
    @Test
    void ModifyProductTestOne() {
        Response<Product> response = productService.modifyProduct("price").execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        // assertThat(response.body().getTitle(), equalTo("Bread"));

    }

    @SneakyThrows
    @AfterEach
    void tearDown() {
        Response<ResponseBody> response = productService.deleteProduct(1).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
    }



}