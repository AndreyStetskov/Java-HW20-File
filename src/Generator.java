import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Generator {

    public static void main(String[] args) throws IOException {

        List<SuperannuationFund> funds = new ArrayList<>();

        BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("resources/GermanyBank.txt"));
        Stream<String> bank = bufferedReader.lines();

        File result = new File("resources/National funds.txt");
        FileWriter writer = new FileWriter(result);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        bank.forEach(b -> {
            SuperannuationFund fund = new SuperannuationFund();
            fund.setName(b);
            fund.setNational(TypeOfFund.generate());
            fund.setDateCreated(DateGeneration.generate());

            funds.add(fund);
        });

        funds.stream()
                .filter(type -> type.getNational().equals(TypeOfFund.NATIONAL))
                .filter(name -> name.getName().length() < 15)
                .forEach(fund -> {
                    try {
                        bufferedWriter.write(String.valueOf(fund));
                        bufferedWriter.newLine();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
        bufferedWriter.close();
    }
}
