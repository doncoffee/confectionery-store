package by.academy.service;

import by.academy.service.dto.SweetsDTO;

import java.util.List;

public interface SweetsService {
    SweetsDTO createSweets(SweetsDTO sweetsDTO);

    List<SweetsDTO> readAllSweets();

    SweetsDTO updateSweets(SweetsDTO sweetsDTO);

    void deleteSweets(int id);

    SweetsDTO selectSweetsById(int id);

    List<SweetsDTO> findAllByPage(Integer currentPage, Integer recordsPerPage);

    Integer getNumberOfRows();
}
