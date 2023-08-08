package files;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetIPs {
    public static String findIPAddressWithHighestFrequency(String filePath) {
        // Create a HashMap to store the frequency of each IP address.
        Map<String, Integer> frequencyMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Read each line from the file.
            while ((line = br.readLine()) != null) {
                // Trim the line to remove leading and trailing whitespaces.
                String ipAddress = line.trim();
                // Update the frequency of the IP address in the HashMap.
                frequencyMap.put(ipAddress, frequencyMap.getOrDefault(ipAddress, 0) + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Find the highest frequency among all the IP addresses.
        int maxFrequency = Collections.max(frequencyMap.values());

        // Create a list to store IP addresses with the highest frequency.
        List<String> ipAddressesWithMaxFrequency = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                // Add IP addresses with the highest frequency to the list.
                ipAddressesWithMaxFrequency.add(entry.getKey());
            }
        }

        // Sort the list of IP addresses in ascending order.
        Collections.sort(ipAddressesWithMaxFrequency);

        // Return the sorted list of IP addresses as a comma-separated string.
        return String.join(", ", ipAddressesWithMaxFrequency);
    }

    // Example usage:
    public static void main(String[] args) {
        String filePath = "path/to/your/file.txt";
        // Call the method to find IP addresses with the highest frequency.
        String result = findIPAddressWithHighestFrequency(filePath);
        System.out.println("IP addresses with highest frequency: " + result);
    }
}
