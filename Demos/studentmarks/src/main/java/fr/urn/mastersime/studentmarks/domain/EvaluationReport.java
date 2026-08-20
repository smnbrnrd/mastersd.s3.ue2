package fr.urn.mastersime.studentmarks.domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.context.FacesContext;
import jakarta.servlet.ServletContext;

@ApplicationScoped
public class EvaluationReport {

    private List<EvaluationRecord> records = new ArrayList<>();

    public EvaluationReport() {
		System.out.println("Loading records from file...");

        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		String dbPath = servletContext.getRealPath("/WEB-INF/marks.txt");
		File marksFile = new File(dbPath);
		try {
			Scanner scanner = new Scanner(marksFile);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] tokens = line.split(",");
                EvaluationRecord record = new EvaluationRecord();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.FRENCH);
                record.setDate(LocalDate.parse(tokens[0], formatter));
                record.setSubject(tokens[1]);
                record.setType(EvaluationRecord.Type.valueOf(tokens[2]));
                record.setValue(Double.parseDouble(tokens[3]));
                record.setMaxValue(Double.parseDouble(tokens[4]));
                this.records.add(record);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		System.out.println("Records loaded successfully (" + records.size() + " records).");
    }

	public List<EvaluationRecord> getRecords() {
		return records;
	}

	public void addRecord(EvaluationRecord record) {
		this.records.add(record);
	}

	@Override
	public String toString() {
		return "EvaluationReport [records=" + records + "]";
	}

}
