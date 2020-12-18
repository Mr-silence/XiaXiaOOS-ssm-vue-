package com.teskinfly.controller;

import com.teskinfly.domain.Orders;
import com.teskinfly.pojo.send.DataReturn;
import com.teskinfly.pojo.send.ReturnCode;
import com.teskinfly.pojo.charts.ChartsOption;
import com.teskinfly.service.impl.DataAnalyzeService;
import com.teskinfly.service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/dataAnalyze")
@CrossOrigin
@ResponseBody
public class DataAnalyzeController {
//    @Autowired
//    FoodService foodService;
    @Autowired
    OrderService orderService;
    @Autowired
    DataAnalyzeService dataAnalyzeService;
    @RequestMapping("/totalSale")
    public DataReturn totalSale() {
        ChartsOption saleData = dataAnalyzeService.getSaleData();
        return new DataReturn(new ArrayList() {{
            add(saleData);
        }}, ReturnCode.SUCCESS, null);
    }

    @RequestMapping("/income")
    //练一下converter
    public DataReturn income(Date beginDate, Date endDate) {
//        System.out.println(beginDate);
//        System.out.println(endDate);
        List<Orders> byDate = orderService.findByDate(beginDate, endDate);
//        ChartsOption chartsOption = GenerateChartsOption.generateIncomeData(byDate);
        ChartsOption incomeData = dataAnalyzeService.getIncomeData(byDate);
        return new DataReturn(new ArrayList() {{
            add(incomeData);
        }}, ReturnCode.SUCCESS, null);
    }
}

