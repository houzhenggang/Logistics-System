package po;

public class MoneyInformationListPO extends ListPO{
	/**
	 * 成本收益日期
	 */
	private String time;
	/**
	 * 当日收入
	 */
	private double moneyIn;
	/**
	 * 当日支出
	/**
	 */
	private double moneyOut;	
	
	
	public MoneyInformationListPO(String time, double moneyIn, double moneyOut)
	 {
		super();
		this.time = time;
		this.moneyIn = moneyIn;
		this.moneyOut = moneyOut;
	}
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getMoneyIn() {
		return moneyIn;
	}

	public void setMoneyIn(double moneyIn) {
		this.moneyIn = moneyIn;
	}

	public double getMoneyOut() {
		return moneyOut;
	}

	public void setMoneyOut(double moneyOut) {
		this.moneyOut = moneyOut;
	}

	public double getProfit() {
		return moneyIn-moneyOut;
	}


}