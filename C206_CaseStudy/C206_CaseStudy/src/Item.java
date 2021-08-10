
public class Item {
	private String name;
	private String description;
	private int minBidPrice;
	private String auctionStart;
	private String auctionEnd;

	public Item(String name, String description, int minBidPrice, String auctionStart, String auctionEnd) {
		this.name = name;
		this.description = description;
		this.minBidPrice = minBidPrice;
		this.auctionStart = auctionStart;
		this.auctionEnd = auctionEnd;
	}

	public String getItemName() {
		return name;
	}

	public String getItemDescription() {
		return description;
	}

	public int getMinBidPrice() {
		return minBidPrice;
	}

	public String getAuctionStart() {
		return auctionStart;
	}

	public String getAuctionEnd() {
		return auctionEnd;
	}

	public void setAuctionEnd(String auctionEnd) {
		this.auctionEnd = auctionEnd;
	}

	public void setAuctionStart(String auctionStart) {
		this.auctionStart = auctionStart;
	}

}
