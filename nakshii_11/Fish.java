package nakshii_11;

public class Fish {
		private String fishimage;
		private String fishpressedImage;
		public String getFishimage() {
			return fishimage;
		}
		public void setFishimage(String fishimage) {
			this.fishimage = fishimage;
		}
		public String getFishpressedImage() {
			return fishpressedImage;
		}
		public void setFishpressedImage(String fishpressedImage) {
			this.fishpressedImage = fishpressedImage;
		}
		public Fish(String fishimage, String fishpressedImage) {
			super();
			this.fishimage = fishimage;
			this.fishpressedImage = fishpressedImage;
		}

}
