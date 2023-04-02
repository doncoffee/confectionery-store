package by.academy.service.impl;

import by.academy.dao.DAO;
import by.academy.dao.impl.SweetsDAOImpl;
import by.academy.entity.Sweets;
import by.academy.service.SweetsService;
import by.academy.service.dto.SweetsDTO;
import by.academy.util.Mapper;
import by.academy.util.impl.SweetsMapper;

import java.util.List;
import java.util.stream.Collectors;

public class SweetsServiceImpl implements SweetsService {
    private final Mapper<Sweets, SweetsDTO> mapper = new SweetsMapper();
    private final DAO<Sweets> dao = new SweetsDAOImpl();

    @Override
    public SweetsDTO createSweets(SweetsDTO sweetsDTO) {
        Sweets sweets = dao.create(mapper.mapToEntity(sweetsDTO));
        return mapper.mapToDTO(sweets);
    }

    @Override
    public List<SweetsDTO> readAllSweets() {
        return dao.read()
                .stream()
                .map(mapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SweetsDTO updateSweets(SweetsDTO sweetsDTO) {
        Sweets sweets = dao.update(mapper.mapToEntity(sweetsDTO));
        return mapper.mapToDTO(sweets);
    }

    @Override
    public void deleteSweets(int id) {
        dao.delete(id);
    }

    @Override
    public SweetsDTO selectSweetsById(int id) {
        Sweets sweets = dao.selectById(id);
        return mapper.mapToDTO(sweets);
    }

    @Override
    public List<SweetsDTO> findAllByPageAndSearch(Integer currentPage, Integer recordsPerPage, String searchResult) {
        return dao.findAllByPageAndSearch(currentPage, recordsPerPage, searchResult)
                .stream()
                .map(mapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Integer getNumberOfRows(String searchResult) {
        return dao.getNumberOfRows(searchResult);
    }
}
