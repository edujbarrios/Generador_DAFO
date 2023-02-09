import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class DafoGenerator {
    public static void main(String[] args) {
        ArrayList<String> forces = new ArrayList<>();
        ArrayList<String> weaknesses = new ArrayList<>();
        ArrayList<String> opportunities = new ArrayList<>();
        ArrayList<String> threats = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the forces (separated by comma): ");
        String forcesInput = input.nextLine();
        for (String force : forcesInput.split(",")) {
            forces.add(force.trim());
        }

        System.out.println("Enter the weaknesses (separated by comma): ");
        String weaknessesInput = input.nextLine();
        for (String weakness : weaknessesInput.split(",")) {
            weaknesses.add(weakness.trim());
        }

        System.out.println("Enter the opportunities (separated by comma): ");
        String opportunitiesInput = input.nextLine();
        for (String opportunity : opportunitiesInput.split(",")) {
            opportunities.add(opportunity.trim());
        }

        System.out.println("Enter the threats (separated by comma): ");
        String threatsInput = input.nextLine();
        for (String threat : threatsInput.split(",")) {
            threats.add(threat.trim());
        }

        int total = forces.size() + weaknesses.size() + opportunities.size() + threats.size();
        int size = 500;
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        g2d.setColor(Color.RED);
        int startAngle = 0;
        int arcAngle = 360 * forces.size() / total;
        g2d.fillArc(0, 0, size, size, startAngle, arcAngle);
        startAngle += arcAngle;

        g2d.setColor(Color.YELLOW);
        arcAngle = 360 * weaknesses.size() / total;
        g2d.fillArc(0, 0, size, size, startAngle, arcAngle);
        startAngle += arcAngle;

        g2d.setColor(Color.GREEN);
        arcAngle = 360 * opportunities.size() / total;
        g2d.fillArc(0, 0, size, size, startAngle, arcAngle);
        startAngle += arcAngle;

        g2d.setColor(Color.BLUE);
        arcAngle = 360 * threats.size() / total;
        g2d.fillArc(0, 0, size, size, startAngle, arcAngle);

        File file = new File("dafo.png");
        try {
            ImageIO.write(image, "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("DAFO saved to dafo.png");
        input.close();
    }
    
    public static void saveToPng(BufferedImage image) {
        File file = new File("dafo.png");
        try {
            ImageIO.write(image, "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("DAFO saved to dafo.png");
    }
}
