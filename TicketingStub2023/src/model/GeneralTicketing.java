package model;

import java.util.List;
/**
 * Classe gérant les prix des tickets et leurs critères, mais n'implémentant pas encore le calcul en lui-même
 * @author C. Mathy
 *
 */
public abstract class GeneralTicketing implements IComputePrice{
	
	private List<String> categories = List.of("a", "b");
	private List<String> days = List.of("lundi", "mardi", "mercredi", "jeudi", "vendredi", "samedi", "dimanche");
	
	@Override
	public List<String> getCategories() {
		return categories;
	}

	@Override
	public List<String> getDays() {
		return this.days;
	}

	@Override
	public int computeWithNameOfDay(char category, String dayOfWeek, int age) {
		int day;
		switch (dayOfWeek) {
			case "lundi": day= 1;break;
			case "mardi": day= 2;break;
			case "mercredi": day= 3;break;
			case "jeudi": day= 4;break;
			case "vendredi": day= 5;break;
			case "samedi": day= 6;break;
			case "dimanche": day= 7;break;
			default: day = 0;
		}
		return compute(category, day, age);
	}
}
