package versveld.erin.ngequizapp;

public class SoundClip {
	
	private String soundClipFileDirectory;
	
	public SoundClip(String fileDirectory){
		soundClipFileDirectory = fileDirectory;
	}
	
	public String getSoundClipDirectory(){
		return soundClipFileDirectory;
	}
	
	public void setSoundClipDirectory(String newDirectory){
		soundClipFileDirectory = newDirectory;
	}
}
