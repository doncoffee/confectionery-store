package by.academy.controller.impl.gotopage;

import by.academy.controller.Command;
import by.academy.service.BrandService;
import by.academy.service.CookieService;
import by.academy.service.StoreService;
import by.academy.service.SupplierService;
import by.academy.service.dto.BrandDTO;
import by.academy.service.dto.CookieDTO;
import by.academy.service.dto.StoreDTO;
import by.academy.service.dto.SupplierDTO;
import by.academy.service.impl.BrandServiceImpl;
import by.academy.service.impl.CookieServiceImpl;
import by.academy.service.impl.StoreServiceImpl;
import by.academy.service.impl.SupplierServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GoToEditCookieCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        CookieService service = new CookieServiceImpl();
        BrandService brandService = new BrandServiceImpl();
        StoreService storeService = new StoreServiceImpl();
        SupplierService supplierService = new SupplierServiceImpl();
        List<BrandDTO> brandList = brandService.readAllBrands();
        request.setAttribute("brands", brandList);
        List<StoreDTO> storeList = storeService.readAllStores();
        request.setAttribute("stores", storeList);
        List<SupplierDTO> supplierList = supplierService.readAllSuppliers();
        request.setAttribute("suppliers", supplierList);
        CookieDTO cookieDTO = service.selectCookieById(id);
        request.setAttribute("cookie", cookieDTO);
        return "/jsp/edit/editCookie.jsp";
    }
}
