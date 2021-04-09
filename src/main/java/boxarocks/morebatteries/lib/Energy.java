package boxarocks.morebatteries.lib;

public enum Energy {
	
	MoreBatteries("MoreBatteries", "Qf");
	
	private String name;
	private String symbol;
	
	Energy(String name, String symbol) {
		this.name = name;
		this.symbol = symbol;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public String getPlural() {
		return name + "s";
	}
}
