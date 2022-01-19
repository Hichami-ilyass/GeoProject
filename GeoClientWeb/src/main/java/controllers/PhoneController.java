package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dao.LocalisationL;
import dao.PhoneL;
import entity.Phone;
import entity.Localisation;

@WebServlet("/PhoneController")
public class PhoneController extends HttpServlet {
	
@EJB
private PhoneL service;
@EJB
private LocalisationL serviceloc;

public PhoneController() {
	super();
}

protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	if (request.getParameter("op") == null) {
		String imei = request.getParameter("imei");
		int user = Integer.valueOf(request.getParameter("user"));
		service.create(new Phone(imei), user);
	}else if((request.getParameter("op").toString().equals("chart2"))) {
		List<Localisation> p =serviceloc.findAll();
		response.setContentType("application/json");
		Gson json = new Gson();
		response.getWriter().write(json.toJson(p));
		return;
	}else {
		if(request.getParameter("op").toString().equals("getpos"))  {
			String imei = request.getParameter("imei").toString();
			String date1 = request.getParameter("date1").replace("-", "/");
			String date2 = request.getParameter("date2").replace("-", "/");
			Phone p = service.findByImei(imei);
			List<Localisation> pos = new ArrayList<Localisation>();
			for(Localisation lo : p.getLocalisations()) {
				if( lo.getDate().after(new Date(date1)) && lo.getDate().before(new Date(date2)) ) {
					System.out.println(lo.getLongtitude());
					pos.add(new Localisation(lo.getLatitude(), lo.getLongtitude(), lo.getDate()));
				}
			}
			response.setContentType("application/json");
			Gson json = new Gson();
			response.getWriter().write(json.toJson(pos));
			return;
		}
	}
	
	response.setContentType("application/json");
	List<Phone> phones = service.findAll();
	List<String> imeis = new ArrayList<String>();
	for(Phone p : phones) {
		imeis.add(p.getImei());
	}
	Gson json = new Gson();
	response.getWriter().write(json.toJson(imeis));
}


protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);
}
}
