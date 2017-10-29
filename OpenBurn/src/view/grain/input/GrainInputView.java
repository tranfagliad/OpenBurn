package view.grain.input;

import javafx.beans.binding.BooleanBinding;
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
	private static final int TITLE_X          = 235;
	private static final int TITLE_Y          = 20;
	private static final int TABLE_Y          = 30;
	private static final int TABLE_HEIGHT     = 230;
	private static final int ID_COL_WIDTH     = 30;
	private static final int LENGTH_COL_WIDTH = 80;
	//private static final int
	//private static final int
	//private static final int
	private static final int BUTTON_WIDTH  = 150;
	private static final int BUTTON_HEIGHT = 35;
	
	
	
	// GUI Components
	private Text grainText;
	public TableView<Grain> table;
	private Button addButton;
	private Button removeButton;
	private Button editButton;
	
	
	
	/**
	 * GrainInputView Constructor
	 * 
	 * Purpose: Creates and initializes the grain input table, along
	 * 		with Add, Remove, and Edit buttons underneath.
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
	 * Purpose: Uses the given inputs to create a Grain and inserts it
	 * 		to the Grain table as a new row.
	 * 
	 * Parameters:
	 * 		double grainLength -- Length of a grain.
	 * 		double grainOuterDiameter -- Outer diameter of a grain.
	 * 		double grainInnerDiameter -- Inner diameter of a grain.
	 * 		int grainBurningEnds -- Number of burning ends of a grain.
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
	 * removeRow()
	 * 
	 * Purpose: Removes the specified grain row from the table.
	 * 
	 * Parameters:
	 * 		int row -- The grain row to remove.
	 * 
	 * Returns: void.
	**/
	
	public void removeRow (int row)
	{
		table.getItems().remove(row);
	} // removeRow()
	
	
	
	/**
	 * addTableTitle()
	 * 
	 * Purpose: Adds the table title to the Pane.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: void.
	**/
	
	private void addTableTitle ()
	{
		grainText = new Text(GRAINS);
		grainText.setTranslateX(TITLE_X);
		grainText.setTranslateY(TITLE_Y);
		this.getChildren().add(grainText);
	} // addTableTitle()
	
	
	
	/**
	 * configureTable()
	 * 
	 * Purpose: Initializes the details of the grain input table
	 * 		and adds it to the Pane.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: void.
	**/
	
	private void configureTable ()
	{
		table = new TableView<Grain>();
		table.setPlaceholder(new Label(EMPTY_TEXT));
		table.setEditable(false);
		table.setTranslateY(TABLE_Y);
		table.setPrefHeight(TABLE_HEIGHT);
		this.getChildren().add(table);
		setTableColumns();
	} // configureTable()
	
	
	
	/**
	 * setTableColumns()
	 * 
	 * Purpose: Creates and configures the columns for the
	 * 		grain input table, then adds them to the table.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: void.
	**/
	
	@SuppressWarnings("unchecked")
	private void setTableColumns ()
	{
		// Grain ID column
		TableColumn<Grain, String> grainIDCol = new TableColumn<Grain, String>(GRAIN_ID);
		grainIDCol.setResizable(false);
        grainIDCol.setCellValueFactory(new PropertyValueFactory<Grain, String>("GrainID"));
        grainIDCol.setPrefWidth(ID_COL_WIDTH);
        grainIDCol.setStyle(CENTER_ALIGN);
        
        // Length column
        TableColumn<Grain, String> lengthCol = new TableColumn<Grain, String>(LENGTH);
        lengthCol.setResizable(false);
        lengthCol.setCellValueFactory(new PropertyValueFactory<Grain,String>("Length"));
        lengthCol.setPrefWidth(LENGTH_COL_WIDTH);
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
	 * Purpose: Adds the Add button to the Pane. Sets the event
	 * 		handler for when the button is clicked.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: void.
	**/
	
	private void addAddButton ()
	{
		// Initialize add button
		addButton = new Button(ADD);
		addButton.setTranslateY(270);
		addButton.setPrefHeight(BUTTON_HEIGHT);
		addButton.setPrefWidth(BUTTON_WIDTH);
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
	 * addRemoveButton()
	 * 
	 * Purpose: Adds the Add button to the Pane. Sets the event
	 * 		handler for when the button is clicked. Sets the
	 * 		binding for when to disable the button.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: void.
	**/
	
	private void addRemoveButton ()
	{
		// Initialize remove button
		removeButton = new Button(REMOVE);
		removeButton.setTranslateX(181);
		removeButton.setTranslateY(270);
		removeButton.setPrefHeight(BUTTON_HEIGHT);
		removeButton.setPrefWidth(BUTTON_WIDTH);
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
		
		// Disable the button when the table is empty
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
	 * addEditButton()
	 * 
	 * Purpose: Adds the Edit button to the Pane. Sets the event
	 * 		handler for when the button is clicked. Sets the
	 * 		binding for when to disable the button.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: void.
	**/
	
	private void addEditButton ()
	{
		// Initialize edit button
		editButton = new Button(EDIT);
		editButton.setTranslateX(362);
		editButton.setTranslateY(270);
		editButton.setPrefHeight(BUTTON_HEIGHT);
		editButton.setPrefWidth(BUTTON_WIDTH);
		editButton.setDisable(false);
		this.getChildren().add(editButton);
		
		// Open new window on click
		editButton.setOnAction(new EventHandler<ActionEvent> ()
		{
			@Override
			public void handle (ActionEvent e)
			{
				Stage editGrain = new EditGrainWindow();
				editGrain.show();
			}
		});
		
		// Disable the button when the table is empty
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
