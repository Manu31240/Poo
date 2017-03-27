public class DePipe extends De {
	private int facePipee;

	@Override
	public void lancer() {
		super.lancer();
		if (Math.random() >= 0.5)
			setFace(facePipee);
	}

	public void setFacePipee(int facePipee) {
		this.facePipee = facePipee;
	}

}
