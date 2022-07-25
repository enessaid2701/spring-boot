package com.example.demo.controller;

import com.example.demo.model.OperationModel;
import com.example.demo.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CalculatorController
{
    OperationModel operationModel = new OperationModel();

    @Autowired
    private CalculatorService calculatorService;

    @RequestMapping("/calculator")
    public String getCalculatorPage(Model model)
    {
        model.addAttribute("operationModel", operationModel);
        return "calculator";
    }

    @RequestMapping(value = "/calculator/add", params = "add", method = RequestMethod.POST)
    public String add(@ModelAttribute("operationModel") OperationModel operationModel, Model model)
    {
        model.addAttribute("result", calculatorService.add(operationModel));
        return "/calculator";
    }

    @RequestMapping(value = "/calculator/subtract", params = "subtract", method = RequestMethod.POST)
    public String subtract(@ModelAttribute("operationModel") OperationModel operationModel, Model model)
    {
        model.addAttribute("result", calculatorService.subtract(operationModel));
        return "/calculator";
    }

    @RequestMapping(value = "/calculator/multiply", params = "multiply", method = RequestMethod.POST)
    public String multiply(@ModelAttribute("operationModel") OperationModel operationModel, Model model)
    {
        model.addAttribute("result", calculatorService.multiply(operationModel));
        return "/calculator";
    }

    @RequestMapping(value = "/calculator/divide", params = "divide", method = RequestMethod.POST)
    public String divide(@ModelAttribute("operationModel") OperationModel operationModel, Model model)
    {
        model.addAttribute("result", calculatorService.divide(operationModel));
        return "/calculator";
    }

    @RequestMapping(value="/calculator/result", params="clearSimple", method = RequestMethod.POST)
    public String clearSimple(@ModelAttribute("operationModel")  OperationModel operationModel, Model model ){
        model.addAttribute("operationModel",  calculatorService.clearSimple(operationModel));
        model.addAttribute("result", 0);
        return "calculator";
    }

}
