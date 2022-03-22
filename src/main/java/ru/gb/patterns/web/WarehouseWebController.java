package ru.gb.patterns.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.patterns.model.Warehouse;
import ru.gb.patterns.service.WarehouseService;

@Controller
@RequestMapping(value = "/warehouses")
public class WarehouseWebController {

    private final WarehouseService warehouseService;

    public WarehouseWebController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @GetMapping("/list")
    public String showWarehousesList(Model model) {
        model.addAttribute("warehouses", warehouseService.findAll());
        return "list";
    }

    @GetMapping("/get-form")
    public String showForm(Model model) {
        Warehouse warehouse = new Warehouse();
        model.addAttribute("warehouse", warehouse);
        return "add-new";
    }

    @PostMapping("/add")
    public String createWarehouse(Warehouse warehouse, Model model) {
        warehouseService.save(warehouse);
        return "redirect:/warehouses/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteWarehouse(@PathVariable("id") long id, Model model) {
        Warehouse warehouse = warehouseService.findById(id)
                                  .orElseThrow(() -> new IllegalArgumentException("Invalid warehouse Id:" + id));
        warehouseService.delete(warehouse);
        return "redirect:/warehouses/list";
    }

}
