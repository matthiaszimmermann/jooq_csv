package com.example.jooqcsv;

import static com.example.jooqcsv.db.public_.tables.Author.AUTHOR;

import java.util.Random;
import java.util.stream.Stream;

import org.jooq.DSLContext;
import org.jooq.Record3;

import com.example.jooqcsv.db.public_.tables.records.AuthorRecord;

public class AuthorInserter {

	public static final String [ ] FIRST_NAMES = {"Gustaf", "Hans", "Klaus", "Maria", "Peter", "Anna", "Laura", "Emma"};
	public static final String [ ] LAST_NAMES = {"Müller", "Meier", "Schmid", "Keller", "Gerber", "Weber", "Schneider", "Huber", "Steiner", "Frei", "Moser", "Wyss", "Fischer", "Brunner"};

	private static int authorId = 4;

	private DSLContext dsl;

	public AuthorInserter(DSLContext dsl) {
		this.dsl = dsl;
	} 

	public void insertNumberOfRecords(int records) {
		Random generator = new Random();
		int firstNames = FIRST_NAMES.length;
		int lastNames = LAST_NAMES.length;

		int nextId = getNumberOfAuthors() + 1;
		
		for(int i = 0; i < records; i++) {
			insert(nextId++, FIRST_NAMES[generator.nextInt(firstNames)], LAST_NAMES[generator.nextInt(lastNames)]);
		}
	}

	public void insert(int id, String firstName, String lastName) {
		dsl
		.insertInto(AUTHOR)
		.set(AUTHOR.ID, id)
		.set(AUTHOR.FIRST_NAME, firstName)
		.set(AUTHOR.LAST_NAME, lastName)
		.execute();
	}

	public void printAuthors() {
		printAuthors(0);
	}

	public void printAuthors(int maxrows) {
		System.out.println(
				dsl
				.select(AUTHOR.ID, AUTHOR.FIRST_NAME, AUTHOR.LAST_NAME)
				.from(AUTHOR)
				.fetch()
				);
	}

	public void printNumberOfAuthors() {
		System.out.println("number of authors: " + getNumberOfAuthors());
	}

	public int getNumberOfAuthors() {
		return dsl
				.selectCount()
				.from(AUTHOR)
				.fetchOne(0, int.class);
	}
	
	public void printAuthorsAsCsv() {
		
		// TODO move to format object and writer version
		// http://www.jooq.org/javadoc/latest/org.jooq/org/jooq/CSVFormat.html
		boolean header = false;
		char colSep = ';';
		String nullValue = "{null}";
		
		try (Stream<Record3<Integer, String, String>> rows = dsl
				.select(AUTHOR.ID, AUTHOR.FIRST_NAME, AUTHOR.LAST_NAME)
				.from(AUTHOR)
				.fetch()
				.stream()) 
		{
		    rows.forEach(row -> {
		    	System.out.print(row.formatCSV(header, colSep, nullValue));
		    });
		}		
	}
}
