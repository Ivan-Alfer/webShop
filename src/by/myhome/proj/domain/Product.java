package by.myhome.proj.domain;

public class Product {

	private String productName;
	private String productDescription;
	private String productPrice;
	private Integer productId;
	private Integer categoryId;
	private Integer firmId;
	private String productCategory;
	private String productFirm;

	
	
	public Integer getProductId() {
		return productId;
	}
	public void setId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getFirmId() {
		return firmId;
	}
	public void setFirmId(Integer firmId) {
		this.firmId = firmId;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductFirm() {
		return productFirm;
	}
	public void setProductFirm(String productFirm) {
		this.productFirm = productFirm;
	}
	
}
