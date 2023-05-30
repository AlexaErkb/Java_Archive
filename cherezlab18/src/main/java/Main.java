import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("text.txt"))) {
            String line = reader.readLine();
            while (line != null) {
                Pattern pattern = Pattern.compile("(через)\\s+(\\d*)\\s*(день|дня|дней|недель|неделю|недели|месяцев|месяц|месяца)");
                Matcher matcher = pattern.matcher(line);
                StringBuffer stringBuffer = new StringBuffer();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                while (matcher.find()) {
                    int num = 0;
                    if (matcher.group(2).isEmpty()) {
                        num = 1;
                    } else {
                        num = Integer.parseInt(matcher.group(2));
                    }
                    String timePeriod = matcher.group(3);
                    LocalDate futureDate;
                    if (timePeriod.equals("недель") || timePeriod.equals("неделю") || timePeriod.equals("недели")) {
                        futureDate = LocalDate.now().plusWeeks(num);
                    } else if (timePeriod.equals("дней") || timePeriod.equals("дня") || timePeriod.equals("день")) {
                        futureDate = LocalDate.now().plusDays(num);
                    } else {
                        futureDate = LocalDate.now().plusMonths(num);
                    }
                    String replacement = futureDate.format(formatter);
                    matcher.appendReplacement(stringBuffer, replacement);
                }
                matcher.appendTail(stringBuffer);
                System.out.println(stringBuffer.toString());
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}