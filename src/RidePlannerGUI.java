import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import Path.Service;
import Path.Path;
import RIDE.Ride;
import AmusementPark.Everland;
import AmusementPark.LotteWorld;

public class RidePlannerGUI {
    public static void main(String[] args) {
        // Create the main JFrame
        JFrame frame = new JFrame("Amusement Park Ride Planner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);

        // Main container panel with padding
        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding
        mainPanel.setBackground(new Color(240, 248, 255)); // Light blue background

        // Title Label
        JLabel titleLabel = new JLabel("\uD83C\uDFA2 Amusement Park Ride Planner \uD83C\uDFA1", JLabel.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        titleLabel.setForeground(new Color(34, 89, 120)); // Darker blue
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Top panel for park and ride type selection
        JPanel selectionPanel = new JPanel();
        selectionPanel.setLayout(new GridBagLayout());
        selectionPanel.setBackground(new Color(240, 248, 255)); // Match main background

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;

        // Amusement park dropdown
        JLabel amusementParkLabel = new JLabel("Select Amusement Park:");
        amusementParkLabel.setForeground(new Color(34, 89, 120)); // Match title color
        JComboBox<String> amusementParkDropdown = new JComboBox<>(new String[]{"Everland", "LotteWorld"});
        amusementParkDropdown.setPreferredSize(new Dimension(200, 25)); // Fixed size
        
        JLabel startingRideLabel = new JLabel("Select Starting Ride:");
        startingRideLabel.setForeground(new Color(34, 89, 120)); // Match title color
        JComboBox<String> startingRideComboBox = new JComboBox<>();
        startingRideComboBox.setPreferredSize(new Dimension(200, 25)); // Fixed size

        JLabel rideTypeLabel = new JLabel("Select Ride Types:");
        rideTypeLabel.setForeground(new Color(34, 89, 120)); // Match title color
        JCheckBox adventureCheckBox = new JCheckBox("Adventure");
        JCheckBox familyCheckBox = new JCheckBox("Family");

        // Adding components to selection panel
        gbc.gridx = 0; gbc.gridy = 0; selectionPanel.add(amusementParkLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 0; selectionPanel.add(amusementParkDropdown, gbc);

        gbc.gridx = 0; gbc.gridy = 1; selectionPanel.add(startingRideLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 1; selectionPanel.add(startingRideComboBox, gbc);

        gbc.gridx = 0; gbc.gridy = 2; selectionPanel.add(rideTypeLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        JPanel checkBoxPanel = new JPanel(new GridLayout(1, 2));
        checkBoxPanel.add(adventureCheckBox);
        checkBoxPanel.add(familyCheckBox);
        checkBoxPanel.setBackground(new Color(240, 248, 255)); // Match background
        selectionPanel.add(checkBoxPanel, gbc);

        // Button to calculate optimal path
        JButton calculateButton = new JButton("Find Optimal Path");
        calculateButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        calculateButton.setBackground(new Color(135, 206, 250)); // Light sky blue
        calculateButton.setForeground(Color.WHITE);

        // Result panel with titled border
        JPanel resultPanel = new JPanel(new GridBagLayout());
        resultPanel.setBorder(BorderFactory.createTitledBorder(
                new LineBorder(Color.GRAY, 2, true),
                "Results", TitledBorder.LEFT, TitledBorder.TOP,
                new Font("SansSerif", Font.BOLD, 16), Color.BLACK));
        resultPanel.setBackground(Color.WHITE);

        GridBagConstraints resultGbc = new GridBagConstraints();
        resultGbc.insets = new Insets(5, 5, 5, 5);
        resultGbc.fill = GridBagConstraints.HORIZONTAL;

        // Labels for results
        JLabel distanceLabel = new JLabel("Total Distance: ");
        distanceLabel.setForeground(new Color(34, 89, 200)); // Match title color
        JLabel timeLabel = new JLabel("Total Walk Time: ");
        timeLabel.setForeground(new Color(34, 89, 200)); // Match title color
        JLabel waitTimeLabel = new JLabel("Total Wait Time: ");
        waitTimeLabel.setForeground(new Color(34, 89, 200)); // Match title color
        JLabel totalTimeLabel = new JLabel("Total Time (Wait + Walk): ");
        totalTimeLabel.setForeground(new Color(34, 89, 200)); // Match title color
        JLabel pathLabel = new JLabel("Optimal Path: ");
        pathLabel.setForeground(new Color(34, 89, 200)); // Match title color

        // Customize labels
        distanceLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        timeLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        waitTimeLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        totalTimeLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        pathLabel.setFont(new Font("SansSerif", Font.BOLD, 14));

        // Values for results
        JLabel distanceValue = new JLabel();
        JLabel timeValue = new JLabel();
        JLabel waitTimeValue = new JLabel();
        JLabel totalTimeValue = new JLabel();
        JLabel pathValue = new JLabel();

        // Add components to resultPanel
        resultGbc.gridx = 0; resultGbc.gridy = 0;
        resultPanel.add(distanceLabel, resultGbc);
        resultGbc.gridx = 1; resultGbc.gridy = 0;
        resultPanel.add(distanceValue, resultGbc);

        resultGbc.gridx = 0; resultGbc.gridy = 1;
        resultPanel.add(timeLabel, resultGbc);
        resultGbc.gridx = 1; resultGbc.gridy = 1;
        resultPanel.add(timeValue, resultGbc);

        resultGbc.gridx = 0; resultGbc.gridy = 2;
        resultPanel.add(waitTimeLabel, resultGbc);
        resultGbc.gridx = 1; resultGbc.gridy = 2;
        resultPanel.add(waitTimeValue, resultGbc);

        resultGbc.gridx = 0; resultGbc.gridy = 3;
        resultPanel.add(totalTimeLabel, resultGbc);
        resultGbc.gridx = 1; resultGbc.gridy = 3;
        resultPanel.add(totalTimeValue, resultGbc);

        resultGbc.gridx = 0; resultGbc.gridy = 4;
        resultPanel.add(pathLabel, resultGbc);
        resultGbc.gridx = 1; resultGbc.gridy = 4;
        resultPanel.add(pathValue, resultGbc);

        // Bottom panel for the button
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(calculateButton);
        buttonPanel.setBackground(new Color(240, 248, 255)); // Match main background

        // Add components to the main panel
        mainPanel.add(selectionPanel, BorderLayout.WEST);
        mainPanel.add(resultPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(mainPanel);

        // Data setup
        Everland everland = new Everland();
        LotteWorld lotteworld = new LotteWorld();
        ArrayList<Ride> everlandRides = everland.getEverlandRides();
        ArrayList<Ride> lotteWorldRides = lotteworld.getLotteWorldRides();

        // Update startingRideComboBox based on selected amusement park
        amusementParkDropdown.addActionListener(e -> {
            startingRideComboBox.removeAllItems();
            ArrayList<Ride> rides = amusementParkDropdown.getSelectedItem().equals("Everland") ? everlandRides : lotteWorldRides;
            for (Ride ride : rides) {
                startingRideComboBox.addItem(ride.getRideName());
            }
        });
        amusementParkDropdown.setSelectedIndex(0);

        // Calculate the optimal path
        calculateButton.addActionListener(e -> {
            int totalWaitTime = 0;

            ArrayList<Ride> selectedRides = new ArrayList<>();
            if (amusementParkDropdown.getSelectedItem().equals("Everland")) {
                selectedRides.addAll(everlandRides);
                Everland.setWaitTime();
                totalWaitTime = Everland.getWaitTime();
            } else {
                selectedRides.addAll(lotteWorldRides);
                LotteWorld.setWaitTime();
                totalWaitTime = LotteWorld.getWaitTime();
            }

            // Filter rides by selected types
            List<String> selectedTypes = new ArrayList<>();
            if (adventureCheckBox.isSelected()) selectedTypes.add("adventure");
            if (familyCheckBox.isSelected()) selectedTypes.add("family");

            List<Ride> filteredRides = Ride.getRidesByType(selectedRides, selectedTypes);

            // Get starting ride
            String startingRideName = (String) startingRideComboBox.getSelectedItem();
            Ride startingRide = selectedRides.stream()
                    .filter(ride -> ride.getRideName().equals(startingRideName))
                    .findFirst()
                    .orElse(filteredRides.get(0));

            // Compute the optimal path
            Service service = new Service(startingRide, new ArrayList<>(filteredRides));
            service.optimalPath();
            Path minPath = service.getMinPath();

            // Calculate total wait time and walk time
            int totalPathWaitTime = minPath.getPathList().stream().mapToInt(Ride::getWaitTime).sum();
            double totalWalkTime = minPath.getWeight();
            double totalTime = totalPathWaitTime + totalWalkTime;

            // Update result values
            distanceValue.setText(String.format("%.2f meters", minPath.getWeight() * 100 / 1.5));
            waitTimeValue.setText(totalPathWaitTime + " minutes");
            timeValue.setText(String.format("%.2f minutes", totalWalkTime));
            totalTimeValue.setText(String.format("%.2f minutes", totalTime));

            // Generate the path string
            StringBuilder pathString = new StringBuilder();
            for (int i = 0; i < minPath.getPathList().size(); i++) {
                pathString.append(minPath.getPathList().get(i).getRideName());
                if (i < minPath.getPathList().size() - 1) {
                    pathString.append(" -> ");
                }
            }
            pathValue.setText(pathString.toString());
        });

        // Display the JFrame
        frame.setVisible(true);
    }
}
