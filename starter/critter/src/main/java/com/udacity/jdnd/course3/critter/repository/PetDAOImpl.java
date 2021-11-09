package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.model.dto.PetDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
@Slf4j
public class PetDAOImpl implements PetDAO {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    // Properties

    private static final String ID = "id";
    private static final String TYPE = "type";
    private static final String NAME = "name";
    private static final String NOTES = "notes";
    private static final String CUSTOMER_ID = "customer_id";
    private static final String BIRTH_DATE = "birth_date";

    // Queries

    private static final String INSERT_PET =
            "INSERT INTO pet (type, name, customer_id, birth_date, notes) " +
                    "VALUES (:" + TYPE + ", :" + NAME + ", :" + CUSTOMER_ID + ", :" + BIRTH_DATE + ", :" + NOTES + ")";

    private static final String SELECT_PET =
            "SELECT * FROM pet WHERE id = :" + ID;

    private static final String SELECT_PETS =
            "SELECT * FROM pet";

    private static final String SELECT_PET_WITH_OWNER =
            "SELECT * FROM pet WHERE customer_id = :" + CUSTOMER_ID;

    // Mapper

    private static final RowMapper<PetDTO> petDTORowMapper =
            new BeanPropertyRowMapper<>(PetDTO.class);


    @Override
    public Long savePet(PetDTO petDTO) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(INSERT_PET,
                new MapSqlParameterSource()
                        .addValue(TYPE, petDTO.getType().getValue())
                        .addValue(NAME, petDTO.getName())
                        .addValue(NOTES, petDTO.getNotes())
                        .addValue(CUSTOMER_ID, petDTO.getCustomerId())
                        .addValue(BIRTH_DATE, petDTO.getBirthDate()), keyHolder);
        log.info("Pet is created with id: " + keyHolder.getKey().longValue());
        return keyHolder.getKey().longValue();
    }

    @Override
    public PetDTO getPet(long petId) {
        log.info("Getting pet wth id: " + petId);
        return jdbcTemplate.queryForObject(SELECT_PET,
                new MapSqlParameterSource()
                        .addValue(ID, petId),
                petDTORowMapper);
    }

    @Override
    public List<PetDTO> getPets() {
        log.info("Getting pets...");
        return jdbcTemplate.query(SELECT_PETS, petDTORowMapper);
    }

    @Override
    public List<PetDTO> getPetsByOwner(long ownerId) {
        log.info("Getting pet wth owner id: " + ownerId);
        return jdbcTemplate.query(SELECT_PET_WITH_OWNER,
                new MapSqlParameterSource()
                        .addValue(CUSTOMER_ID, ownerId),
                petDTORowMapper);
    }

}
