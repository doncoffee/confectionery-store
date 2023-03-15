package by.academy.controller.impl.gotopage;

import by.academy.controller.Command;
import by.academy.service.BrandService;
import by.academy.service.StoreService;
import by.academy.service.SupplierService;
import by.academy.service.SweetsService;
import by.academy.service.dto.BrandDTO;
import by.academy.service.dto.StoreDTO;
import by.academy.service.dto.SupplierDTO;
import by.academy.service.dto.SweetsDTO;
import by.academy.service.impl.BrandServiceImpl;
import by.academy.service.impl.StoreServiceImpl;
import by.academy.service.impl.SupplierServiceImpl;
import by.academy.service.impl.SweetsServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GoToEditSweetsCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        SweetsService service = new SweetsServiceImpl();
        BrandService brandService = new BrandServiceImpl();
        StoreService storeService = new StoreServiceImpl();
        SupplierService supplierService = new SupplierServiceImpl();
        List<BrandDTO> brandList = brandService.readAllBrands();
        request.setAttribute("brands", brandList);
        List<StoreDTO> storeList = storeService.readAllStores();
        request.setAttribute("stores", storeList);
        List<SupplierDTO> supplierList = supplierService.readAllSuppliers();
        request.setAttribute("suppliers", supplierList);
        SweetsDTO sweetsDTO = service.selectSweetsById(id);
        request.setAttribute("sweets", sweetsDTO);
        return "/jsp/edit/editSweets.jsp";
    }
}
