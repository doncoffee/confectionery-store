package by.academy.service.impl;

import by.academy.dao.DAO;
import by.academy.dao.impl.ChocolateDAOImpl;
import by.academy.entity.Chocolate;
import by.academy.service.ChocolateService;
import by.academy.service.dto.ChocolateDTO;
import by.academy.util.Mapper;
import by.academy.util.impl.ChocolateMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ChocolateServiceImpl implements ChocolateService {
    private Mapper<Chocolate, ChocolateDTO> mapper = new ChocolateMapper();
    private final DAO<Chocolate> dao = new ChocolateDAOImpl();

    @Override
    public ChocolateDTO createChocolate(ChocolateDTO chocolateDTO) {
        Chocolate chocolate = dao.create(mapper.mapToEntity(chocolateDTO));
        return mapper.mapToDTO(chocolate);
    }

    @Override
    public List<ChocolateDTO> readAllChocolates() {
        return dao.read()
                .stream()
                .map(map ->mapper.mapToDTO(map))
                .collect(Collectors.toList());
    }

    @Override
    public ChocolateDTO updateChocolate(ChocolateDTO chocolateDTO) {
        Chocolate chocolate = dao.update(mapper.mapToEntity(chocolateDTO));
        return mapper.mapToDTO(chocolate);
    }

    @Override
    public void deleteChocolate(int id) {
        dao.delete(id);
    }

    @Override
    public ChocolateDTO selectChocolateById(int id) {
        Chocolate chocolate = dao.selectById(id);
        return mapper.mapToDTO(chocolate);
    }

    @Override
    public List<ChocolateDTO> findAllByPage(Integer currentPage, Integer recordsPerPage) {
        return dao.findAllByPage(currentPage, recordsPerPage)
                .stream()
                .map(map ->mapper.mapToDTO(map))
                .collect(Collectors.toList());
    }

    @Override
    public Integer getNumberOfRows() {
        return dao.getNumberOfRows();
    }
}
