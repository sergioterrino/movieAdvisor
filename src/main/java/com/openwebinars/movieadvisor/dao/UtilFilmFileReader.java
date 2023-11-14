package com.openwebinars.movieadvisor.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.ResourceUtils;

import com.openwebinars.movieadvisor.model.Film;

public class UtilFilmFileReader {
	
	public static List<Film> readFile(final String path, final String separator, final String listSeparator) throws FileNotFoundException, IOException{
		
		List<Film> result = new ArrayList<>();
		
		try {
			result = Files.lines(Paths.get(ResourceUtils.getFile(path).toURI()))
					.skip(1)
					.map(line -> {
						String[] values = line.split(separator); //separo la linea por el ;
						return new Film(Long.parseLong(values[0]), values[1], values[2], Arrays.asList(values[3].split(listSeparator)));
					}).collect(Collectors.toList());
		} catch (IOException e) {
			System.out.println("Error leyendo el fichero de datos: imdb_data");
		}
		
		return result;
		
	}

}
