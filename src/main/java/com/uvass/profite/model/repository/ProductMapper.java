package com.uvass.profite.model.repository;

import com.uvass.profite.model.entity.Product;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet result, int i) throws SQLException {
        Product product = new Product();
        product.setId(result.getInt("id"));
        product.setName(result.getString("name"));
        product.setImage(result.getString("image"));
        product.setOldPrice(result.getFloat("oldPrice"));
        product.setPrice(result.getFloat("price"));
        product.setDescription(result.getString("description"));
        product.setInstallments_id(result.getInt("installments_id"));
        return product;
    }
}
