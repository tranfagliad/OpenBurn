package view.grain.input;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.IntegerBinding;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.grains.CylindricalGrain;
import model.grains.Grain;

/**
 * GrainInputView.java
 * 
 * Purpose: Contains all the components for grain input
 * 		in the OpenBurn graphical user interface.
**/

public class GrainInputView extends Pane
{
	// Labels
	private static final String GRAINS         = "Grains";
	private static final String GRAIN_ID       = "#";
	private static final String LENGTH         = "Length";
	private static final String OUTER_DIAMETER = "Outer Diameter";
	private static final String INNER_DIAMETER = "Inner Diameter";
	private static final String BURNING_ENDS   = "Burning Ends";
	private static final String ADD            = "Add";
	private static final String REMOVE         = "Remove";
	private static final String EDIT           = "Edit";
	private static final String EMPTY_TEXT     = "No Grains Added Yet";
	private static final String CENTER_ALIGN   = "-fx-alignment: CENTER";
	
	
	
	// Constants
	
	
	
	
	// GUI Components
	private Text grainText;
	public TableView<Grain> table;
	private Button addButton;
	private Button removeButton;
	private Button editButton;
	
	
	
	/**
	 * GrainInputView Constructor
	 * 
	 * Purpose:
	**/
	
	public GrainInputView ()
	{
		// Invoke Pane super constructor
		super();
		
		// Add components
		addTableTitle();
		configureTable();
		addAddButton();
        addRemoveButton();
        addEditButton();
	} // GrainInputView Constructor
	
	
	
	/**
	 * addRow()
	 * 
	 * Purpose: Uses the given inputs 
	 * 
	 * Parameters:
	 * 		double grainLength -- 
	 * 		double grainOuterDiameter -- 
	 * 		double grainInnerDiameter -- 
	 * 		int grainBurningEnds -- 
	 * 
	 * Returns: void.
	**/
	
	public void addRow (double grainLength, double grainOuterDiameter,
						double grainInnerDiameter, int grainBurningEnds)
	{
		table.getItems().add(new CylindricalGrain(grainLength, grainOuterDiameter,
												  grainInnerDiameter, grainBurningEnds));
	} // addRow()
	
	
	
	/**
	 * 
	**/
	
	public void removeRow (int index)
	{
		table.getItems().remove(index);
	} // removeRow()
	
	
	
	/*
	 * 
	 */
	
	private void addTableTitle ()
	{
		grainText = new Text(GRAINS);
		grainText.setTranslateX(235);
		grainText.setTranslateY(20);
		this.getChildren().add(grainText);
	}
	
	
	
	/*
	 * 
	 */
	
	private void configureTable ()
	{
		table = new TableView<Grain>();
		table.setPlaceholder(new Label(EMPTY_TEXT));
		table.setEditable(false);
		table.setTranslateX(0);
		table.setTranslateY(30);
		table.setPrefHeight(230);
		this.getChildren().add(table);
		setTableColumns();
	}
	
	
	
	/**
	 * 
	**/
	
	@SuppressWarnings("unchecked")
	private void setTableColumns ()
	{
		// Grain ID column
		TableColumn<Grain, String> grainIDCol = new TableColumn<Grain, String>(GRAIN_ID);
		grainIDCol.setResizable(false);
        grainIDCol.setCellValueFactory(new PropertyValueFactory<Grain, String>("GrainID"));
        grainIDCol.setPrefWidth(30);
        grainIDCol.setStyle(CENTER_ALIGN);
        
        // Length column
        TableColumn<Grain, String> lengthCol = new TableColumn<Grain, String>(LENGTH);
        lengthCol.setResizable(false);
        lengthCol.setCellValueFactory(new PropertyValueFactory<Grain,String>("Length"));
        lengthCol.setPrefWidth(80);
        lengthCol.setStyle(CENTER_ALIGN);
		
        // Outer Diameter column
        TableColumn<Grain, String> outerDCol = new TableColumn<Grain, String>(OUTER_DIAMETER);
        outerDCol.setResizable(false);
        outerDCol.setCellValueFactory(new PropertyValueFactory<Grain,String>("OuterDiameter"));
        outerDCol.setPrefWidth(140);
        outerDCol.setStyle(CENTER_ALIGN);
        
        // Inner Diameter column
        TableColumn<Grain, String> innerDCol = new TableColumn<Grain, String>(INNER_DIAMETER);
        innerDCol.setResizable(false);
        innerDCol.setCellValueFactory(new PropertyValueFactory<Grain,String>("InnerDiameter"));
        innerDCol.setPrefWidth(140);
        innerDCol.setStyle(CENTER_ALIGN);
        
        // Number of Burning Ends column
        TableColumn<Grain, String> burningEndsCol = new TableColumn<Grain, String>(BURNING_ENDS);
        burningEndsCol.setResizable(false);
        burningEndsCol.setCellValueFactory(new PropertyValueFactory<Grain,String>("NumBurningEnds"));
        burningEndsCol.setPrefWidth(120);
        burningEndsCol.setStyle(CENTER_ALIGN);
        
        // Add columns to the table
        table.getColumns().addAll(grainIDCol, lengthCol, outerDCol, innerDCol, burningEndsCol);
	} // setTableColumns()
	
	
	
	/**
	 * addAddButton()
	 * 
	 * Purpose:
	 * 
	 * Parameters: None.
	 * 
	 * Returns: void.
	**/
	
	private void addAddButton ()
	{
		// Initialize add button
		addButton = new Button(ADD);
    	addButton.setTranslateX(0);
		addButton.setTranslateY(270);
		addButton.setPrefHeight(35);
		addButton.setPrefWidth(150);
		addButton.setDisable(false);
		this.getChildren().add(addButton);
		
		// Open new window on click
		addButton.setOnAction(new EventHandler<ActionEvent> ()
		{
		    @Override public void handle (ActionEvent e)
		    {
		    	Stage addGrain = new AddGrainWindow();
		    	addGrain.show();
		    }
		});
	} // addAddButton()
	
	
	
	/**
	 * 
	**/
	
	private void addRemoveButton ()
	{
		// Initialize remove button
		removeButton = new Button(REMOVE);
		removeButton.setTranslateX(181);
		removeButton.setTranslateY(270);
		removeButton.setPrefHeight(35);
		removeButton.setPrefWidth(150);
		removeButton.setDisable(false);
		this.getChildren().add(removeButton);
		
		// Open new window on click
		removeButton.setOnAction(new EventHandler<ActionEvent> ()
		{
			@Override
			public void handle (ActionEvent e)
			{
				Stage removeGrain = new RemoveGrainWindow();
				removeGrain.show();
			}
		});
		
		//
		BooleanBinding tableSizeIsZero = new BooleanBinding()
		{
			@Override
			protected boolean computeValue()
			{
				return table.getItems().isEmpty();
			}
		};
		
		removeButton.disableProperty().bind(tableSizeIsZero);
	} // addRemoveButton()
	
	
	
	/**
	 * 
	**/
	
	private void addEditButton ()
	{
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
		
		BooleanBinding tableSizeIsZero = new BooleanBinding()
		{
			@Override
			protected boolean computeValue()
			{
				return table.getItems().isEmpty();
			}
		};
		
		editButton.disableProperty().bind(tableSizeIsZero);
	} // addEditButton()
	
} // class GrainInputView
