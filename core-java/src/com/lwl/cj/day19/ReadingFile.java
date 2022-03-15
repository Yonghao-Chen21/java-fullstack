package com.lwl.cj.day19;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadingFile {

	public static void main(String[] args) {
		try {
			List<String> list = Files.readAllLines(Paths.get("note"));
			System.out.println(list);

		}catch (NumberFormatException e) {
		}catch (ArithmeticException e) {
		}catch (IOException e) {
		}catch (Exception e) {
		}
	}
}
