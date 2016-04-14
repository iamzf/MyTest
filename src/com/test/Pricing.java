//1.先取出打球人自己的身份(own)和签嘉宾的身份(sign)。
//2.算价格逻辑：
//if (own is walkin || non_member) {
//	if (sign is member) {
//		if (该会员类型下的pricing_table里有这个good) {
//			goodPrice = pricing_table_price;
//		} else {
//			if (good is Green) {
//				goodPrice = 11-2界面中pricing table上方的那个列表中的价格;
//			} else {
//				goodPrice = 05_price;
//			}
//		}
//	} else if (sign is null) {
//		if (non_member的pricing_table里有这个good) {
//			goodPrice = pricing_table_price;
//		} else {
//			goodPrice = 05_price;
//		}
//	} else if (sign is agent or event) {
//		// 算自身价格
//		if (non_member的pricing_table里有这个good) {
//			own_goodPrice = pricing_table_price;
//		} else {
//			own_goodPrice = 05_price;
//		}
//		// 算签嘉宾（agent or event）价格
//		if (该agent或者event的pricing_table里有这个good) {
//			sign_goodPrice = pricing_table_price;
//		} else {
//			sign_goodPrice = 05_price;
//		}
//		// 最后取最便宜的
//		goodPrice = own_goodPrice 和 sign_goodPrice里边最便宜的;
//	}
//} else if (own is member) {
//	// 算自身会员价格
//	if (会员卡没过期 && 可用星期包含当天) {
//		if (该会员类型下的pricing_table里有这个good) {
//			own_goodPrice = pricing_table_price;
//		} else {
//			if (good is Green) {
//				own_goodPrice = 11-2界面中pricing table上方的那个列表中的价格;
//			} else {
//				own_goodPrice = 05_price;
//			}
//		}
//	} else {
//		own_goodPrice = 05_price;
//	}
//	if (sign is agent or event) {// 签agent或者event了
//		// 算签嘉宾（agent or event）价格
//		if (该agent或者event的pricing_table里有这个good) {
//			sign_goodPrice = pricing_table_price;
//		} else {
//			sign_goodPrice = 05_price;
//		}
//		// 最后去最便宜的
//		goodPrice = own_goodPrice 和 sign_goodPrice里边最便宜的;
//	} else if (sign is null) {// 没签，取自身会员价格
//		goodPrice = own_goodPrice;
//	}
//}
//3.走完2的一套逻辑下来，goodPrice就是一个商品的最后结算价钱。