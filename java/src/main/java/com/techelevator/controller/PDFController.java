package com.techelevator.controller;

import com.techelevator.business.PDFMakerService;
import com.techelevator.business.PDFServlet;
import com.techelevator.model.UserSavedRecipes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;

@RestController
public class PDFController {

}
