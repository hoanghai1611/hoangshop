package com.hoanghai.hoangshop.controller;

import com.hoanghai.hoangshop.domain.Order;
import com.hoanghai.hoangshop.domain.Product;
import com.hoanghai.hoangshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("admin/orders")
public class OrderController {

    @Autowired
    OrderService orderService;
    @RequestMapping("")
    public String showOrder (Model model,
                               @RequestParam(name = "name1", required = false) String name1,
                               @RequestParam("page") Optional<Integer> page,
                               @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        Integer pageSize = size.orElse(5);

        Pageable pageable = PageRequest.of(currentPage - 1, pageSize, Sort.by("id"));
        Page<Order> resultPage = null;

        if (StringUtils.hasText(name1)) {
            resultPage = orderService.findByNameContaining(name1, pageable);
            model.addAttribute("name", name1);
        } else {
            resultPage = orderService.findAll(pageable);
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
        model.addAttribute("orderPage", resultPage);
        return "admin/orders/list";
    }
}
