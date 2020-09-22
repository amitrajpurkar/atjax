package com.anr.localmdb.repository;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.anr.common.TestHelper;
import com.anr.localmdb.model.Product;
import com.anr.service.CollectionUpload;
import com.google.gson.Gson;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository prodRepo;
    @Autowired
    private CollectionUpload upload;

    @Autowired
    private Gson gson;

    @Before
    public void setup() {
        try {
            upload.uploadToCollection("products", "test");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_find_productBy_exactName() {
        String givenName = "shaggy";
        List<Product> fetchedProducts = prodRepo.findProductsByName(givenName);

        assertTrue(fetchedProducts.size() == 1);
    }

    @Test
    public void test_find_prodByDescriptionPart() {
        String givenPartOfDescription = "cars1";
        List<Product> fetchedProducts = prodRepo.findProductsWithDescriptionContaining(givenPartOfDescription);

        assertTrue(fetchedProducts.size() > 0);
    }

    private Product getSingleProduct(String jsonFile) {
        return gson.fromJson(TestHelper.getJsonXmlStr(jsonFile), Product.class);
    }
}
