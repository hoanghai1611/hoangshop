package com.hoanghai.hoangshop.controller;

import com.hoanghai.hoangshop.domain.Category;
import com.hoanghai.hoangshop.model.CategoryDTO;
import com.hoanghai.hoangshop.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("admin/categories")
public class CategoriesController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping("")
    public String showCategories(Model model,
                                 @RequestParam(name = "name1", required = false) String name1,
                                 @RequestParam("page") Optional<Integer> page,
                                 @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        Integer pageSize = size.orElse(5);

        Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by("id"));
        Page<Category> resultPage = null;

        if (StringUtils.hasText(name1)) {
           resultPage = categoryService.findByNameContaining(name1, pageable);
           model.addAttribute("name", name1);
        } else {
            resultPage = categoryService.findAll(pageable);
        }
        int totalPage = resultPage.getTotalPages();
        if (totalPage > 0) {
            int start = Math.max(1, currentPage - 2);
            int end = Math.min(currentPage + 2, totalPage);

            if (totalPage > 5) {
                if (end == totalPage) {
                    start = end - 5;
                } else if (start == 1) {
                    end = start + 5;
                }
            }
            List<Integer> pageNumbers = IntStream.rangeClosed(start, end)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("categoryPage", resultPage);

        return "admin/categories/list";
    }

    @GetMapping("add")
    public String addCategory(Model model) {
        model.addAttribute("category", new CategoryDTO());
        return "admin/categories/newOrEdit";
    }

    @PostMapping("saveOrUpdate")
    public ModelAndView saveOrUpdate(ModelMap model,
                                     @Valid @ModelAttribute("category") CategoryDTO dto, BindingResult result) {

        if (result.hasErrors()) {
            return new ModelAndView("admin/categories/newOrEdit", model);
        }
        Category entity = new Category();
        BeanUtils.copyProperties(dto, entity);
        categoryService.save(entity);
        if(dto.getEdit()) {
            model.addAttribute("message", "DANH MỤC ĐÃ UPDATE ! ");
        }else {
            model.addAttribute("message", "DANH MỤC ĐÃ ĐƯỢC THÊM VÀO ! ");
        }
        return new ModelAndView("forward:/admin/categories", model);
    }

    @GetMapping("delete/{id}")
    public ModelAndView deleteById(ModelMap model, @PathVariable("id") Long id) {
        categoryService.deletById(id);
        model.addAttribute("message", "DANH MỤC ĐÃ ĐƯỢC XÓA !");
        return new ModelAndView("forward:/admin/categories", model);
    }

    @GetMapping("edit/{id}")
    public ModelAndView editById(ModelMap model, @PathVariable("id") Long id) {
        Optional<Category> opt = categoryService.findById(id);
        CategoryDTO dto = new CategoryDTO();
        if (opt.isPresent()) {
            Category entity = opt.get();
            BeanUtils.copyProperties(entity, dto);
            dto.setEdit(true);
            model.addAttribute("category", dto);
            return new ModelAndView("admin/categories/newOrEdit", model);
        }
        model.addAttribute("message","DANH MUC KHONG TON TAI !!!");
        return new ModelAndView("forward:/admin/categories", model);
    }

}
