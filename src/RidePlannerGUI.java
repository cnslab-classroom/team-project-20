import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import Path.Service;
import Path.Path;
import RIDE.Ride;
import AmusementPark.Everland;
import AmusementPark.LotteWorld;
import RIDE.Everland_Rides.*;

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
        selectionPanel.setLayout(new GridLayout(2, 1, 10, 10));

        // Dropdown for amusement park
        JComboBox<String> amusementParkDropdown = new JComboBox<>(new String[]{"Everland", "LotteWorld"});

        // Checkboxes for all ride types
        JCheckBox thrillCheckBox = new JCheckBox("Thrill");
        JCheckBox adventureCheckBox = new JCheckBox("Adventure");
        JCheckBox waterCheckBox = new JCheckBox("Water");
        JCheckBox familyCheckBox = new JCheckBox("Family");
        JCheckBox horrorCheckBox = new JCheckBox("Horror");
        JCheckBox fantasyCheckBox = new JCheckBox("Fantasy");
        JCheckBox kidsCheckBox = new JCheckBox("Kids");
        JCheckBox interactiveCheckBox = new JCheckBox("Interactive");

        // Panel for checkboxes
        JPanel checkBoxPanel = new JPanel(new GridLayout(2, 4, 10, 10));
        checkBoxPanel.add(thrillCheckBox);
        checkBoxPanel.add(adventureCheckBox);
        checkBoxPanel.add(waterCheckBox);
        checkBoxPanel.add(familyCheckBox);
        checkBoxPanel.add(horrorCheckBox);
        checkBoxPanel.add(fantasyCheckBox);
        checkBoxPanel.add(kidsCheckBox);
        checkBoxPanel.add(interactiveCheckBox);

        // Add components to the selection panel
        selectionPanel.add(new JLabel("Select Amusement Park:"));
        selectionPanel.add(amusementParkDropdown);
        selectionPanel.add(new JLabel("Select Ride Types:"));
        selectionPanel.add(checkBoxPanel);

        // Button to calculate
        JButton calculateButton = new JButton("Find Optimal Path");

        // Result panel
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
        JLabel distanceLabel = new JLabel("Total distance: ");
        JLabel timeLabel = new JLabel("Total time taken: ");
        JLabel optimalPathLabel = new JLabel("Optimal Path: ");
        resultPanel.add(distanceLabel);
        resultPanel.add(timeLabel);
        resultPanel.add(optimalPathLabel);

        // Add components to the main panel
        mainPanel.add(selectionPanel, BorderLayout.NORTH);
        mainPanel.add(calculateButton, BorderLayout.CENTER);
        mainPanel.add(resultPanel, BorderLayout.SOUTH);

        // Add the main panel to the frame
        frame.add(mainPanel);

        // Data setup
        Everland everland = new Everland();
        LotteWorld lotteworld = new LotteWorld();

        ArrayList<Ride> everlandRides = everland.getEverlandRides();
        ArrayList<Ride> lotteWorldRides = lotteworld.getLotteWorldRides();
        // Add rides to LotteWorld here if needed

        // Calculate the optimal path
        calculateButton.addActionListener(e -> {
            ArrayList<Ride> selectedRides = new ArrayList<>();
            if (amusementParkDropdown.getSelectedItem().equals("Everland")) {
                selectedRides.addAll(everlandRides);
            } else {
                selectedRides.addAll(lotteWorldRides);
            }

            // Filter rides by selected types
            List<String> selectedTypes = new ArrayList<>();
            if (thrillCheckBox.isSelected()) selectedTypes.add("thrill");
            if (adventureCheckBox.isSelected()) selectedTypes.add("adventure");
            if (waterCheckBox.isSelected()) selectedTypes.add("water");
            if (familyCheckBox.isSelected()) selectedTypes.add("family");
            if (horrorCheckBox.isSelected()) selectedTypes.add("horror");
            if (fantasyCheckBox.isSelected()) selectedTypes.add("fantasy");
            if (kidsCheckBox.isSelected()) selectedTypes.add("kids");
            if (interactiveCheckBox.isSelected()) selectedTypes.add("interactive");

            List<Ride> filteredRides = Ride.getRidesByType(selectedRides, selectedTypes);

            // Check if there are rides for each selected type and more than one ride in total
            boolean allTypesHaveRides = selectedTypes.stream()
                .allMatch(type -> filteredRides.stream().anyMatch(ride -> ride.getRideType().equals(type)));

            if (filteredRides.size() < 2 || !allTypesHaveRides) {
                JOptionPane.showMessageDialog(frame, "No rides match the selected types or not enough rides to form a path.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Use the first ride in the filtered list as the starting ride
            Ride startingRide = filteredRides.get(0);

            // Calculate optimal path
            Service service = new Service(startingRide, new ArrayList<>(filteredRides));
            service.optimalPath();
            Path minPath = service.getMinPath();

            // Update labels with results
            distanceLabel.setText("Total distance: " + minPath.getWeight() * 100 / 1.5 + " meters");
            timeLabel.setText("Total time taken: " + minPath.getWeight() + " minutes");

            // Update optimal path label
            StringBuilder pathString = new StringBuilder();
            for (int i = 0; i < minPath.getPathList().size(); i++) {
                pathString.append(minPath.getPathList().get(i).getRideName());
                if (i < minPath.getPathList().size() - 1) {
                    pathString.append(" -> ");
                }
            }
            optimalPathLabel.setText("Optimal Path: " + pathString);
        });

        // Show the frame
        frame.setVisible(true);
    }
}
