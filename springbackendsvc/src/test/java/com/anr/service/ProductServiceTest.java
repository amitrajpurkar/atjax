package com.anr.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.commons.lang3.RandomStringUtils;
import org.bouncycastle.util.Objects;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.anr.localmdb.model.Product;
import com.anr.localmdb.model.Product.ProductBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {
    @Autowired
    private ProductService productSvc;

    @Test
    public void insert_one_product() {
        Product giveProduct = getMock("ironman", "plastic figuring toy of an avenger superhero", "$5.49");
        Product savedProduct = productSvc.saveOne(giveProduct);

        assertNotNull(savedProduct, "the saved product was null");
        assertTrue(Objects.areEqual(savedProduct, giveProduct));
    }

    private Product getMock(String name, String desc, String price) {
        String id = RandomStringUtils.randomAlphabetic(10);
        return new ProductBuilder(id, name).desc(desc).price(price).build();
    }
}
