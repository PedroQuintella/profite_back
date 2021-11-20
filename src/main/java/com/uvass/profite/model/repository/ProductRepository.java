package com.uvass.profite.model.repository;

import com.uvass.profite.model.entity.Installments;
import com.uvass.profite.model.entity.Product;
import com.uvass.profite.model.repository.ProductMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProductRepository {
    private JdbcTemplate jdbcTemplate;
    private InstallmentsRepository installmentsRepository;

    public ProductRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
        this.installmentsRepository = new InstallmentsRepository(jdbcTemplate);
    }

    public List<Product> search() throws Exception {
        String sql = "SELECT * FROM product";
        List<Product> search = (List<Product>) jdbcTemplate.query(sql, new ProductMapper());

        search.forEach(product -> {
            Installments installments = installmentsRepository.search(product.getInstallments_id());
            product.setInstallments(installments);
        });

        if (search.size() > 0) {
            return search;
        }

        throw new Exception("Nenhum produto encontrado.");
    }
}
