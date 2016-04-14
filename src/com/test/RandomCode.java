/**
 * Project Name: MyTest
 * File Name:	 RandomCode.java
 * Package Name: com.test
 * Date:		 2015-6-11上午9:06:54
 * Copyright (c) 2015, zhaofei466@163.com All Rights Reserved.
 *
 */

package com.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * ClassName:RandomCode <br/>
 * Function: iTee数据库生成4位随机码. <br/>
 * Date: 2015-6-11 上午9:06:54 <br/>
 * 
 * @author zf
 * @version
 */
public class RandomCode {
	// DB
	static DBHelper db = null;
	static PreparedStatement pst = null;
	static String sql = null;
	// 随机码单体
	static final String[] randomStr = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
			"e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
			"x", "y", "z" };
	// 随机码单体总数
	static final int randomNum = 36;
	// 临时存放随机码
	static ArrayList<RandomBean> tempRandomList = new ArrayList<RandomBean>();
	// 达到一定数量的时候打乱tempRandomList的顺序
	static int shuffleNum = 100000;
	// 俱乐部数量
	static int clubNum = 10;
	// 总线程循环标志（出现异常）
	static boolean threadRunFlag = true;
	// --------------中断时的5个索引--------------
	static int stop_i = 0;// 随机码第一位
	static int stop_j = 0;// 随机码第二位
	static int stop_k = 0;// 随机码第三位
	static int stop_m = 0;// 随机码第四位
	static int stop_n = 1;// 俱乐部
	// 当前要插入的随机码实体类
	static RandomBean currentRandomBean;
	// 最后插入的随机码总数量
	static int totalCount = 0;

	public static void main(String[] args) {
		sql = "insert into random_booking_no(random_code,club_id) values (?,?)";

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (threadRunFlag) {
					try {
						insertRandomToDB(stop_i, stop_j, stop_k, stop_m, stop_n);
					} catch (Exception e) {
						e.printStackTrace();
						threadRunFlag = true;
					}
				}
			}
		}).start();
	}

	private static void insertRandomToDB(int int1, int int2, int int3, int int4, int int5) throws Exception {
		if (db == null) {
			db = new DBHelper();
		}

		try {
			if (db != null) {
				pst = db.conn.prepareStatement(sql);

				int i = int1;
				int j = int2;
				int k = int3;
				int m = int4;
				int n = int5;

				RandomBean rb;
				for (; n <= clubNum; n++) {
					for (; i < randomNum; i++) {
						String str1 = randomStr[i];
						for (; j < randomNum; j++) {
							String str2 = randomStr[j];
							for (; k < randomNum; k++) {
								String str3 = randomStr[k];
								for (; m < randomNum; m++) {
									String str4 = randomStr[m];

									StringBuffer sb = new StringBuffer();
									sb.append(str1).append(str2).append(str3).append(str4);

									rb = new RandomBean();
									rb.code = sb.toString();
									rb.i = i;
									rb.j = j;
									rb.k = k;
									rb.m = m;
									rb.n = n;

									tempRandomList.add(rb);

									if (tempRandomList.size() == shuffleNum) {// 达到一定数量，开始插入数据库
										// 打乱顺序
										Collections.shuffle(tempRandomList);
										for (int index_temp = 0; index_temp < tempRandomList.size(); index_temp++) {
											currentRandomBean = tempRandomList.get(index_temp);
											insert(index_temp);
										}
										tempRandomList.clear();
										System.gc();
									} else {
										if (i == randomNum - 1 && n == clubNum && j == randomNum - 1
												&& k == randomNum - 1 && m == randomNum - 1) {// 最后一波，没达到规定数量也要插入数据库
											Collections.shuffle(tempRandomList);
											for (int index_temp = 0; index_temp < tempRandomList.size(); index_temp++) {
												currentRandomBean = tempRandomList.get(index_temp);
												insert(index_temp);
											}
										}
									}
								}
								if (m == randomNum) {
									m = 0;
								}
							}
							if (k == randomNum) {
								k = 0;
							}
						}
						if (j == randomNum) {
							j = 0;
						}
					}
					if (i == randomNum) {
						i = 0;
					}
				}
				if (n == clubNum + 1) {// 最后一个俱乐部已经插完
					threadRunFlag = false;
					System.out.println("--------------------------------------");
					System.out.println("--------------------------------------");
					System.out.println("     =====    ==    =    =====        ");
					System.out.println("     =        = =   =    =    =       ");
					System.out.println("     =====    =  =  =    =    =       ");
					System.out.println("     =        =   = =    =    =       ");
					System.out.println("     =====    =    ==    =====        ");
					System.out.println("--------------------------------------");
					System.out.println("------" + "count :" + totalCount + "-------");

					if (db != null) {
						db.close();
					}
					if (pst != null) {
						try {
							pst.close();
						} catch (SQLException e) {
							e.printStackTrace();
						} finally {
							pst = null;
						}
					}
				}
			}
		} catch (Exception e) {
			tempRandomList.clear();
			stop_i = currentRandomBean.i;
			stop_j = currentRandomBean.j;
			stop_k = currentRandomBean.k;
			stop_m = currentRandomBean.m;
			stop_n = currentRandomBean.n;
			e.printStackTrace();
			throw e;
		}
	}

	static class RandomBean {
		String code;
		int i;
		int j;
		int k;
		int m;
		int n;
	}

	private static void insert(int index) {
		int insertFlag = 0;
		while (insertFlag != 1) {
			try {
				if (pst == null || pst.isClosed()) {
					if (db == null) {
						db = new DBHelper();
					}
					pst = db.conn.prepareStatement(sql);
				}
				pst.setObject(1, currentRandomBean.code);
				pst.setObject(2, currentRandomBean.n);
				insertFlag = pst.executeUpdate();
				if (insertFlag == 1) {
					totalCount++;
				}
			} catch (Exception e) {
				File exceptionInfo = new File("D:\\iTee\\exception.txt");
				BufferedWriter bw = null;
				try {
					bw = new BufferedWriter(new FileWriter(exceptionInfo));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				stop_i = currentRandomBean.i;
				stop_j = currentRandomBean.j;
				stop_k = currentRandomBean.k;
				stop_m = currentRandomBean.m;
				stop_n = currentRandomBean.n;
				StringBuffer sb = new StringBuffer();
				sb.append("stop_i:" + stop_i + "\r\n");
				sb.append("stop_j:" + stop_j + "\r\n");
				sb.append("stop_k:" + stop_k + "\r\n");
				sb.append("stop_m:" + stop_m + "\r\n");
				sb.append("stop_n:" + stop_n + "\r\n");
				try {
					bw.write(sb.toString());
					bw.flush();
					bw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				insertFlag = 0;
				e.printStackTrace();
			}
		}
	}
}
