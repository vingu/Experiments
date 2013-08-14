package OrderProcesssing;
import java.util.ArrayList;

public class Order {
ArrayList<Product> products; 
ArrayList<Coupon> coupons;
Order() {
	products = new ArrayList<Product>();
	coupons = new ArrayList<Coupon>();
}
}


class calculateprice {
	public static void main(String args[]){
		Order ord = new Order();
		Product pro = new Product(1, "tomato", 2.5);
		Coupon cou = new Coupon(1, 1, "50% off all items");
		ord.products.add(pro);
		ord.coupons.add(cou);
		Product pro1 = new Product(1, "potato", 6.0);
		ord.products.add(pro1);
		
		int numofProducts = ord.products.size();
		Product curProduct;
		double totalPrice = 0;
		for (int i = 0; i < numofProducts; i++) {
			curProduct = ord.products.get(i);
			totalPrice += curProduct.price;
		}
		int numofCoupons = ord.coupons.size();
		Coupon curCou;
		for (int i = 0; i < numofCoupons; i++) {
			curCou = ord.coupons.get(i);
			switch (curCou.deal) {
			case "50% off all items": 
				totalPrice = totalPrice / 2;
				break;
			case "$10 off 10th item":
				int numof10th = numofProducts;
				for (int j = 1; j <= numof10th; j++){
					curProduct = ord.products.get(j * 10 -1);
					totalPrice -= curProduct.price / 2;
				}
				break;
			default:
			}
		}
		System.out.println("Total price :" + totalPrice);
	}
}