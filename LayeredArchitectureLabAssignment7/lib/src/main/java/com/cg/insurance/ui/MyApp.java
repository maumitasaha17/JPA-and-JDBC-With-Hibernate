package com.cg.insurance.ui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cg.insurance.exception.EmployeeNotFoundException;
import com.cg.insurance.model.Address;
import com.cg.insurance.model.Employee;
import com.cg.insurance.service.EmployeeServiceImpl;
import com.cg.insurance.service.IEmployeeService;
import com.cg.insurance.utils.MainUtils;


public class MyApp {
	public static void main(String[] args) throws IOException {
		Logger logger = LogManager.getLogger("MyApp.class");
		MainUtils mainUtils = new MainUtils();
		logger.info("Instantiated MyApp.");
		mainUtils.start();
	}
}