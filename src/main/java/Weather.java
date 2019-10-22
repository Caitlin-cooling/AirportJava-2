import java.util.Random;

public class Weather {
    public static void main(String args[]) {
        Weather weather = new Weather();
        System.out.println(weather.getWeather());
    }

    public String getWeather() {
        return checkWeather(getRandom());
    }

    public String checkWeather(int number) {
        if(number > 3) {
            return "Fine";
        } else {
            return "Rainy";
        }
    }

    private int getRandom() {
        Random random = new Random();
        return random.nextInt(11);
    }
}