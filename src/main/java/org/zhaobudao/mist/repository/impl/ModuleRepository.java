package org.zhaobudao.mist.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.zhaobudao.mist.model.Module;


@Repository
public class ModuleRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedJdbcTemplate;

    public int save(Module module) {
        String sql = "insert into module(project_id,name,create_by,create_date)" + " values(:projectId,:name,:createBy,:createDate)";
        KeyHolder holder = new GeneratedKeyHolder();
        namedJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(module), holder);
        return holder.getKey().intValue();
    }

    public Module get(int id) {
        String sql = "select * from module a where a.id=?";
        Module m = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Module>(Module.class), id);
        return m;
    }

    public List<Module> findAll() {
        String sql = "select * from module";
        List<Module> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Module>(Module.class));
        return list;
    }

    public List<Module> findByProject(int projectId) {
        String sql = "select * from module a where a.project_id=?";
        List<Module> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Module>(Module.class), projectId);
        return list;
    }

    public void update(Module module) {
        String sql = "update module set project_id=:projectId,name=:name" + ",modify_by=:modifyBy,modify_date=:modifyDate where id=:id";
        namedJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(module));
    }

    public void delete(Module module) {
        deleteById(module.getId());
    }

    public void deleteById(int id) {
        String sql = "delete from module where id=?";
        jdbcTemplate.update(sql, id);
    }
}
