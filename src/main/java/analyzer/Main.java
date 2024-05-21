package analyzer;

public class Main {
    public static void main(String[] args) {
FileManager fileManager = new FileManager();
Encryptor encryptor = new Encryptor();
BruteForce bruteForce = new BruteForce();



char[] temp = fileManager.readFile("/run/media/philipk/68220e73-ac0a-41b6-b3bb-cb3b9497ba49/git/com.javarush.cryptoanalyzer.service/resources/in.txt");
//char[] temp2 = encryptor.encrypt(temp, 4);
char[] temp2 = bruteForce.decryptByBruteForce(temp);
fileManager.writeFile(temp2, "/run/media/philipk/68220e73-ac0a-41b6-b3bb-cb3b9497ba49/git/com.javarush.cryptoanalyzer.service/resources/out.txt");
    }
}