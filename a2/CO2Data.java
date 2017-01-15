public class CO2Data {

	private String country;
	private double totalCO2;
	private double roadCO2;
	private double CO2PerPerson;
	private int carsPerPerson;
	
	public CO2Data() {
		country = "";
		totalCO2 = 0;
		roadCO2 = 0;
		CO2PerPerson = 0;
		carsPerPerson = 0;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public double getTotalCO2() {
		return totalCO2;
	}
	
	public void setTotalCO2(double totalCO2) {
		this.totalCO2 = totalCO2;
	}
	
	public double getRoadCO2() {
		return roadCO2;
	}
	
	public void setRoadCO2(double roadCO2) {
		this.roadCO2 = roadCO2;
	}
	
	public double getCO2PerPerson() {
		return CO2PerPerson;
	}
	
	public void setCO2PerPerson(double cO2PerPerson) {
		this.CO2PerPerson = cO2PerPerson;
	}
	
	public int getCarsPerPerson() {
		return carsPerPerson;
	}
	
	public void setCarsPerPerson(int carsPerPerson) {
		this.carsPerPerson = carsPerPerson;
	}
}
