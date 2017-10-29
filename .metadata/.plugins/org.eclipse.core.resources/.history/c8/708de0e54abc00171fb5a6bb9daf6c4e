package view;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.grains.Grain;

/**
 * 
**/

public class GrainInputView extends Pane
{
	// GUI Labels
	private static final String GRAINS = "Grains";
	
	private static final String GRAIN_NUMBER   = "#";
	private static final String LENGTH         = "Length";
	private static final String OUTER_DIAMETER = "Outer Diameter";
	private static final String INNER_DIAMETER = "Inner Diameter";
	private static final String BURNING_ENDS   = "Burning Ends";
	
	private static final String ADD    = "Add";
	private static final String REMOVE = "Remove";
	private static final String EDIT   = "Edit";
	
	private static final String EMPTY_TEXT   = "No Grains Added Yet";
	private static final String CENTER_ALIGN = "-fx-alignment: CENTER";
	
	private static final String EMPTY = "";
	
	
	
	// Constants
	
	
	
	
	// GUI Components
	private Text grainText;
	private TableView<GrainRow> table;
	private Button addButton;
	private Button removeButton;
	private Button editButton;
	
	
	
	// Private fields
	int grainAmount;
	
	
	
	/**
	 * GrainInputView Constructor
	 * 
	 * Purpose:
	**/
	
	@SuppressWarnings("unchecked")
	public GrainInputView ()
	{
		// Create the GridPane
		super();
		
		// Initialize empty list
		grainAmount = 0;
		
		// Add title text
		grainText = new Text(GRAINS);
		grainText.setTranslateX(235);
		grainText.setTranslateY(20);
		this.getChildren().add(grainText);
		
		// Configure table
		table = new TableView<GrainRow>();
		table.setPlaceholder(new Label(EMPTY_TEXT));
		table.setEditable(false);
		table.setTranslateX(0);
		table.setTranslateY(30);
		table.setPrefHeight(230);
		this.getChildren().add(table);
		
		// Add all columns
		TableColumn<GrainRow, String> numberCol = new TableColumn<GrainRow, String>(GRAIN_NUMBER);
		numberCol.setResizable(false);
        numberCol.setCellValueFactory(new PropertyValueFactory<GrainRow, String>("Number"));
        numberCol.setPrefWidth(30);
        numberCol.setStyle(CENTER_ALIGN);

        TableColumn<GrainRow, String> lengthCol = new TableColumn<GrainRow, String>(LENGTH);
        lengthCol.setResizable(false);
        lengthCol.setCellValueFactory(new PropertyValueFactory<GrainRow,String>("Length"));
        lengthCol.setPrefWidth(80);
        lengthCol.setStyle(CENTER_ALIGN);
		
        TableColumn<GrainRow, String> outerDCol = new TableColumn<GrainRow, String>(OUTER_DIAMETER);
        outerDCol.setResizable(false);
        outerDCol.setCellValueFactory(new PropertyValueFactory<GrainRow,String>("OuterDiameter"));
        outerDCol.setPrefWidth(140);
        outerDCol.setStyle(CENTER_ALIGN);
        
        TableColumn<GrainRow, String> innerDCol = new TableColumn<GrainRow, String>(INNER_DIAMETER);
        innerDCol.setResizable(false);
        innerDCol.setCellValueFactory(new PropertyValueFactory<GrainRow,String>("InnerDiameter"));
        innerDCol.setPrefWidth(140);
        innerDCol.setStyle(CENTER_ALIGN);
        
        TableColumn<GrainRow, String> burningEndsCol = new TableColumn<GrainRow, String>(BURNING_ENDS);
        burningEndsCol.setResizable(false);
        burningEndsCol.setCellValueFactory(new PropertyValueFactory<GrainRow,String>("BurningEnds"));
        burningEndsCol.setPrefWidth(120);
        burningEndsCol.setStyle(CENTER_ALIGN);
        
     // Add columns to the table
        table.getColumns().addAll(numberCol, lengthCol, outerDCol, innerDCol, burningEndsCol);
        
        // Add all buttons
        addButton = new Button(ADD);
    	addButton.setTranslateX(0);
		addButton.setTranslateY(270);
		addButton.setPrefHeight(35);
		addButton.setPrefWidth(150);
		addButton.setDisable(false);
		this.getChildren().add(addButton);
		addButton.setOnAction(new EventHandler<ActionEvent> ()
		{
		    @Override public void handle (ActionEvent e)
		    {
		    	Stage addGrain = new AddGrainWindow();
		    	addGrain.show();
		    }
		});
		
		removeButton = new Button(REMOVE);
		removeButton.setTranslateX(181);
		removeButton.setTranslateY(270);
		removeButton.setPrefHeight(35);
		removeButton.setPrefWidth(150);
		removeButton.setDisable(false);
		this.getChildren().add(removeButton);
		removeButton.setOnAction(new EventHandler<ActionEvent> ()
		{
			@Override
			public void handle (ActionEvent e)
			{
				Stage removeGrain = new RemoveGrainWindow();
				removeGrain.show();
			}
		});
		
		
		
		editButton = new Button(EDIT);
		editButton.setTranslateX(362);
		editButton.setTranslateY(270);
		editButton.setPrefHeight(35);
		editButton.setPrefWidth(150);
		editButton.setDisable(false);
		this.getChildren().add(editButton);
		editButton.setOnAction(new EventHandler<ActionEvent> ()
		{
			@Override
			public void handle (ActionEvent e)
			{
				Stage editGrain = new EditGrainWindow();
				editGrain.show();
			}
		});
	} // GrainInputView Constructor
	
	
	
	/**
	 * 
	**/
	
	public void addRow (Grain newGrain)
	{
		table.getItems().add(new GrainRow(++grainAmount, newGrain));
	} // addRow()
	
	
	
	/*
	 * 
	 */
	
	public void removeRow (int index)
	{
		table.getItems().remove(index);
	}
	
	
	
	
	
	/**
	 * 
	**/
	
	public class GrainRow
	{
		private int number;
		private double length;
		private double outerDiameter;
		private double innerDiameter;
		private int numBurningEnds;
		
		
		
		/**
		 * 
		**/
		
		public GrainRow (int grainNumber, Grain grain)
		{
			this.number = grainNumber;
			this.length = grain.getLength();
			this.outerDiameter = grain.getOuterDiameter();
			this.innerDiameter = grain.getInnerDiameter();
			this.numBurningEnds = grain.getNumBurningEnds();
		}
		
		
		
		/**
		 * 
		**/
		
		public int getNumber ()
		{
			return number;
		}
		
		
		public double getLength ()
		{
			return length;
		}
		
		
		
		/**
		 * 
		**/
		
		public double getOuterDiameter ()
		{
			return outerDiameter;
		}
		
		
		
		/**
		 * 
		**/
		
		public double getInnerDiameter ()
		{
			return innerDiameter;
		}
		
		
		
		/**
		 * 
		**/
		
		public int getBurningEnds ()
		{
			return numBurningEnds;
		}
		
	} // class GrainRow
	
} // class GrainInputView
