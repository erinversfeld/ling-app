package versveld.erin.ngequizapp;

/*
 * This class handles the rendering of the image
 */
public class QuestionImage {
	
	private String imageDirectory;
	
	public QuestionImage(String fileDirectory){
		imageDirectory = fileDirectory;
	}
	
	public String getImageDirectory(){
		return imageDirectory;
	}
	
	public void setImageDirectory(String newDirectory){
		imageDirectory = newDirectory;
	}
}
