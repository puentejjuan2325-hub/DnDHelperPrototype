import java.util.Locale;

public class DiceRoller {
    private int diceValue;

    public DiceRoller() {
        this.diceValue = -1;
    }

    public int roll(String dice){
        dice = dice.toUpperCase().trim();
        switch (dice){
            case "D20":
                 diceValue = (int)(Math.random()*20) + 1;;
                 break;
            case "D12":
                diceValue = (int)(Math.random()*12) + 1;
                break;
            case "D%":
                diceValue = ((int)(Math.random()*10)) * 10;
                break;
            case "D10":
                diceValue = (int)(Math.random()*10);
                break;
            case "D8":
                diceValue = (int)(Math.random()*8) + 1;
                break;
            case "D6":
                diceValue = (int)(Math.random()*6) + 1;
                break;
            case "D4":
                diceValue = (int)(Math.random()*4) + 1;
                break;
            default:
                System.out.println("Try again. Please enter one of the following: ");
                diceValue = -1;
                break;
        }
        return diceValue;
    }

    public int rollAdvantage(String dice){
        int dValue1 = roll(dice);
        int dValue2 = roll(dice);
        if(dValue1 >= dValue2){
            return dValue1;
        }
        return dValue2;
    }

    public int rollDisadvantage(String dice){
        int dValue1 = roll(dice);
        int dValue2 = roll(dice);
        if(dValue1 <= dValue2){
            return dValue1;
        }
        return dValue2;
    }
}
