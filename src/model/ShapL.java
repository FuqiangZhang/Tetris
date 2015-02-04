package model;

public class ShapL extends Component{
	private int[][] components = {
			{ 1, 1, 1, 1, 01, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },// state one init 
			{ 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0 },// state two turn once
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 },
			{ 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1 }, };
	
	public ShapL(){
		super.components = components;
	}
}
