package controller;

import javafx.stage.Stage;
import model.grains.Grain;
import view.grain.input.AddGrainWindow;
import view.grain.input.EditGrainWindow;
import view.grain.input.GrainInputView;
import view.grain.input.RemoveGrainWindow;

/**
 * GrainTableHandle.java
 * 
 * Purpose:
**/

public class GrainTableHandle
{
	// Fields
	private GrainInputView inputView;
	private Stage modeWindow;
	
	
	
	/**
	 * GrainTableHandle Constructor
	 * 
	 * Purpose: 
	**/
	
	public GrainTableHandle (GrainInputView inputView)
	{
		this.inputView = inputView;
		this.modeWindow = null;
	} // GrainTableHandle Constructor
	
	
	
	/*
	 * 
	 */
	
	public void setToAdd (AddGrainWindow addWindow)
	{
		this.modeWindow = addWindow;
	}
	
	
	
	/*
	 * 
	 */
	
	public void setToRemove (RemoveGrainWindow removeWindow)
	{
		this.modeWindow = removeWindow;
	}
	
	
	
	/*
	 * 
	 */
	
	public void setToEdit (EditGrainWindow editWindow)
	{
		this.modeWindow = editWindow;
	}
	
	
	
	/*
	 * 
	 */
	
	public void addGrainToTable (Grain newGrain)
	{
		if (modeWindow instanceof AddGrainWindow)
			inputView.addRow(newGrain);
	}
	
	
	
	/*
	 * 
	 */
	
	public void removeGrainFromTable (int row)
	{
		if (modeWindow instanceof RemoveGrainWindow)
			inputView.removeRow(row);
	}
	
	
	
}
