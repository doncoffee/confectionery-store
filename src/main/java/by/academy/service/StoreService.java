package by.academy.service;

import by.academy.service.dto.StoreDTO;

import java.util.List;

public interface StoreService {
    StoreDTO createStore(StoreDTO storeDTO);

    List<StoreDTO> readAllStores();

    StoreDTO updateStore(StoreDTO storeDTO);

    void deleteStore(int id);

    StoreDTO selectStoreById(int id);

    List<StoreDTO> findAllByPageAndSearch(Integer currentPage, Integer recordsPerPage, String searchResult);

    Integer getNumberOfRows(String searchResult);
}
