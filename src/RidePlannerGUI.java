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
        frame.setSize(800, 500);

        // Main container panel
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding

        // Top panel for park and ride type selection
        JPanel selectionPanel = new JPanel();
        selectionPanel.setLayout(new GridLayout(3, 2, 10, 10));

        JComboBox<String> amusementParkDropdown = new JComboBox<>(new String[]{"Everland", "LotteWorld"});
        JComboBox<String> startingRideComboBox = new JComboBox<>();
        JCheckBox adventureCheckBox = new JCheckBox("Adventure");
        JCheckBox familyCheckBox = new JCheckBox("Family");

        selectionPanel.add(new JLabel("Select Amusement Park:"));
        selectionPanel.add(amusementParkDropdown);
        selectionPanel.add(new JLabel("Select Starting Ride:"));
        selectionPanel.add(startingRideComboBox);
        selectionPanel.add(new JLabel("Select Ride Types:"));
        JPanel checkBoxPanel = new JPanel(new GridLayout(1, 2));
        checkBoxPanel.add(adventureCheckBox);
        checkBoxPanel.add(familyCheckBox);
        selectionPanel.add(checkBoxPanel);

        // Button to calculate
        JButton calculateButton = new JButton("Find Optimal Path");

        // Result panel with "결과" title
        JPanel resultPanel = new JPanel(new GridBagLayout());
        resultPanel.setBorder(BorderFactory.createTitledBorder(
                new LineBorder(Color.GRAY, 2, true),
                "결과", TitledBorder.LEFT, TitledBorder.TOP,
                new Font("SansSerif", Font.BOLD, 14), Color.BLACK));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Labels for results
        JLabel distanceLabel = new JLabel("Total distance: ");
        distanceLabel.setForeground(Color.BLUE);
        JLabel distanceValue = new JLabel();
        distanceValue.setForeground(Color.BLACK);

        JLabel timeLabel = new JLabel("Total time taken: ");
        timeLabel.setForeground(Color.BLUE);
        JLabel timeValue = new JLabel();
        timeValue.setForeground(Color.BLACK);

        JLabel pathLabel = new JLabel("Optimal Path: ");
        pathLabel.setForeground(Color.BLUE);
        JLabel pathValue = new JLabel();
        pathValue.setForeground(Color.BLACK);

        // Add components to resultPanel
        gbc.gridx = 0; gbc.gridy = 0;
        resultPanel.add(distanceLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        resultPanel.add(distanceValue, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        resultPanel.add(timeLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        resultPanel.add(timeValue, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        resultPanel.add(pathLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        resultPanel.add(pathValue, gbc);

        // Bottom panel for the button
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(calculateButton);

        // Add components to the main panel
        mainPanel.add(selectionPanel, BorderLayout.NORTH);
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
            ArrayList<Ride> selectedRides = new ArrayList<>();
            if (amusementParkDropdown.getSelectedItem().equals("Everland")) {
                selectedRides.addAll(everlandRides);
            } else {
                selectedRides.addAll(lotteWorldRides);
            }

            List<String> selectedTypes = new ArrayList<>();
            if (adventureCheckBox.isSelected()) selectedTypes.add("adventure");
            if (familyCheckBox.isSelected()) selectedTypes.add("family");

            List<Ride> filteredRides = Ride.getRidesByType(selectedRides, selectedTypes);

            String startingRideName = (String) startingRideComboBox.getSelectedItem();
            Ride startingRide = selectedRides.stream()
                    .filter(ride -> ride.getRideName().equals(startingRideName))
                    .findFirst()
                    .orElse(filteredRides.get(0));

            Service service = new Service(startingRide, new ArrayList<>(filteredRides));
            service.optimalPath();
            Path minPath = service.getMinPath();

            distanceValue.setText(String.format("%.2f meters", minPath.getWeight() * 100 / 1.5));
            timeValue.setText(String.format("%.2f minutes", minPath.getWeight()));

            StringBuilder pathString = new StringBuilder();
            for (int i = 0; i < minPath.getPathList().size(); i++) {
                pathString.append(minPath.getPathList().get(i).getRideName());
                if (i < minPath.getPathList().size() - 1) {
                    pathString.append(" -> ");
                }
            }
            pathValue.setText(pathString.toString());
        });

        frame.setVisible(true);
    }
}
