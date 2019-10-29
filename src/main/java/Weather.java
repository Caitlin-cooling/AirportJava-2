import java.util.Random;

public class Weather {
    public static void main(String args[]) {
        Weather weather = new Weather();
        System.out.println(weather.getWeather());
    }

    protected String getWeather() {
        return checkWeather(getRandom());
    }

    protected String checkWeather(int number) {
        if(number > 3) {
            return "Fine";
        } else {
            return "Stormy";
        }
    }

    private int getRandom() {
        Random random = new Random();
        return random.nextInt(11);
    }
}