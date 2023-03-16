package model;

/** Calcul du prix du ticket - Version 1
 * 
 * @author C. Mathy
 *
 */
public class PriceCalculator extends GeneralTicketing{
	@Override
	public int compute(final char category, final int day, final int age) {
        int prix = 0;
        if((category != 'A' && category != 'B')||(day <1 || day >7)||(age<0)) {
            return -1;
        }
        if(category == 'A')
            prix = 10;
        else
            prix = 20;

        switch (day){

        case 1:
            prix -= (prix/5);
            break;
        case 6:
            prix += (prix/2);
            break;
        case 7:
            prix += (prix/2);
            break;
        default:
            break;
        }
        if(age >= 60)
            prix -= 5;
       return prix;
    }

}
