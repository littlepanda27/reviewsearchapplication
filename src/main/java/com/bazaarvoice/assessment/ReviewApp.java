package com.bazaarvoice.assessment;

import com.bazaarvoice.assessment.dao.ReviewRepository;
import com.bazaarvoice.assessment.model.Review;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

@SpringBootApplication
public class ReviewApp {

	private static final Logger log = LoggerFactory.getLogger(ReviewApp.class);

	public static void main(String[] args) {
		SpringApplication.run(ReviewApp.class, args);
	}

	@Bean
	public CommandLineRunner loadData(ReviewRepository repository, ApplicationArguments applicationArguments) {
		return (String... args) -> {
			String[] nextRecord;
			int count = 0;
			File file;
			try {
				String inputFilePath = CollectionUtils.isNotEmpty(applicationArguments.getNonOptionArgs()) ? applicationArguments.getNonOptionArgs().get(0) : null;
				if (inputFilePath != null) {
					//File Absolute path is being passed.
					file = new File(inputFilePath);
				} else {
					//Use the file from the class path (For Development)
					ClassPathResource classPathResource = new ClassPathResource("/data_fullstack.csv");
					file = classPathResource.getFile();
				}

				if (!file.exists()) {
					throw new FileNotFoundException("Unable to find the input datafile.");
				}

				FileReader filereader = new FileReader(file);

				CSVReader csvReader = new CSVReader(filereader, ',', '\"', '\0');

				//skip the first line which has csv data headers
				csvReader.readNext();
				while ((nextRecord = csvReader.readNext()) != null) {

					if ((nextRecord.length == 2) && (nextRecord[0].trim().length() != 0) && (nextRecord[1].trim().length() != 0)) {
						repository.save(new Review((Long.valueOf(nextRecord[0])), nextRecord[1].toString()));
					}
					count++;
				}

			} catch (Exception e) {
				log.error("Exception occurred while reading entries from CSV.", e);
				throw e;
			}
		};
	}

}
