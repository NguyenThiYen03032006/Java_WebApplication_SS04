package com.restaurant.controller;

import com.restaurant.model.RestaurantTable;
import com.restaurant.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class TableController {

    @Autowired
    private TableService tableService;

    @GetMapping({"/", "/list"})
    public String listTables(@RequestParam(value = "cap", required = false) Integer cap, ModelMap model) {
        List<RestaurantTable> tables;
        if (cap != null && cap > 0) {
            tables = tableService.getTablesByCapacity(cap);
        } else {
            tables = tableService.getAllTables();
        }
        model.addAttribute("tables", tables);
        return "list";
    }

    @GetMapping("/details/{id}")
    public ModelAndView details(@PathVariable("id") int id) {
        ModelAndView mav = new ModelAndView("details");
        RestaurantTable table = tableService.getTableById(id);
        mav.addObject("t", table);
        return mav;
    }

    @PostMapping("/update-status")
    public String updateStatus(@RequestParam("id") int id, @RequestParam("status") String status) {
        tableService.updateStatus(id, status);
        return "redirect:/list";
    }

    @PostMapping("/delete/{id}")
    public String deleteTable(@PathVariable("id") int id) {
        tableService.deleteTable(id);
        return "redirect:/list";
    }
}
