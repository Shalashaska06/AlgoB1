package model;

import java.util.List;

public interface IComputePrice {
	int compute(char category, int day, int age);

	List<String> getCategories();

	List<String> getDays();

	int computeWithNameOfDay(char category, String dayOfWeek, int age);
}
