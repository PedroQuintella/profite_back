package com.uvass.profite.model.repository;

import com.uvass.profite.model.entity.Installments;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class InstallmentsRepository {
    private JdbcTemplate jdbcTemplate;

    public InstallmentsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Installments search(int id) {
        String sql = "SELECT * FROM installments WHERE id = ?";

        return jdbcTemplate.queryForObject(sql, new InstallmentsMapper(), id);
    }
}
