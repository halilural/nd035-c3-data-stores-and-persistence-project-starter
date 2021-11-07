package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.mapper.PetMapper;
import com.udacity.jdnd.course3.critter.mapper.PetMapperImpl;
import com.udacity.jdnd.course3.critter.model.dto.PetDTO;
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
public class PetDAOImpl implements PetDAO {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    private PetMapper petMapper = new PetMapperImpl();

    // Properties

    private static final String ID = "id";
    private static final String TYPE = "type";
    private static final String NAME = "name";
    private static final String NOTES = "notes";
    private static final String OWNER_ID = "owner_id";
    private static final String BIRTH_DATE = "birth_date";

    // Queries

    private static final String INSERT_PET =
            "INSERT INTO pet (type, name, owner_id, birth_date, notes) " +
                    "VALUES (:" + TYPE + ", :" + NAME + ", :" + OWNER_ID + ", :" + BIRTH_DATE + ", :" + NOTES + ")";

    private static final String SELECT_PET =
            "SELECT * FROM pet WHERE id = :" + ID;

    private static final String SELECT_PETS =
            "SELECT * FROM pet";

    private static final String SELECT_PET_WITH_OWNER =
            "SELECT * FROM pet WHERE owner_id = :" + OWNER_ID;

    // Mapper

    private static final RowMapper<PetDTO> petDTORowMapper =
            new BeanPropertyRowMapper<>(PetDTO.class);


    @Override
    public Long savePet(PetDTO petDTO) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(INSERT_PET,
                new MapSqlParameterSource()
                        .addValue(TYPE, petDTO.getType().name())
                        .addValue(NAME, petDTO.getName())
                        .addValue(NOTES, petDTO.getNotes())
                        .addValue(OWNER_ID, petDTO.getOwnerId())
                        .addValue(BIRTH_DATE, petDTO.getBirthDate()), keyHolder);
        return keyHolder.getKey().longValue();
    }

    @Override
    public PetDTO getPet(long petId) {
        return jdbcTemplate.queryForObject(SELECT_PET,
                new MapSqlParameterSource()
                        .addValue(ID, petId),
                petDTORowMapper);
    }

    @Override
    public List<PetDTO> getPets() {
        return jdbcTemplate.query(SELECT_PETS, petDTORowMapper);
    }

    @Override
    public List<PetDTO> getPetsByOwner(long ownerId) {
        return jdbcTemplate.query(SELECT_PET_WITH_OWNER,
                new MapSqlParameterSource()
                        .addValue(OWNER_ID, ownerId),
                petDTORowMapper);
    }

}
