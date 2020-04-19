package com.uca.capas.ncapasp2.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@RequestMapping("/info")
	public @ResponseBody String info() {
		String texto = "Carlos Alejandro Valle Contreras 00018316 Ing. Informática, 4 año";
		return texto;
	}
	//Para mandar a llamar el siguiente metodo usar: http://localhost:8080/calendar?day=18&month=4&year=2020
	
	@RequestMapping("/calendar")
	public @ResponseBody String calendar(@RequestParam int day, @RequestParam int month, @RequestParam int year) {
		String texto = "" ;
		
		//La funcion Calendar toma enero como 0 por tanto se procedera a hacer un hotfix
		month=month-1;
		
		Calendar c = Calendar.getInstance();
		 c.set( year,month,day);
		 int dia =  c.get(Calendar.DAY_OF_WEEK);
		 if(dia==Calendar.SUNDAY){
		   texto="domingo";
		 }
		 else if(dia==Calendar.MONDAY){
			 texto="lunes";
		 }
		 else if(dia==Calendar.TUESDAY){
			texto="martes";
		 }
		 else if(dia==Calendar.WEDNESDAY){
				texto="miercoles";
			 }
		 else if(dia==Calendar.THURSDAY){
				texto="jueves";
			 }
		 else if(dia==Calendar.FRIDAY){
				texto="viernes";
			 }
		 else if(dia==Calendar.SATURDAY){
				texto="sábado";
			 }
		
		return "El día " + day + " del mes " + month + " del año " + year + " fue un "+ texto ;
	}
}
