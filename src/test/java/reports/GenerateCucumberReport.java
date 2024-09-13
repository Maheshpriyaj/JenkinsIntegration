package reports;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GenerateCucumberReport {

	 public static void generateJVMReport(String jsonFilePath) {
	        File reportOutputDirectory = new File("target/cucumber-reports/jvm-report");
	        List<String> jsonFiles = new ArrayList<>();
	        jsonFiles.add(jsonFilePath);

	        Configuration config = new Configuration(reportOutputDirectory, "Your Project Name");
	        config.addClassifications("Platform", "Windows");
	        config.addClassifications("Browser", "Chrome");
	        config.addClassifications("Branch", "master");

	        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, config);
	        reportBuilder.generateReports();
	    }}
