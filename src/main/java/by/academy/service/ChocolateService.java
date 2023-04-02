package by.academy.service;

import by.academy.service.dto.ChocolateDTO;

import java.util.List;

public interface ChocolateService {
    ChocolateDTO createChocolate(ChocolateDTO chocolateDTO);

    List<ChocolateDTO> readAllChocolates();

    ChocolateDTO updateChocolate(ChocolateDTO chocolateDTO);

    void deleteChocolate(int id);

    ChocolateDTO selectChocolateById(int id);

    List<ChocolateDTO> findAllByPageAndSearch(Integer currentPage, Integer recordsPerPage, String searchResult);

    Integer getNumberOfRows(String searchResult);
}
