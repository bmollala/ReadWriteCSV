package co.za.assessment.ReadWriteCSV.services.impl;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Service;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import co.za.assessment.ReadWriteCSV.entity.CSVBean;
import co.za.assessment.ReadWriteCSV.services.CSVService;

@Service
public class CSVServiceImpl implements CSVService{

	private static final String file ="E:\\Documents\\realestatetransactions.csv";
	
	@Override
	public List<CSVBean> getCSVList() {
		return convertToBean();
	}

	@Override
	public String updateList(List<CSVBean> csvList) {
		return writeToCSV1(csvList);
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CSVBean> convertToBean() {

		List<CSVBean>	listOfBeans = null;
		try (Reader reader = Files.newBufferedReader(Paths.get(file));) {

			CsvToBean<CSVBean> csvToBean = new CsvToBeanBuilder(reader)
					.withType(CSVBean.class)
					.withIgnoreLeadingWhiteSpace(true)
					.build();

			listOfBeans = csvToBean.parse();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return listOfBeans;

	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String writeToCSV1(List<CSVBean> csvList) {
		String message = "Successfully updated the csv file";
		try {
			// create a write
			Writer writer = Files.newBufferedWriter(Paths.get(file));

			// create a csv writer
			StatefulBeanToCsv<CSVBean> csvWriter = new StatefulBeanToCsvBuilder<CSVBean>(writer)
					.withSeparator(CSVWriter.DEFAULT_SEPARATOR)
					.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
					.withEscapechar(CSVWriter.DEFAULT_ESCAPE_CHARACTER)
					.withLineEnd(CSVWriter.DEFAULT_LINE_END)
					.withOrderedResults(false)
					.build();


			// write list of objects
			csvWriter.write(csvList);

			// close the writer
			writer.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			message = ex.getMessage();
		}

		return message;
	}
	
	
}
