
public class BidDetails {
	private int bid;
	private String email;
	private String sellerEmail;
	private int bidId;
	private String itemName;

	public BidDetails(int bid, String email, String sellerEmail, int bidId, String itemName) {
		super();
		this.bid = bid;
		this.email = email;
		this.sellerEmail = sellerEmail;
		this.bidId = bidId;
		this.itemName = itemName;

	}

	public int getBid() {

		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}

	public int getBidId() {
		return bidId;
	}

	public void setBidId(int bidId) {
		this.bidId = bidId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void displayBidMsg() {
		System.out.println("Incorrect bidding price");

	}

	public void displayMsg() {
		System.out.println("Bid has been successfully placed");
	}

}
