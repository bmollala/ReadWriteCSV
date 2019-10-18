package co.za.assessment.ReadWriteCSV.services;

import java.util.List;

import co.za.assessment.ReadWriteCSV.entity.CSVBean;

public interface CSVService {

	public List<CSVBean> getCSVList();
	
	public String updateList(List<CSVBean> csvList);
}
