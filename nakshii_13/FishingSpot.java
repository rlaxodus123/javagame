package nakshii_13;

public class FishingSpot {
	private String stagename;
	private String stageimage;
	private String gameImage;
	
	public String getStagename() {
		return stagename;
	}
	public void setStagename(String stagename) {
		this.stagename = stagename;
	}
	public String getStageimage() {
		return stageimage;
	}
	public void setStageimage(String stageimage) {
		this.stageimage = stageimage;
	}
	public String getGameImage() {
		return gameImage;
	}
	public void setGameImage(String gameImage) {
		this.gameImage = gameImage;
	}
	public FishingSpot(String stageimage, String stagename, String gameImage) {
		super();
		this.stageimage = stageimage;
		this.stagename = stagename;
		this.gameImage = gameImage;
	}


	

}
