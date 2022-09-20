package mate.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.lib.Injector;
import mate.model.Manufacturer;
import mate.service.ManufacturerService;

public class GetAllManufacturersController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("mate");
    private ManufacturerService manufacturerService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        manufacturerService = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Manufacturer> manufacturers = manufacturerService.getAll();
        req.setAttribute("manufacturers",manufacturers);
        req.getRequestDispatcher("/WEB-INF/views/manufacturers.jsp").forward(req,resp);
    }
}