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
        return number > 3 ? "Fine" : "Stormy";
    }

    private int getRandom() {
        Random random = new Random();
        return random.nextInt(11);
    }
}