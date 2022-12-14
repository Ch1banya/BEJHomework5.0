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


public class ModifyProductTest {

    static ProductService productService;
    Product product = null;
    Faker faker = new Faker();
    int id;




    @Test
    void modifyProductInFoodCategoryTest() throws IOException {
        Response<Product> response = productService.modifyProduct(product)
                .execute();
        id =  response.body().getId();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
    }

    @SneakyThrows
    @AfterEach
    void tearDown() {
        Response<ResponseBody> response = productService.deleteProduct(id).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
    }



}