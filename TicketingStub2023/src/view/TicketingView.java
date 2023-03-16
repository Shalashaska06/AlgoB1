package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import model.IComputePrice;

public class TicketingView extends JPanel {
	private IComputePrice priceCalculator;
	private JComboBox<String> cat;
	private JComboBox<String> days;
	private JSpinner age = new JSpinner(new SpinnerNumberModel(10, 1,120 , 1 ));
	private JLabel result = new JLabel(" ", SwingConstants.CENTER);

	public TicketingView(IComputePrice pc) {
		super(new BorderLayout());
		priceCalculator = pc;
		createHeader();
		createCenter();
		createResult();
	}

	private void createResult() {
		result.setFont(new Font("Comic sans ms", Font.PLAIN, 12));
		this.add(result, BorderLayout.SOUTH);
	}

	private void createCenter() {
		JPanel center = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
		JPanel form = new JPanel(new GridLayout(5, 2, 10,10));
		JButton compute = new JButton("Calculer"); compute.addActionListener(this::compute);
		cat= new JComboBox<>((priceCalculator.getCategories().toArray(new String[] {})));
		days= new JComboBox<>((priceCalculator.getDays().toArray(new String[] {})));
		
		form.add(new JLabel("Catégorie de place"));
		form.add(cat);
		form.add(new JLabel("Jour"));
		form.add(days);
		form.add(new JLabel("Age"));
		form.add(age);
		form.add(new JLabel(""));
		form.add(compute);
		center.add(form);
		this.add(center, BorderLayout.CENTER);
		
	}

	private void createHeader() {
		JPanel header = new JPanel(new FlowLayout());
		JLabel picLabel = new JLabel(new ImageIcon(this.getClass().getResource("ticket.jpg")));
		//picLabel.setPreferredSize(new Dimension(200, 100));
		header.add(picLabel);
		JLabel title = new JLabel("Prix du ticket");
		title.setFont(new Font("Comic sans ms", Font.PLAIN, 20));
		header.add(title);
		this.add(header, BorderLayout.NORTH);
		
	}

	private void compute(ActionEvent actionevent1) {
		int price = priceCalculator.computeWithNameOfDay(cat.getSelectedItem().toString().charAt(0), 
				days.getSelectedItem().toString(), (int) age.getValue());
		if (price == -1) 
			result.setText("Calcul impossible pour ces choix");
		else
			result.setText("Prix du ticket = "+ price + "€");
	}

}
