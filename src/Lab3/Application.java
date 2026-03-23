package Lab3;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Application {
    public static void main() {
        Path inputPath = Paths.get("in.txt");
        Path outputPath = Paths.get("out.txt");

        try{
            List<String> lines = Files.readAllLines(inputPath);
            List<String> resultLines = new ArrayList<>();

            for (String line : lines){
                String lineWithExtraNewline = line + "\n";//a

                String[] parts = lineWithExtraNewline.split("\\.");
                StringBuilder sb = new StringBuilder();

                for(int i = 0; i < parts.length; i ++){
                    sb.append(parts[i]);
                    if(i < parts.length - 1){
                        sb.append(".\n");
                    }
                }

                String finalResult = sb.toString();
                System.out.print(finalResult);

                resultLines.add(finalResult);
            }

            Files.write(outputPath, resultLines);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}